package com.wegotrip.tests;

import com.codeborne.selenide.Configuration;
import com.wegotrip.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class RegistrationFormTest {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
        String firstName = "Anvar";
        String lastName = "Shamsutdinov";
        String email = "a.shams@gmail.com";
        String gender = "Male";
        String mobile = "0123456789";
        String day = "13";
        String month = "August";
        String year = "1987";
        String birthDay = day + " " + month + "," + year;
        String subjects = "English";
        String hobbie = "Sports";
        String picture = "image.png";
        String address = "Lenin str.1";
        String state = "NCR";
        String city = "Noida";

        @BeforeAll
        static void setUp() {
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.browserSize = "1920x1080";
            Configuration.holdBrowserOpen = true;
        }

        @Test
        void checkFormTest() {
            registrationFormPage.openPage()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setUserEmail(email)
                    .setGender(gender)
                    .setUserNumber(mobile)
                    .setBirthDate(day, month, year)
                    .subjectsInput(subjects)
                    .setHobbies(hobbie)
                    .uploadPicture(picture)
                    .setAddress(address, state, city)
                    .clickSubmit();
            //Check results
            registrationFormPage.checkResultsTable()
                    .checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Student Email", email)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", mobile)
                    .checkResult("Date of Birth", birthDay)
                    .checkResult("Subjects", subjects)
                    .checkResult("Hobbies", hobbie)
                    .checkResult("Picture", picture)
                    .checkResult("Address", address)
                    .checkResult("State and City", state + " " + city);

        }
    }

