package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    } 
    
    @Given("command new user is selected")
    public void newUserIsSelected() {
        goToCreateNewUserPage();
    }
    
    @Given("user with username {string} with password {string} is successfully created")
    public void newUserIsCreated(String username, String password) {
        goToCreateNewUserPage();
        createNewUserWith(username, password, password);
    }
    
    @Given("user with username {string} and password {string} is tried to be created")
    public void newUserIsTriedToBeCreated(String username, String password) {
        goToCreateNewUserPage();
        createNewUserWith(username, password, password);
    }
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    } 
    
    @When("username {string} and password {string} are entered")
    public void tryToLogInWithUsernameAndPassword(String username, String password) {
        logInWith(username, password);
    }
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }  
    
    @When("a valid username {string} and password {string} and "
            + "matching password confirmation are entered")
    public void validUsernamePasswordAndMatchingPasswordAreGiven(String username, String password) {
        createNewUserWith(username, password, password);
    }
    
    @When("too short username and a valid password and a matching password are entered")
    public void tooShortUsernameAndValidPasswordAreEntered() {
        createNewUserWith("aa", "validPassw0rd", "validPassw0rd");
    }
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }  
    
    @Then("user is not created and error {string} is reported")
    public void userIsNotCreatedAndErrorMessageIsReported(String error) {
        pageHasContent(error);
    }
    
    @When("nonexistent username {string} and password {string} are given")
    public void nonexistentUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }
    
    @When("correct username {string} and too short password {string} are given")
    public void correctUsernameAndTooShortPasswordAreGiven(String username, String password) {
        System.out.println("tätä suoritetaan");
        createNewUserWith(username, password,password);
    }
    
    @When("correct username {string} and correct password {string} and nonmatching password {string} are given")
      public void correctUsernameAndNonMatchingPasswordsAreGiven(String username, String password, String passwordConfirmation) {
          createNewUserWith(username, password, passwordConfirmation);
      }
    
    @Then("system will respond {string}")
    public void systemWillRespond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }
    
    @Then("a new user is created")
    public void newUserIsCreatedAndWelcomePageIsShown() {
        pageHasContent("Welcome to Ohtu Application!");
    }
    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    } 
    
    private void createNewUserWith(String username, String password, String passwordCheck) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(passwordCheck);
        element = driver.findElement(By.name("signup"));
        element.submit();
    }
    
    private void goToCreateNewUserPage() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
    }
}
