package oop.section3_4;

public class DataService {
    private final Repository repository;

    public DataService(Repository repository) {
        this.repository = repository;
    }

    public void save(String message) {

        try {
            repository.save(message);
        } catch (RecordNotFoundException recordNotFoundException) {
            System.out.println(recordNotFoundException.getMessage());

        } catch (TextNotFoundException textNotFoundException) {
            System.out.println(textNotFoundException.getMessage());
        }
    }
}
