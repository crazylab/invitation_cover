package com.guest;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AgeTest {

    @Test
    public void testIsEquals_gives_true_when_the_given_age_is_same() throws Exception {
        Age age = new Age(18);
        assertTrue(age.isEquals(18));
    }
}