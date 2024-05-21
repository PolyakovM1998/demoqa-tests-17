package demoqa;


import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class HomeWorkDemoqaWithPageObjects extends TestBase {


    @Test
    void homeWorkDemoqa() {
        String userName = "Misha";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName("Polyakov")
                .setEmail("mishka-polyakov007@mail.ru")
                .setGender("Male")
                .setPhone("1234567890")
                .setBirthDate("30", "July", "2008");

        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        //  $("#uploadPicture").uploadFromClasspath(("img/1.png"));//вариант 44 строки
        $("#currentAddress").setValue("Perevoz");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " Polyakov")
                .verifyResult("Student Email", "mishka-polyakov007@mail.ru")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "1234567890")
                .verifyResult("Date of Birth", "30 July,2008");
    }
}
