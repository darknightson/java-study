package javaoop.chapter_1;

public class Phone {

    private String homePhone;
    private String officePhone;

    public Phone(String homePhone, String officePhone) {
        this.homePhone = homePhone;
        this.officePhone = officePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getOfficePhone() {
        return officePhone;
    }
}
