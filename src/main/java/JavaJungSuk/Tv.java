package JavaJungSuk;

import java.lang.reflect.TypeVariable;

public class Tv {
    public static void main(String[] args) {
        TvBean bean = new TvBean("blue", 0);
        bean.upChannel();
        System.out.println("bean.channel = " + bean.channel);

        TvBean[] tvArr = new TvBean[3];

        System.out.println("tvArr.length = " + tvArr.length);

        for ( int i=0; i<tvArr.length; i++) {
            tvArr[i] = new TvBean();
        }

        System.out.println("tvArr = " + tvArr.toString());

        tvArr[2] = tvArr[1];

        System.out.println("tvArr[0].hashCode() = " + tvArr[0].hashCode());
        System.out.println("tvArr[0].hashCode() = " + tvArr[1].hashCode());
        System.out.println("tvArr[0].hashCode() = " + tvArr[2].hashCode());
    }
}

class TvBean {
    
    String color;
    int channel;

    public TvBean() {

    }

    public TvBean(String color, int channel) {
        this.color = color;
        this.channel = channel;
    }

    public void downChannel() {
        --this.channel;
    }
    public void upChannel() {
        ++this.channel;
    }

    @Override
    public String toString() {
        return "TvBean{" +
                "color='" + color + '\'' +
                ", channel=" + channel +
                '}';
    }
}
