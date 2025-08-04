package com.hillel.tests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.hillel.tests.user.User;
import com.hillel.tests.user.UserValidator;
import com.hillel.tests.user.exceptions.AgeException;
import com.hillel.tests.user.exceptions.EmailException;
import com.hillel.tests.user.exceptions.PhoneValidationException;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("User validator test")
class UserValidatorTest {

    private User user;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("--> before all method");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("--> after all method");
    }

    @BeforeEach
    public void beforeEach() {
        user = new User()
                .setName("alex")
                .setAge(18)
                .setEmail("email@test.com")
                .setPhone("+38050...");
        System.out.println("---->> before each method");
    }

    @AfterEach
    public void afterAEach() {
        System.out.println("---->> after each method");
    }

    @DisplayName("correct behaviour")
    @RepeatedTest(value = 10, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    void validate_noException() {
        assertDoesNotThrow(() -> {
            new UserValidator().validate(user);
        });

    }

    @DisplayName("age exception")
    @Test
    void validate_AgeExecption() {
        user.setAge(10);
        assertThrows(AgeException.class, () -> {
            new UserValidator().validate(user);
        });

    }

    @DisplayName("email exception")
    @Test
    void validate_EmailExecption() {
        user.setEmail("10");
        assertThrows(EmailException.class, () -> {
            new UserValidator().validate(user);
        });

    }

    @DisplayName("phone exception")
    @Test
    void validate_PhoneExecption() {
        user.setPhone("13123");
        assertThrows(PhoneValidationException.class, () -> {
            new UserValidator().validate(user);
        });

    }

    @Test
    void valid() {
        assertDoesNotThrow(() -> {
            new UserValidator().validate(user);
        });
    }

    @ParameterizedTest
    @MethodSource("generator")
    void exceptionValidation(User user){
        assertThrows(RuntimeException.class, () -> {
            new UserValidator().validate(user);
        });
    }

    private static Stream<User> generator() {
        return Stream.of(
                new User().setName("alex").setAge(10).setEmail("email@test.com").setPhone("+38050..."),
                new User().setName("alex").setAge(18).setEmail("emailtest.com").setPhone("+38050..."),
                new User().setName("alex").setAge(18).setEmail("email@test.com").setPhone("38050...")
        );
    }

}
