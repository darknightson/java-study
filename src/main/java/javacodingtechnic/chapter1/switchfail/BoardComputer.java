package javacodingtechnic.chapter1.switchfail;

import javacodingtechnic.CruiseControl;
import javacodingtechnic.Rank;
import javacodingtechnic.User;

import java.util.Objects;

public class BoardComputer {

    CruiseControl cruiseControl;

    public BoardComputer(CruiseControl cruiseControl) {
        this.cruiseControl = cruiseControl;
    }

    void authorize(User user) {
        Objects.requireNonNull(user); // 입력이 null 이면 NullPointerException 발생
        switch (user.getRank()) {
            case UNKNOWN:
                cruiseControl.logUnauthorizedAccessAttempt();
                break;
            case ASTRONAUT: // 우주비행사
                cruiseControl.grantAccess(user);
                break;
            case COMMANDER: // 사령관
                cruiseControl.grantAccess(user);
                cruiseControl.grantAdminAccess(user);
                break;
        }
    }

    // solution
    void authorize1(User user) {
        if ( user.isUnknown()) {
            cruiseControl.logUnauthorizedAccessAttempt();
            return;
        }

        if ( user.isAstronaut()) {
            cruiseControl.grantAccess(user);
        }
        else if ( user.isCommander()) {
            cruiseControl.grantAccess(user);
            cruiseControl.grantAdminAccess(user);
        }
    }

    public static void main(String[] args) {
        BoardComputer boardComputer = new BoardComputer(new UserControlImpl());

        boardComputer.authorize1(new User() {
            @Override
            public boolean isUnknown() {
                return getRank() == Rank.UNKNOWN;
            }

            @Override
            public boolean isAstronaut() {
                return getRank() == Rank.ASTRONAUT;
            }

            @Override
            public boolean isCommander() {
                return getRank() == Rank.COMMANDER;
            }

            @Override
            public Rank getRank() {
                return Rank.ASTRONAUT;
            }
        });
    }
}
