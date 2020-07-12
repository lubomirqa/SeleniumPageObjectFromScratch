# SeleniumPageObjectFromScratch
Building Selenium test framework using Page Object pattern, Maven, TestNG

# Instruction
## New project setup
1. IDEA -> New Project, using Maven
2. Add Maven xml structure to `pom.xml` from [Maven Compiler plugin](https://maven.apache.org/plugins/maven-compiler-plugin/examples/set-compiler-source-and-target.html)
3. Add TestNG plugin to `pom.xml` from [Maven Surefire plugin](https://maven.apache.org/surefire/maven-surefire-plugin/examples/testng.html) subtitle Using Suite XML Files
4. Add `<properties>` and `<dependencies>` tags
5. Add TestNG dependency from [Maven TestNG](https://mvnrepository.com/artifact/org.testng/testng)_ and link it to the newly created version variable in properties scope <testng.version>. Remove scope test
6. Add SeleniumHQ dependency from [Maven Selenium java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)
