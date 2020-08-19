# About Selenium Automation Framework
This framework is basically developed and designed to automate web applications (for UI, API)
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
1. Install and IDE such as IntelliJ/Eclipse (Any latest version will work)
2. Install Maven plugin in IDE and your local system if it is not present/enabled.
3. Use git lfs clone to download the automation framework to your local system
# How to run test
From command prompt go to project level and execute following command(it is advised to use command line option to run): 
> mvn clean test
# How to see report
When "mvn clean install" is finished, the Allure report will be generated as .json file under directory "allure-results" under project root directory. Generate Allure html report by running the command:
> allure serve allure-results
