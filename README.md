# SeleniumPageObjectFromScratch
Building Selenium test framework using Page Object pattern, Maven, TestNG

# Instruction
## New project setup
1. IDEA -> New Project, using Maven
2. Add Maven xml structure to `pom.xml` from [Maven Compiler plugin](https://maven.apache.org/plugins/maven-compiler-plugin/examples/set-compiler-source-and-target.html)
3. Add TestNG plugin to `pom.xml` from [Maven Surefire plugin](https://maven.apache.org/surefire/maven-surefire-plugin/examples/testng.html) subtitle Using Suite XML Files
4. Add `<properties>` and `<dependencies>` tags
5. Add TestNG dependency from [Maven TestNG](https://mvnrepository.com/artifact/org.testng/testng)_ and link it to the newly created version variable in properties scope `<testng.version>`. Remove scope test
6. Add SeleniumHQ dependency from [Maven Selenium java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)
7. Download [Chromedriver](https://chromedriver.chromium.org/downloads) version according to your version of the Chrome

## TestBase class setup
1. Create `TestBase` class inside the `test` package. Extend your test classes (if there are any) from TestBase class
2. If some test classes with test methods are already created, use the following approach: extend test classes from the TestBase class. Right click on the class name -> Refactor -> Pull members up. Select methods and variables, which should be for the most part general for the every test (creating the driver; page url etc.) 
3. Add @BeforeMethod and @AfterMethod annotations with inner methods
4. Add all base commands to the TestBase class (e.g. creating the driver; quitting the driver; opening the url etc.)
5. Add Constants class with server_url variable. TestBase should use it as main url

## Creating first tests
1. Add package with reversed domain name in src/test/java
2. Create java class inside newly created package with appropriate test name
3. Create method inside the java class with TestNG @Test annotation and implement the test steps

## Using Page Object pattern
1. Create `BasePage` class inside the newly created ‘page’ package, under the `java/%your domain%` package
2. Add class constructor, loadPage method, basic parameters
3. Further, create ‘%Another%Page’ class, extend it from BasePage, override the loadPage method, add constructor, add page controls and methods
4. Your new tests should create a correct page instance using basic contructor and therefore use the appropriate page methods

## Using Browser Factory pattern

## Retry Analyzer
*General idea is to set specific amount of retries after the test failures.*
1. Create RetryAnalyzer class under java/util package, implement IRetryAnalyzer TestNG interface.
2. Override the retry method with condition, which will return true until the tries maximum amount is reached.
3. Use `retryAnalyzer = RetryAnalyzer.class` inside the @Test annotation parameters in your test methods.

## Useful commands
`mvn clean test` - runs the test suite, specified in your pom.xlm file. Make sure to add the 'configuration' tag with specific file, having test suite. Can be run via terminal/shell, IDEA terminal, from the Maven IDEA tab.

## Custom dependencies
* [Log4j](https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j/2.13.3) - improved logging

