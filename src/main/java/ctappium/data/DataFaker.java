package ctappium.data;

import com.github.javafaker.Faker;
import ctappium.core.BasePage;


public class DataFaker extends BasePage {

    //private static Faker faker;
    public static Faker faker = new Faker();

    public static String firstName() {
        return faker.name().firstName();
    }

    public static String lastName() {
        return faker.name().lastName();
    }

    public static String emailAddress() {
        return faker.internet().emailAddress();
    }

    public static String password() {
        return faker.internet().password();
    }
}
