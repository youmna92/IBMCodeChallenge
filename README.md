# IBMCodeChallenge

# Prerequisites:

Download and install Java 8.
Download and install Apache Maven.

guide to project implementation steps:

project is implemented using POM approach and testNG testing annotation framework

Also for reporting I have used testNG reporting feature

Chrome Webdriver is implmented using Maven dependency (Driver Manager) to facilitate using suitable browser version as well as forcing the Webdriver to be compaitable with your operating system (Windows, Linux, Mac OS)

to generate report using TestNG you should make sure that the option "Use default reports" is checked. please refer to the below link in case of help needed:
https://stackoverflow.com/questions/15457499/intellij-with-testng-report-generation

you can use the below command directly in CLI to run the test, but make sure to be on the project directory where the testng.xml file is present before executing the command:
mvn clean test -DsuiteXmlFile=testng.xml



