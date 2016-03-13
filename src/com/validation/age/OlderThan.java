package com.validation.age;

public class OlderThan implements AgePredicate {
    private int thresholdAge;

    public OlderThan(int thresholdAge) {
        this.thresholdAge = thresholdAge;
    }

    @Override
    public boolean checkValidity(int age) {
        return age > this.thresholdAge;
    }
}
