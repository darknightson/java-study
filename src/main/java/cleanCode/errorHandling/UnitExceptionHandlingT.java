package cleanCode.errorHandling;

import jdk.jfr.consumer.RecordedThreadGroup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UnitExceptionHandlingT {

    public List<RecordedThreadGrip> retrieveSection(String sectionName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(sectionName);
            fileInputStream.close();
        } catch ( FileNotFoundException e ) {
            throw new DeviceShutDownError("Invalid section " + sectionName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new ArrayList<RecordedThreadGrip>();
    }
}
