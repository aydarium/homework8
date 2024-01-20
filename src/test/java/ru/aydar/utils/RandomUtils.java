package ru.aydar.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class RandomUtils {
    static Faker faker = new Faker(Locale.ITALY);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM,yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
    SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
    Date birthday = faker.date().birthday();

    public String firstName = faker.name().firstName();
    public String lastName = faker.elderScrolls().lastName();
    public String gender = getGender();
    public String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    public String fullBirthDate = dateFormat.format(birthday);
    public String dayOfBirth = dayFormat.format(birthday);
    public String monthOfBirth = monthFormat.format(birthday);
    public String yearOfBirth = String.valueOf(birthday.getYear() + 1900);
    public String email = faker.internet().emailAddress(firstName.toLowerCase() + yearOfBirth);
    public String subject = getSubject();
    public String hobby = getHobby();
    public String address = faker.chuckNorris().fact();
    public String city = getCity();
    public String state = getStateByCity(city);

    String getHobby() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    String getGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    String getSubject() {
        return faker.options().option("Maths", "Arts", "English", "Biology", "Hindi", "Commerce", "Social Studies", "Computer Science", "Accounting", "Chemistry", "Economics", "History", "Civics");
    }

    String getCity() {
        return faker.options().option("Delhi", "Agra", "Karnal", "Gurgaon", "Lucknow", "Panipat", "Jaipur", "Jaiselmer", "Noida", "Merrut");
    }

    String getStateByCity(String value) {
        HashMap<String, String> cityAndState = new HashMap<>();
        cityAndState.put("Delhi", "NCR");
        cityAndState.put("Gurgaon", "NCR");
        cityAndState.put("Noida", "NCR");
        cityAndState.put("Agra", "Uttar Pradesh");
        cityAndState.put("Lucknow", "Uttar Pradesh");
        cityAndState.put("Merrut", "Uttar Pradesh");
        cityAndState.put("Karnal", "Haryana");
        cityAndState.put("Panipat", "Haryana");
        cityAndState.put("Jaipur", "Rajasthan");
        cityAndState.put("Jaiselmer", "Rajasthan");
        return cityAndState.get(value);
    }
}
