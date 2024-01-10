package oop.section3_4;

public class FileRepository implements Repository {
    @Override
    public void save(String message) {
        // 파일에 저장하는 기능
        if (message == null) {
            throw new RecordNotFoundException("레코드를 찾을 수 없습니다.");
        }
    }
}
