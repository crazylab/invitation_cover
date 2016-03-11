package com.invitation.name;

public enum NameFormat {
    FIRSTNAMEFIRST {
        public String callWithTitle(String title, String firstName, String lastName) {
            return String.format("%s %s %s", title, firstName, lastName);
        }
    },
    LASTNAMEFIRST {
        public String callWithTitle(String title, String firstName, String lastName) {
            return String.format("%s %s, %s", title, lastName, firstName);
        }
    };

    public abstract String callWithTitle(String title, String firstName, String lastName);
}
