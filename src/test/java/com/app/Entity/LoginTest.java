package com.app.Entity;

import com.app.Entity.Repository.loginRepository;
import com.app.Service.loginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

public class LoginTest {
    @Test
    public void testloginFields() {
        Login login = new Login();
        login.setEmailId("prassu@123");
        login.setPassword("prassu123");
        assertEquals("prassu@123", login.getEmailId());
        assertEquals("prassu123", login.getPassword());
    }
    @Mock
    private loginRepository lrepo;

    @InjectMocks
    private loginService loginService;

    @Test
    public void testSaveLogin() {
        setUp();
        Login inputLogin = new Login("emailId", "password"); // Assuming a constructor with username and password

        Mockito.when(lrepo.save(any())).thenReturn(inputLogin); // Mocking repository behavior

        Login savedLogin = loginService.save(inputLogin);

        assertEquals(inputLogin, savedLogin); // Asserting that the saved login matches the input login
    }

    private void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveNullLogin() {
        setUp();
        // Test saving null login
        Mockito.when(lrepo.save(null)).thenThrow(IllegalArgumentException.class); // Mocking repository behavior

        // Asserting that attempting to save a null login throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> loginService.save(null));
    }

    // Additional test cases can be added to cover edge cases, validations, exceptions, etc.
}






