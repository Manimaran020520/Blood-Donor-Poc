package com.app.Entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RegistrationTest {
    @Test
    public void testRegistrationFields(){
        Registration registration=new Registration();
        registration.setName("name");
        registration.setBloodGroup("bloodGroup");
        registration.setMobileNumber("mobileNumber");
        registration.setCity("city");
        registration.setDistrict("district");
        registration.setState("state");
        registration.setCountry("country");
        registration.setEmailid("emailid");
        registration.setPassword("password");
        registration.setRetypePassword("RetypePassword");

        assertEquals("name",registration.getName());
        assertEquals("bloodGroup",registration.getBloodGroup());
        assertEquals("mobileNumber",registration.getMobileNumber());
        assertEquals("city",registration.getCity());
        assertEquals("district",registration.getDistrict());
        assertEquals("state",registration.getState());
        assertEquals("country",registration.getCountry());
        assertEquals("emailid",registration.getEmailid());
        assertEquals("password",registration.getPassword());
        assertEquals("RetypePassword",registration.getRetypePassword());

        }
    }

