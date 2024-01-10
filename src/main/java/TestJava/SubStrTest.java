package TestJava;

public class SubStrTest {
    public static void main(String[] args) {
        String reqip = "113.29.142.22";
        String dbip = "113.29.142.xxx";

        System.out.println(dbip.indexOf("x"));

        System.out.println(reqip.substring(0, dbip.indexOf("x") - 1));
        System.out.println(dbip.substring(0, dbip.indexOf("x") - 1));


    }
    /*
    Office HSquare 203.246.171.180/32
    Office JongGak 124.66.178.21/32
    Office Twosun 203.246.171.130/32
    SSLVPN 엔터VPN 124.66.178.10/32
    SSLVPN KakaoFSV 113.29.142.0/24, 211.56.96.0/24

    113.29.142.xxx
    211.56.96.x
    124.66.178.10

     */

}


