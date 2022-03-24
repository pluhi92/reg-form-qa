## **Automated test project using Java, JUnit, Maven and Selenium**

**Description**: Create a test project using Java, JUnit, Maven and Selenium. Project should be hosted on a git repository. Test consist on register a list of users on a website. List of users to be registered must be as a constant field having the following names: “Jan van Dam”, “Chack Norris”, “Klark n Kent”, “John Daw”, “Bat Man”, “Tim Los”, “Dave o Core”, “Pay Pal”, “Lazy Cat”, “Jack & Jones”The first part of the name is a first name and last part is a second name (e.g “Jan” - first name, “Dam” - second name.

##### Test steps:

1. Open the page https://demoqa.com/automation-practice-form and validate that the URL is the same as we navigated to. If not - fail the test. 
2. Register 5 random users from the list above (random data except First Name and Second Name). Do not repeat the users. 
3. Display in the output the given list of the users but WITHOUT already registered users.

#### Building parameters:

    IDE: IntelliJ IDEA 2021.2.2
    Java version: 16
    Selenium Framework: 4.1.1
    JUnit: 4.13.1
    Commons-lang3: 3.12.0
    Webrdiver: geckodriver (Mozilla Firefox)

##### Running the test:
_Use the MainTest class._

_Right click/Run 'MainTest'._

_No need to download geckodriver.exe, it is located in the base folder of the project._
    
    
