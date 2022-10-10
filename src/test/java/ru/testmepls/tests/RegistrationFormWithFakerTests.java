package ru.testmepls.tests;

import org.junit.jupiter.api.Test;
import ru.testmepls.pages.RegistrationFormPage;

import static io.qameta.allure.Allure.step;
import static ru.testmepls.tests.TestData.*;

public class RegistrationFormWithFakerTests extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void fillPracticeFormTest() {
        step("Open registration form", () -> {
            registrationFormPage.openPage();
        });
        step("Fill form", () -> {
            registrationFormPage
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender(gender)
                    .setNumber(phoneNumber)
                    .setBirthDate(birthday, month, year)
                    .setSubject(subject)
                    .setHobbies(hobbies)
                    .setPicture(picture)
                    .setAddress(address)
                    .setState(state)
                    .setCity(city)
                    .clickSubmit();
        });

        step("Check form results", () -> {
            registrationFormPage.checkResultsTableVisible()
                    .checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Student Email", email)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", phoneNumber)
                    .checkResult("Date of Birth", birthday + " " + month + "," + year)
                    .checkResult("Subjects", subject)
                    .checkResult("Hobbies", hobbies)
                    .checkResult("Picture", picture)
                    .checkResult("Address", address)
                    .checkResult("State and City", state + " " + city);
        });

    }


}
