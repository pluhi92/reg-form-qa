package com.pluhi;

import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    public int RandomNumber(int Numb) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextInt(1, Numb);
    }

    public String RandomPhone() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        long randomNum = random.nextLong(1111111111, 9999999999L);
        return Long.toString(randomNum);
    }

    public String RandomDate() {
        LocalDate from = LocalDate.of(1940, 1, 1);
        LocalDate to = LocalDate.of(2005, 12, 31);
        long days = from.until(to, ChronoUnit.DAYS);
        long randomDays = ThreadLocalRandom.current().nextLong(days + 1);
        LocalDate randomDate = from.plusDays(randomDays);
        return randomDate.format(DateTimeFormatter.ofPattern("dd LLLL yyyy"));

    }

    public String RandomSubjects() {
        String[] listOfSubjects = {"English", "Physics", "Biology", "Arts", "Maths", "Chemistry"};
        Random r = new Random();
        return listOfSubjects[r.nextInt(listOfSubjects.length)];
    }

    public String RandomState() {
        String[] listStates = {"Uttar Pradesh", "Haryana", "NCR", "Rajasthan"};
        Random r = new Random();
        return listStates[r.nextInt(listStates.length)];
    }

    public String RandomAddress() {

        StringBuilder tmp = new StringBuilder();
        for (char c = '0'; c <= '9'; c++)
            tmp.append(c);
        for (char c = 'a'; c <= 'z'; c++)
            tmp.append(c);
        for (char c = 'A'; c <= 'Z'; c++) // upper case
            tmp.append(c);
        tmp.append(' '); //spaces
        tmp.append('-'); //hyphen

        char[] chars = tmp.toString().toCharArray();
        return RandomStringUtils.random(30, chars);

    }

}

