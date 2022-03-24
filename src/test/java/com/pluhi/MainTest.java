package com.pluhi;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainTest {
    private static FirefoxDriver driver;
    WebElement element;
    RandomGenerator random = new RandomGenerator();

    // Test data
    public String RegistrationURL = "https://demoqa.com/automation-practice-form";
    static String[] nameList = {"Jan van Dam", "Chack Norris", "Klark n Kent", "John Daw", "Bat Man", "Tim Los",
            "Dave o Core", "Pay Pal", "Lazy Cat", "Jack & Johnes"};

    // Get 5 random users
    public String[] mixer() {
        Random rand = new Random();
        for (int i = 0; i < nameList.length; i++) {
            int randomIndexToSwap = rand.nextInt(nameList.length);
            String temp = nameList[randomIndexToSwap];
            nameList[randomIndexToSwap] = nameList[i];
            nameList[i] = temp;

        }

        return nameList;
    }

    public String[] mixedList = mixer();

    // Users info
    String user1 = mixedList[0];
    String[] user1Split = user1.split("\\W+");
    String user2 = mixedList[1];
    String[] user2Split = user2.split("\\W+");
    String user3 = mixedList[2];
    String[] user3Split = user3.split("\\W+");
    String user4 = mixedList[3];
    String[] user4Split = user4.split("\\W+");
    String user5 = mixedList[4];
    String[] user5Split = user5.split("\\W+");

    @BeforeClass
    public static void openBrowser() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testWebsite() throws InterruptedException {
        System.out.println("Starting test " + new Object() {
        }.getClass().getEnclosingMethod().getName());

        driver.get(RegistrationURL);


        String URL = driver.getCurrentUrl().toLowerCase();
        // Check URL matches the navigation path
        Assert.assertTrue(URL.contains(RegistrationURL));


        System.out.println("Users to register are: " + Arrays.toString(mixedList));

        RegistrationForm elements = new RegistrationForm(driver);
        // Register User 1
        System.out.println("1st user is: " + user1);
        elements.registerUser(user1Split);

        // Register User 2
        System.out.println("2nd user is: " + user2);
        elements.registerUser(user2Split);

        // Register User 3
        System.out.println("3rd user is: " + user3);
        elements.registerUser(user3Split);

        // Register User 4
        System.out.println("4th user is: " + user4);
        elements.registerUser(user4Split);

        // Register User 5
        System.out.println("5th user is: " + user5);
        elements.registerUser(user5Split);

        // Display non-registered users
        String[] remainingUsers = Arrays.copyOfRange(mixedList, 5, 10);
        System.out.println("Non-registered users are: " + Arrays.toString(remainingUsers));

        System.out.println("Ending test " + new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    @AfterClass
    public static void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}