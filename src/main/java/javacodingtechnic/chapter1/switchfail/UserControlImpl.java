package javacodingtechnic.chapter1.switchfail;

import javacodingtechnic.CruiseControl;
import javacodingtechnic.User;

public class UserControlImpl implements CruiseControl {

    @Override
    public void grantAccess(User u) {
        System.out.println("grantAccess");
    }

    @Override
    public void grantAdminAccess(User u) {
        System.out.println("grantAdminAccess");
    }

    @Override
    public void logUnauthorizedAccessAttempt() {
        System.out.println("logUnauthorizedAccessAttempt");
    }
}
