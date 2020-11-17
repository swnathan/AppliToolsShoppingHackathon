# Pre-requisites:

1. Java is installed   
2. Maven is installed, JAVA_HOME environment variable is created, path to Maven is added to environment variable PATH
3. Chrome browser is installed on your machine.
4. Chrome Webdriver is on your machine and is in the PATH
5. Git is installed on your machine. 
6. IDE (IntelliJ IDEA or Eclipse for example) is installed
   

# Steps to run the Testcases

1. Git clone this repo 
   
   * `git clone git@github.com:swnathan/AppliToolsShoppingHackathon.git`
2. Get an API key by logging into https://eyes.applitools.com/ and Register with Email Address
   Applitools > Person Icon > My API Key
3. Navigate to just cloned folder Testing 
4. Import the project as a *Maven* project in IDE
5. Navigate to ApplicationTests class - \src\test\java\com\shopping\test\HolidayShoppingTest.java.
6. Change the apikey generated from step 2 in serenity.properties 
7. Right Click and Run as JUnit Test and Once the Test Execution Completed ,Navigate to  https://eyes.applitools.com/app/test-results to see the Test Results
8.For Running Tests in Different Version,Change the applicationURL in in serenity.properties 