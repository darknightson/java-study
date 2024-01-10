package constructor;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseManagerTest {

    @BeforeAll
    static void setup() throws NoSuchFieldException, IllegalAccessException {
        Field instanceField = DatabaseManager.class.getDeclaredField("INSTANCE");
        instanceField.setAccessible(true);
        instanceField.set(null, new MockDatabaseManager());
    }

    @Test
    void testConnect() {
        assertDoesNotThrow(() -> DatabaseManager.getInstance().connect());
    }
}