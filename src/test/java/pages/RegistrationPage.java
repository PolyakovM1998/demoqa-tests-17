package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            subjectsInput = $("#subjectsInput"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            currentadressInput =  $("#currentAddress"),
            imageInput = $("#uploadPicture"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            statecitywrapper = $("#stateCity-wrapper"),
            submitInput = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage clearLastName() {
        lastNameInput.clear();

        return this;
    }

    public RegistrationPage setEmail(String value) {
        $("#userEmail").setValue(value); // todo move to Selenide elements

        return this;
    }

    public RegistrationPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click(); // todo move to Selenide elements

        return this;
    }

    public RegistrationPage setPhone(String value) {
        $("#userNumber").setValue(value); // todo move to Selenide elements

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects (String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies (String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCurrentAdress(String value) {
        currentadressInput.setValue(value);

        return this;
    }

    public RegistrationPage setImage(String image ) {
        imageInput.uploadFile(new File("src/test/java/resources/" + image));
        return this;
    }

    public RegistrationPage setState(String value) {
         stateInput.click();
         statecitywrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.click();
        statecitywrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setSubmit(String value) {
        submitInput.click();

        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }
    /*
    *** SELENIUM
    @FindBy(how = How.XPATH, xpath = ".//*[@class='submit']")
    public Button logoutBtn;

    *** SELENIDE
    public SelenideElement logoutBtn = $x(".//*[@class='submit]");
    public SelenideElement logoutBtn = $(".submit");
     */

}