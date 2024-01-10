package designpattern.adapter.ex;

public interface SocialNetworkAuthTarget {

    String getServiceName();
    String getUserName();
    String getSecret();
    String getToken();
}
