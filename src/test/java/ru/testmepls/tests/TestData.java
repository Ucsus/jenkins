package ru.testmepls.tests;

import com.github.javafaker.Faker;
import ru.testmepls.utils.RandomUtils;

public class TestData {

    private static final Faker faker = new Faker();
    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            year = String.valueOf(faker.number().numberBetween(1990, 2005)),
            month = RandomUtils.getRandomMonth(),
            birthday = String.valueOf(faker.number().numberBetween(10, 28)),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            gender = faker.demographic().sex(),
            subject = RandomUtils.getRandomSubject(),
            hobbies = RandomUtils.getRandomHobbies(),
            picture = "16451858.jpg",
            address = faker.address().fullAddress(),
            state = "NCR",
            city = RandomUtils.getRandomCity();
}
