package demoqa;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class HomeWithPageObjectWorkDemoqa extends TestBase {

    @Test
    void homeWorkDemoqa(){
        String
               userName = "Misha",
               subjects = "Maths",
               hobbies = "Sports",
               currentaddress = "Perevoz",
               state = "NCR",
               city = "Delhi",
               submit = "Submit",
               image = "img1.jpg";

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
                .setSubmit(submit)
                .setImage(image);

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " Polyakov")
                .verifyResult("Student Email", "mishka-polyakov007@mail.ru")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "1234567890")
                .verifyResult("Date of Birth", "30 July,2008")
                .verifyResult("Subjects","Maths")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", image)
                .verifyResult("Address","Perevoz")
                .verifyResult("State and City", state+" "+city);

    }
}
