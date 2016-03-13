package com.guest;

import com.validation.age.OlderThan;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AgeTest {

    @Test
    public void tes_isAllowed_gives_result_based_on_the_given_predicate() throws Exception {
        Age age = new Age(18);
        assertTrue(age.isAllowed(new OlderThan(17)));
        assertFalse(age.isAllowed(new OlderThan(18)));
    }
}