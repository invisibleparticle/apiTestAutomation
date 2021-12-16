**This is a Cucumber Modified_BDD framework for api automation.Uses design principles like DI.**

**It has capability of parallel execution of feature files.**
**This is a basic framework.We can modify based on project requirement**
**Uses rest-assured libraries for api automation**
**(1)Execution instructions:**

(a)To run using maven command in terminal use below command:
     
mvn clean test -Dcucumber.filter.tags="@test"

(b)Use Cucumber testRunner class:

 Open the file src/test/java/testRunners/RunCucumberTest.java and run in the ide

**(2)Report:**

3 reports would be generated at following location in target folder

plugin = {"pretty", "html:**target/cucumber.html**", "json:**target/cucumber.json**", "junit:**target/cucumber.xml**"})

**Framework structure**


* Test cases are in src/test/java folder
* baseObjects package contains ScenarioSpecific class which contains scenario exclusive objects which is to be used to hold and share data from/to scenario STEPS
* features folder contains all the feature files
* steps folder contains StepDefinitions of Gherkin scenario steps
* testRunners package contains cucumber Runner class
* utils folder contains FuncUtil class which stores all the common items of the framework
* Test resources like properties file and json payload are in src/test/resources folder
