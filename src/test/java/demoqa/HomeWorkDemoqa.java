package demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWorkDemoqa {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
 //       Configuration.holdBrowserOpen = true;
    }
    @Test
    void homeWorkDemoqa(){
        Selenide.open("https://demoqa.com/automation-practice-form");
//        executeJavaScript("$('fixedban').remove()");//если мешает реклама
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Misha");
        $("#lastName").setValue("Polyakov");
        $("#userEmail").setValue("mishka-polyakov007@mail.ru");
//      $("#gender-radio-1").click();//wrong
//      $("#gender-radio-1").parent().click();//как вариант использовать родителя,поднятся чуть выше
//      $(byText("Male")).click();// not very good не совсем подходит на разных языках сайта кроме англ
//      $("label[for=gender-radio-1]").click();//good
        $("#genterWrapper").$(byText("Male")).click();//very good
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
//        $(".react-datepicker__month-select").selectOptionByValue("12");//тоже самое что и в 33 строке
        $(".react-datepicker__year-select").selectOption("1998");
//<div class= react-datepicker__day--030  react-datepicker__day--outside-month" >30</div>
//<div class= react-datepicker__day--030"                                       >30</div>
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        $("#uploadPicture").uploadFromClasspath(("img/1.png"));//вариант 44 строки
        $("#currentAddress").setValue("Perevoz");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        //проверка
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Misha"), text("Polyakov"), text("mishka-polyakov007@mail.ru")
                , text("1234567890"));


    }
}
