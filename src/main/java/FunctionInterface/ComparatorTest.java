package FunctionInterface;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ComparatorTest {

    public static void main(String[] args) {
        List<User> users = new ArrayList();
        users.add(new User(3, "tdd"));
        users.add(new User(1, "add"));
        users.add(new User(2, "cdd"));

        Comparator<User> idComparator = ( User u1, User u2 ) -> {
            return u1.getId() - u2.getId();
        };


        Collections.sort(users, idComparator);
        System.out.println("users = " + users);

    }
}
