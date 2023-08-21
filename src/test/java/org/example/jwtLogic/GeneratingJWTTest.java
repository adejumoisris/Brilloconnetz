package org.example.jwtLogic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneratingJWTTest {


    private static final String VALID_USERNAME = "validUser";
    private static final String VALID_EMAIL = "valid@example.com";
    private static final String INVALID_TOKEN = "invalidTokenHere";

    @Test
    public void testGenerateAndVerifyValidToken() {
        String validToken = GeneratingJWT.generateJWT(VALID_USERNAME, VALID_EMAIL);

        assertTrue(GeneratingJWT.verifyJWT(validToken), "Valid token should verify successfully");
    }

    @Test
    public void testVerifyInvalidToken() {
        assertFalse(GeneratingJWT.verifyJWT(INVALID_TOKEN), "Invalid token should not verify");
    }
}