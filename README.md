# Leapwork-Integration
This is Leapwork plugin for Teamcity

# More Details
Leapwork has created the world’s most accessible automation platform. Through a visual, no-code approach, Leapwork makes it easy for business and IT users to automate repetitive processes, so enterprises can adopt and scale automation faster. Leapwork is used by more than 400 global enterprises across all industries, from banks and insurance companies to life science, government and aerospace. Clients include NASA, PayPal, BNP Paribas and Daimler. The company is headquartered in Copenhagen, Denmark, and has local offices across Europe, US and Asia. You can easily configure integration directly in Teamcity enjoying UI friendly configuration page with easy connection and test suites selection.

# Features:
 - Setup and test Leapwork connection in few clicks
 - Run automated tests in your Teamcity build tasks
 - Automatically receive test results
 - Build status based tests results
 - Write tests trace to build output log
 - Smart UI
 
# Installing
- Use maven.
- Command: mvn package 
- Or simply install zip-file from the "target" folder: Copy the zip plugin package into the {TeamCity Data Directory}/plugins directory (Default path: C:\ProgramData\JetBrains\TeamCity\plugins). 
- If you have an earlier version of the plugin in the directory, remove it.
- Alternatively, use the Administration -> Plugins List -> Upload plugin zip -> Choose File -> Choose that zip-file -> Press Upload plugin zip

# Update 4.0.1
- Leapwork version 2021.1 is now supported
- Plugin is now using Leapwork API v4

# Instruction
1. Add Build-Step "Leapwork Integration" to your project.
2. Enter your Leapwork controller hostname or IP-address something like "win10-agent20" or "localhost".
3. Enter your Leapwork controller API port, by default it is 9001.
4. Enter time delay in seconds. When schedule is run, plugin will wait this time before trying to get schedule state. If schedule is still running, plugin will wait this time again. By default this value is 5 seconds.
5. Select how plugin should set "Done" status value: to Success or Failed.
6. Press button "Select Schedules" to get a list of all available schedules. Select schedules you want to run.
7. Run your project and get results. Enjoy!

# Troubleshooting
- If you catch an error "No such run [runId]!" after schedule starting, increase time delay parameter.
