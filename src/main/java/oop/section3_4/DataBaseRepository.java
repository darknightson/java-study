package oop.section3_4;

public class DataBaseRepository implements Repository {
    @Override
    public void save(String message) {
        if (message == null) {
            throw new RecordNotFoundException("레코드를 찾을 수 없습니다.");
        }
    }
}
