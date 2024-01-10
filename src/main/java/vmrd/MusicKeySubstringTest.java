package vmrd;

public class MusicKeySubstringTest {

    public static void main(String[] args) {
        String duplicationId = "C62228446";
        String musicKey = "";
        musicKey = duplicationId.substring(1);
        if (duplicationId.startsWith("C") ) {
            System.out.println("startWith C");
        } else if (duplicationId.startsWith("N") ) {
            System.out.println("startWith N");
        } else {
            System.out.println("startWith ELSE");
        }

        System.out.println("musicKey: " + musicKey);

    }
}


/*
final String duplicationId = Optional.ofNullable(d.getId()).orElse("");
String musicKey = "";
if (duplicationId.startsWith(DuplicationEnums.MUSIC_NUMBER_C.getValue())
        || duplicationId.startsWith(DuplicationEnums.MUSIC_NUMBER_N.getValue())) {
    musicKey = duplicationId.substring(1);
} else {
    musicKey = duplicationId;
}
DuplicationFileInfoVO fileInfoVO = fileService.searchDuplicateFileInfo(musicKey);

String musicCode = Optional.ofNullable(fileInfoVO.getMlbMscCd()).orElse("");
String musicNumber = Optional.ofNullable(fileInfoVO.getMlbMscId()).orElse("");
 */