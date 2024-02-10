package ru.aydar.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.aydar.pages.components.CalendarComponent;
import ru.aydar.pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            fileInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            stateCityWrapper = $("#stateCity-wrapper"),
            submitButton =  $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    @Step("Открытие формы регистрации студента и закрытие consent-окна в случае его наличия")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        if ($(".fc-cta-consent").isDisplayed()) {
            $(".fc-cta-consent").click();
        }
        return this;
    }

    @Step("Заполнение имени значением {value}")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Заполнение фамилии значением {value}")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Заполнение адреса электронной почты значением {value}")
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    @Step("Выбор гендера {value}")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Заполнение номера телефона значением {value}")
    public RegistrationPage setPhoneNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    @Step("Заполнение дня рождения датой {day} {month} {year}")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Выбор предмета {value}")
    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Выбор хобби {value}")
    public RegistrationPage setHobby(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Загрузка файла {fileName}")
    public RegistrationPage uploadFile(String fileName) {
        fileInput.uploadFromClasspath(fileName);
        return this;
    }

    @Step("Заполнение адреса значением {value}")
    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    @Step("Выбор штата {value}")
    public RegistrationPage setState(String value) {
        stateInput.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Выбор города {value}")
    public RegistrationPage setCity(String value) {
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Нажатие на кнопку Submit")
    public RegistrationPage clickSubmit()
    {
        submitButton.click();
        return this;
    }

    @Step("Проверка того, что таблица результатов регистрации видна")
    public RegistrationPage checkResultVisible() {
        resultsTableComponent.checkResultsTableVisible();
        return this;
    }

    @Step("Проверка того, что таблица результатов регистрации не отображается")
    public RegistrationPage checkResultHidden() {
        resultsTableComponent.checkResultsTableHidden();
        return this;
    }

    @Step("Проверка значения поля {key} в таблице результатов регистрации")
    public RegistrationPage checkResultValue(String key, String value) {
        resultsTableComponent.checkResultsTableValue(key, value);
        return this;
    }
}
