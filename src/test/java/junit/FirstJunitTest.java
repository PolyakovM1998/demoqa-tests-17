package junit;

import org.junit.jupiter.api.*;

public class FirstJunitTest {

    @BeforeAll
    static void beforeall() {
        System.out.println("     Этот метод @Beforeall() ");
    }

    @AfterAll
    static void afterll() {
        System.out.println("     Этот метод @Afterll() ");
    }

    @BeforeEach
    void BeforeEach(){
        System.out.println("     Этот метод @BeforeEach ");
    }

    @AfterEach
    void afterEach(){

        System.out.println("     Этот метод @AfterEach");
    }


    @Test
    void firstTest() {
        System.out.println("       Это firstTest()");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void secondTest() {
        System.out.println("       Это secondTest()");
        Assertions.assertTrue(3 > 2);
    }
}
