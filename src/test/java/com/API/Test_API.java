package com.API;


import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


public class Test_API {
    private User user = null;

    @BeforeClass
    private void getUser() {
        Response response = RestAssured.get(EndPoints.users);
        assertEquals("Unexpected status code", 200, response.statusCode());
        ObjectMapper objectMapper = new ObjectMapper();
        this.user = null;
        try {
            this.user = objectMapper.readValue(response.body().asString(), User.class);
        } catch (IOException e) {
            assertNull(e.getMessage(), this.user);
        }
    }

    @Test
    public void testName() {
        assertEquals("Unexpected user name", APITestData.name, user.getName());
    }

    @Test
    public void testId() {
        assertEquals("Unexpected user Id", APITestData.id, user.getId());
    }
}
