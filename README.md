# Leapwork Integration
Easily include Leapwork as part of the build definitions in TeamCity using the native plugin

# More Details
Leapwork’s completely visual, no-code automation platform makes it easy for business and IT users to automate repetitive processes, so enterprises can adopt and scale automation faster. For rapid results, at lower cost, and requiring fewer specialist resources than traditional automation approaches.

# Features:
 - Setup and test Leapwork connection in few clicks
 - Run automation flows in your TeamCity build tasks
 - Automatically receive results
 - Build status based results
 
# Installing
- Use maven.
- Command: mvn package 
- Or simply install Leapwork.zip file from the "Releases" section: Copy the Leapwork.zip plugin package into the {TeamCity Data Directory}/plugins directory (Default path: C:\ProgramData\JetBrains\TeamCity\plugins). 
- If you have an earlier version of the plugin in the directory, remove it.
- Alternatively, use the Administration -> Plugins List -> Upload plugin zip -> Choose File -> Choose that zip-file -> Press Upload plugin zip

# Instruction
1. Add Build-Step "Leapwork Integration" to your project
2. Enter your Leapwork Controller hostname or IP-address, for example "win10-controller"
3. Enter your Leapwork Controller API port (by default it is 9001)
4. Enter Time Delay in seconds. When schedule is running, plugin will wait this time before trying to get schedule state. If schedule is still running, plugin will wait this time again. By default this value is 5 seconds
5. Select how plugin should process "Done" status value: to Success or Failed
6. Save the changes, to get available Schedules.
7. Press button "Select Schedules" to get a list of all available schedules, select schedules you want to run
8. Run your project and get results. Enjoy!

# Troubleshooting
- If you catch an error "No such run [runId]!" after schedule starting, increase time delay parameter.
