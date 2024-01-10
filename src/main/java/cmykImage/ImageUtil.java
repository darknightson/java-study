package cmykImage;

import org.apache.commons.imaging.ImageInfo;
import org.apache.commons.imaging.Imaging;

import java.io.File;
import java.io.IOException;

public class ImageUtil {

    public static boolean isCMYK(File imageFile) throws Exception {
        try {
            ImageInfo imageInfo = Imaging.getImageInfo(imageFile);
            return imageInfo.getColorType() == ImageInfo.ColorType.YCCK || imageInfo.getColorType() == ImageInfo.ColorType.CMYK;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        File imageFile = new File("/Users/anthony/jacket-cmyk.jpg");
        if (isCMYK(imageFile)) {
            System.out.println("The image is in CMYK color mode.");
        } else {
            System.out.println("The image is not in CMYK color mode.");
        }
    }
}
