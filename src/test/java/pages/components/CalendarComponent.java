package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate( String day, String moth, String year) {
        $(".react-datepicker__month-select").selectOption(moth);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" +day +
                ":not(.react-datepicker__day--outside-month)").click();

    }
}
