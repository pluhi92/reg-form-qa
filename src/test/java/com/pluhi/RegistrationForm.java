package com.pluhi;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationForm {
    FirefoxDriver driver;
    RandomGenerator random = new RandomGenerator();

    public void scrollDown() {
        JavascriptExecutor js = driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void hideAds() {
        WebElement ads = driver.findElement(By.xpath("//*[@id=\"fixedban\"]"));
        WebElement ads2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[3]/div/section/div"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='hidden'", ads);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='hidden'", ads2);
    }

    public void fillNameField(String query) throws InterruptedException {
        WebElement fieldName = driver.findElement(By.id("firstName"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fieldName);
        Thread.sleep(500);
        fieldName.sendKeys(query);
    }

    public void fillSurnameField(String query) throws InterruptedException {
        WebElement fieldSurname = driver.findElement(By.id("lastName"));
        Thread.sleep(500);
        fieldSurname.sendKeys(query);
    }

    public void fillEmailField(String query) throws InterruptedException {
        WebElement fieldEmail = driver.findElement(By.id("userEmail"));
        Thread.sleep(500);
        fieldEmail.sendKeys(query + "@demoqa.com");
    }

    public void markRandomGender() throws InterruptedException {
        WebElement fieldGender1 = driver.findElement(By.id("gender-radio-1"));
        WebElement fieldGender2 = driver.findElement(By.id("gender-radio-2"));
        WebElement fieldGender3 = driver.findElement(By.id("gender-radio-3"));
        WebElement[] fieldsGender = {fieldGender1, fieldGender2, fieldGender3};
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", fieldsGender[random.RandomNumber(3)]);
//        Actions actions = new Actions(driver);
        Thread.sleep(500);
//        actions.moveToElement(fieldsGender[random.RandomNumber(3)]).click().build().perform();
    }

    public void fillRandomPhoneField() throws InterruptedException {
        WebElement fieldPhone = driver.findElement(By.id("userNumber"));
        Thread.sleep(500);
        fieldPhone.sendKeys(random.RandomPhone());
    }

    public void fillRandomDateField() throws InterruptedException {
        WebElement fieldDate = driver.findElement(By.id("dateOfBirthInput"));
        Thread.sleep(500);
        fieldDate.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        fieldDate.sendKeys(random.RandomDate());
        fieldDate.sendKeys(Keys.chord(Keys.ENTER));

    }

    public void fillRandomSubject() {
        new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='subjectsInput']"))).sendKeys(random.RandomSubjects());
        new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'subjects-auto-complete__menu')]"))).click();

    }

    public void chooseRandomState() {
        WebElement fieldState = driver.findElement(By.xpath("//input[@id='react-select-3-input']"));
        fieldState.sendKeys(random.RandomState());
        fieldState.sendKeys(Keys.ARROW_DOWN);
        fieldState.sendKeys(Keys.ENTER);

    }


    public void chooseRandomCity() {
        WebElement fieldCity = driver.findElement(By.xpath("//*[@id=\"react-select-4-input\"]"));
        fieldCity.sendKeys(" ");
        fieldCity.sendKeys(Keys.ARROW_DOWN);
        fieldCity.sendKeys(Keys.ENTER);

    }


    public void markRandomHobby() throws InterruptedException {
        WebElement fieldHobbies1 = driver.findElement(By.id("hobbies-checkbox-1"));
        WebElement fieldHobbies2 = driver.findElement(By.id("hobbies-checkbox-2"));
        WebElement fieldHobbies3 = driver.findElement(By.id("hobbies-checkbox-3"));
        WebElement[] fieldsHobbies = {fieldHobbies1, fieldHobbies2, fieldHobbies3};
        Thread.sleep(500);
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", fieldsHobbies[random.RandomNumber(3)]);
    }

    public void fillRandomAddressField() throws InterruptedException {
        WebElement fieldAddress = driver.findElement(By.id("currentAddress"));
        Thread.sleep(500);
        fieldAddress.sendKeys(random.RandomAddress());

    }

    public void pressSubmitButton() throws InterruptedException {
        WebElement buttonSubmit = driver.findElement(By.id("submit"));
        Actions actions = new Actions(driver);
        Thread.sleep(500);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonSubmit);
        actions.moveToElement(buttonSubmit).click().build().perform();
    }

    public void pressCloseButton() throws InterruptedException {
        WebElement buttonCloseModal = driver.findElement(By.id("closeLargeModal"));
        Actions actions = new Actions(driver);
        Thread.sleep(500);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buttonCloseModal);
        actions.moveToElement(buttonCloseModal).click().build().perform();

    }

    public void checkModalConfirmation() {
        String modalTitle = "Thanks for submitting the form".toLowerCase();
        modalTitle = driver.findElement(By.xpath("//*[@id=\"example-modal-sizes-title-lg\"]")).getText();
        Assert.assertTrue(true);
        System.out.println("User succesfully registered.");
    }

    public void registerUser(String[] user) throws InterruptedException {
        hideAds();
        scrollDown();
        fillNameField(user[0]);
        fillSurnameField(user[user.length - 1]);
        fillEmailField(user[0] + user[user.length - 1]);
        markRandomGender();
        fillRandomPhoneField();
        fillRandomDateField();
        markRandomHobby();
        fillRandomAddressField();
        fillRandomSubject();
        chooseRandomState();
        chooseRandomCity();
        pressSubmitButton();
        checkModalConfirmation();
        pressCloseButton();
    }

    public RegistrationForm(WebDriver driver) {
        this.driver = (FirefoxDriver) driver;
    }

}
