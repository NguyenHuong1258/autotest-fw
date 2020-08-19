# About Selenium Automation Framework
This framework is basically developed and designed to automate web applications (for UI)
# Work Flow
At a high level, the Git Development Workflow being followed is:
  1. Create a branch
  2. Do your work
  3. Prepare feature/bug_fix branch (Make sure commit history is clean)
  4. Raise pull request to merge your branch into the main repo branches
# Tools, Approaches and Technologies Used
- Page Object Model
- Core Java
- Maven
- Selenium WebDriver ver3
- TestNG
- Extent Report
- Allure Report
- RestAssured
- Hamcrest
# How to Setup & Configure
1 Install and IDE such as VScode/IntelliJ/Eclipse (Any latest version will work)
2 Install Maven plugin in IDE if it is not present/enabled. Also install plugins for Lomboks and Gherkins
3 Use git lfs clone to download the automation framework to your local system
4 Locate pom.XML and right click and choose Run As -> Maven Build
5 Check whether the build is successful
# How to run test
From command prompt go to project level and execute following command(it is advised to use command line option to run): 
> mvn clean test
# How to see report
When "mvn clean install" is finished, the Allure report will be generated as .json file under directory "allure-results" under project root directory. Generate Allure html report by running the command:
> allure serve allure-results
