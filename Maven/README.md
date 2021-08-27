## What is Maven?
 - Maven is a project management and comprehension tool that provides developers a complete build lifecycle framework. Development team can automate the project's build infrastructure in almost no time as Maven uses a standard directory layout and a default build lifecycle
Maven provides developers ways to manage the following −
	•	Builds
	•	Documentation
	•	Reporting
	•	Dependencies
	•	SCMs
	•	Releases
	•	Distribution
	•	Mailing list

## What is a POM?
 - A Project Object Model or POM is the fundamental unit of work in Maven. It is an XML file that contains information about the project and configuration details used by Maven to build the project. It contains default values for most projects. 
Examples for this is the build directory, which is target; the source directory, which is src/main/java; the test source directory, which is src/test/java; and so on. When executing a task or goal, Maven looks for the POM in the current directory. It reads the POM, gets the needed configuration information, then executes the goal.
POM Example
	<project xmlns = "http://maven.apache.org/POM/4.0.0"
	   xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
	   xsi:schemaLocation = "http://maven.apache.org/POM/4.0.0
	   http://maven.apache.org/xsd/maven-4.0.0.xsd">
	   <modelVersion>4.0.0</modelVersion>

	   <groupId>com.companyname.project-group</groupId>
	   <artifactId>project</artifactId>
	   <version>1.0</version>
	</project>
	- It should be noted that there should be a single POM file for each project.
		• groupId: This is an Id of project's group. This is generally unique amongst an organization or a project.
		• artifactId: This is an Id of the project. This is generally name of the project.
		• version : This is the version of the project. 


