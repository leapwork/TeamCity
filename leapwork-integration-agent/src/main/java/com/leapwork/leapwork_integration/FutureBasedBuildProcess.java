package com.leapwork.leapwork_integration;


import jetbrains.buildServer.RunBuildException;
import jetbrains.buildServer.agent.BuildFinishedStatus;
import jetbrains.buildServer.agent.BuildProcess;
import jetbrains.buildServer.agent.BuildProgressLogger;
import jetbrains.buildServer.agent.BuildRunnerContext;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.*;

abstract class FutureBasedBuildProcess implements BuildProcess, Callable<BuildFinishedStatus>
{
    @NotNull protected final BuildProgressLogger logger;
    private Future<BuildFinishedStatus> runPluginExecution;

    public FutureBasedBuildProcess(@NotNull final BuildRunnerContext context) {
        this.logger = context.getBuild().getBuildLogger();
    }

    public void start() throws RunBuildException
    {
        try {
            runPluginExecution = Executors.newSingleThreadExecutor().submit(this);
        } catch (final RejectedExecutionException e) {
            logger.error("Failed to start build");
            logger.exception(e);
            throw new RunBuildException(e);
        }
    }

    public boolean isInterrupted()
    {
        return runPluginExecution.isCancelled() && isFinished();
    }

    public boolean isFinished()
    {
        return runPluginExecution.isDone();
    }

    protected abstract void cancelBuild();

    public void interrupt()
    {
        logger.message("Attempt to interrupt build process");
        cancelBuild();
        runPluginExecution.cancel(true);
    }

    @NotNull
    public BuildFinishedStatus waitFor() throws RunBuildException
    {
        try {
            final BuildFinishedStatus status = runPluginExecution.get();
            return status;
        } catch (final InterruptedException e) {
            throw new RunBuildException(e);
        } catch (final ExecutionException e) {
            throw new RunBuildException(e);
        } catch (final CancellationException e) {
            logger.exception(e);
            return BuildFinishedStatus.INTERRUPTED;
        }
    }
}