package com.biet;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class PasswordUtilTest {
    @Test
    public void testValid() {
        String password = "Abcd@123";
        assertEquals(true, PasswordUtil.validatePassword(password));
    }

    @Test
    public void testInValid() {
        String password = "abcd";
        assertEquals(false, PasswordUtil.validatePassword(password));
    }
}