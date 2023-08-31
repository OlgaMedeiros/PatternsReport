package ru.netology;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;


import java.nio.file.attribute.UserPrincipal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;
public class ChangeDate {
    private ChangeDate() {
    }

    public static String generateDate(int days) {
        String date = LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity(String locale) {
        Faker faker = new Faker();
        String city = faker.address().city();
        return city;
    }

    public static String generateName(String locale) {
        Faker faker = new Faker();
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker();
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            Locale localeRu = new Locale("ru");
            Faker faker = new Faker(localeRu);
            String city = faker.address().city();
            String name = faker.name().fullName();
            String phone = faker.phoneNumber().phoneNumber();
            UserInfo user = new UserInfo(city, name, phone);
            return user;
        }
    }
    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}

