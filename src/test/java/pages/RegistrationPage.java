package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private final String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            dateOfBirthInput = $("#dateOfBirthInput");

    public RegistrationPage openPage() {
        Selenide.open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
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

    public RegistrationPage clearLastName(String value) {
        lastNameInput.clear();

        return this;
    }

    public RegistrationPage setEmail(String value) {
        $("#userEmail").setValue("mishka-polyakov007@mail.ru"); //todo  move to Selenide elements
        return this;
    }

    public RegistrationPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click(); //todo  move to Selenide elements
        return this;
    }

    public RegistrationPage setPhone(String value) {
        $("#userNumber").setValue("1234567890"); //todo  move to Selenide elements
        return this;
    }

    public RegistrationPage setBirthDate(String day, String moth, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate( day,  moth,  year);
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
