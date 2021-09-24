##Can't Start Tomcat - Ports are in Use

You may have a problem starting Tomcat. You may see this ugly error message about ports in use.


Solution

You can use the troubleshooting tips below.

Troubleshooting Tip #1

1. Exit Eclipse

2. Open a web web browser and visit, http://localhost:8080

3. If you see a "Tomcat" web page then that means Tomcat is running as a Windows service. To stop Tomcat running as a Windows services, open your Windows Control Panel. Find the service "Apache Tomcat" and stop it.

4. If you don't see a "Tomcat" web page, then stop the appropriate process displayed.



--
Troubleshooting Tip #2 - GUI Option

Steps to free port which is already used to run Tomcat server in Eclipse

1. On MS Windows, select Start > All Programs  > Accessories > System Tools >Resource Monitor

2. Expand the Network Tab

3. Move to the section for Listening Ports

4. Look in the Port column and scroll to find entry for port 8080

5. Select the given process and delete/kill the process

6. Return back to Eclipse and start the Tomcat Server, it should start up now.



---

Troubleshooting Tip #3 - Command-Line Option

Steps to free port which is already used to run Tomcat server in Eclipse

For example , suppose 8080 port is used , we need to make free 8080 to run tomcat



Step 1: (open the CMD command)

C:\Users\username>netstat -o -n -a | findstr 0.0:8080

TCP    0.0.0.0:3000      0.0.0.0:0              LISTENING       3116

Now , we can see that LISTENING port is 3116 for 8080 ,

We need to kill 3116 now



Step 2:

C:\Users\username>taskkill /F /PID 3116



Step 3:  Return back to Eclipse and start the Tomcat Server, it should start up now.



====

Mac/Linux SOLUTION

Step 0: Exit Eclipse

Step 1: Open a terminal window



Step 2: Enter the following command to find the process id

lsof -i :8080
This will give output of the application that is running on port 8080



Step 3: Enter the following command to kill the process

kill $(lsof -t -i :8080) 


Step 4:  Return back to Eclipse and start the Tomcat Server, it should start up now.

