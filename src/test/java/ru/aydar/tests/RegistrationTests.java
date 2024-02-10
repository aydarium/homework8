package ru.aydar.tests;

import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.aydar.pages.RegistrationPage;
import ru.aydar.utils.RandomUtils;

@DisplayName("Сценарии заполнения формы регистрации студента")
@Tag("demoqa")
public class RegistrationTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    String file = "image.jpg";
    String invalidPhoneNumber = "555123552";
    String nameKey = "Student Name";
    String emailKey = "Student Email";
    String genderKey = "Gender";
    String mobileKey = "Mobile";
    String birthdayKey = "Date of Birth";
    String subjectsKey = "Subjects";
    String hobbiesKey = "Hobbies";
    String picKey = "Picture";
    String addressKey = "Address";
    String stateCityKey = "State and City";

    @Test
    @DisplayName("Полное заполнение формы регистрации")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("aydarium")
    @Link(value = "Репозиторий тестов", url = "https://github.com/aydarium/homework8")
    void submitCompleteFormTest()
        {
            RandomUtils random = new RandomUtils();
            registrationPage
                    .openPage()
                    .setFirstName(random.firstName)
                    .setLastName(random.lastName)
                    .setEmail(random.email)
                    .setGender(random.gender)
                    .setPhoneNumber(random.phoneNumber)
                    .setDateOfBirth(random.dayOfBirth, random.monthOfBirth, random.yearOfBirth)
                    .setSubject(random.subject)
                    .setHobby(random.hobby)
                    .uploadFile(file)
                    .setAddress(random.address)
                    .setState(random.state)
                    .setCity(random.city)
                    .clickSubmit()
                    .checkResultVisible()
                    .checkResultValue(nameKey, random.firstName + " " + random.lastName)
                    .checkResultValue(emailKey, random.email)
                    .checkResultValue(genderKey, random.gender)
                    .checkResultValue(mobileKey,random.phoneNumber)
                    .checkResultValue(birthdayKey, random.fullBirthDate)
                    .checkResultValue(subjectsKey, random.subject)
                    .checkResultValue(hobbiesKey, random.hobby)
                    .checkResultValue(picKey,file)
                    .checkResultValue(addressKey, random.address)
                    .checkResultValue(stateCityKey, random.state + " " + random.city);
        }

    @Test
    @DisplayName("Заполнение лишь обязательных полей формы регистрации")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("aydarium")
    @Link(value = "Репозиторий тестов", url = "https://github.com/aydarium/homework8")
    void submitRequiredFieldsTest()
    {
        RandomUtils random = new RandomUtils();
        registrationPage
                .openPage()
                .setFirstName(random.firstName)
                .setLastName(random.lastName)
                .setGender(random.gender)
                .setPhoneNumber(random.phoneNumber)
                .setDateOfBirth(random.dayOfBirth, random.monthOfBirth, random.yearOfBirth)
                .clickSubmit()
                .checkResultVisible()
                .checkResultValue(nameKey,random.firstName + " " + random.lastName)
                .checkResultValue(genderKey, random.gender)
                .checkResultValue(mobileKey,random.phoneNumber)
                .checkResultValue(birthdayKey,random.fullBirthDate);
    }

    @Test
    @DisplayName("Проверка незаполненных обязательных полей в форме регистрации")
    @Severity(SeverityLevel.NORMAL)
    @Owner("aydarium")
    @Link(value = "Репозиторий тестов", url = "https://github.com/aydarium/homework8")
    void emptyRequiredFieldsTest()
    {
        RandomUtils random = new RandomUtils();
        registrationPage
                .openPage()
                .setPhoneNumber(random.phoneNumber)
                .clickSubmit()
                .checkResultHidden();
    }

    @Test
    @DisplayName("Проверка неправильного номера телефона в форме регистрации")
    @Severity(SeverityLevel.NORMAL)
    @Owner("aydarium")
    @Link(value = "Репозиторий тестов", url = "https://github.com/aydarium/homework8")
    void submitInvalidPhoneNumberTest()
    {
        RandomUtils random = new RandomUtils();
        registrationPage
                .openPage()
                .setFirstName(random.firstName)
                .setLastName(random.lastName)
                .setGender(random.gender)
                .setPhoneNumber(invalidPhoneNumber)
                .setDateOfBirth(random.dayOfBirth, random.monthOfBirth, random.yearOfBirth)
                .clickSubmit()
                .checkResultHidden();
    }
}
