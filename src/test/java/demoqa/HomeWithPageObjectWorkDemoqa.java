package demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class HomeWithPageObjectWorkDemoqa extends TestBase {

    @Test
    void homeWorkDemoqa(){
        String userName = "Misha";
        String subjects = "Maths";
        String hobbies = "Sports";
        String currentaddress = "Perevoz";
        String state = "NCR";
        String city = "Delhi";
        String submit = "Submit";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName("Polyakov")
                .setEmail("mishka-polyakov007@mail.ru")
                .setGender("Male")
                .setPhone("1234567890")
                .setBirthDate("30","July", "2008")
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setCurrentAdress(currentaddress)
                .setState(state)
                .setCity(city)
                .setSubmit(submit);


 //       $("#uploadPicture").uploadFromClasspath(("img/1.png"));//вариант 44 строки
        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " Polyakov")
                .verifyResult("Student Email", "mishka-polyakov007@mail.ru")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "1234567890")
                .verifyResult("Date of Birth", "30 July,2008")
                .verifyResult("Subjects","Maths")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Address","Perevoz")
                .verifyResult("State and City", state+" "+city);

    }
}
