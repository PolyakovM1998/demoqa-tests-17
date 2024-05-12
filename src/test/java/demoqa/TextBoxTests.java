package demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void beforeall() {
        Configuration.browserSize = "1920х1080";
    }

    @Test
    void fillFormTest(){

        //открыть страницу
        open("https://demoqa.com/text-box");
        //проверка заголовка
        $(".text-center").shouldHave(text("Text Box"));
        //ввести значение в поля
        $("#userName").setValue("Misha Polyakov");
        $("#userEmail").setValue("mishka-polyakov007@mail.ru");
        $("#currentAddress").setValue("Perevoz");
        $("#permanentAddress").setValue("Kemari");
        //НАЖАТЬ НА КНОПКУ САБМИТ
        $("#submit").click();
        // проверить в айди элементы ввода
        $("#output").shouldBe(visible);
        $("#output").$("#name").shouldHave(text("Misha Polyakov"));
        $("#output #email").shouldHave(text("mishka-polyakov007@mail.ru"));
    }

}
