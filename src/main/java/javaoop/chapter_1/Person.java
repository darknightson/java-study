package javaoop.chapter_1;

public class Person {

    private Phone homePhone;
    private Phone officePhone;

    public void setHomePhone(Phone homePhone) {
        this.homePhone = homePhone;
    }

    public void setOfficePhone(Phone officePhone) {
        this.officePhone = officePhone;
    }

    public Phone getHomePhone() {
        return homePhone;
    }

    public Phone getOfficePhone() {
        return officePhone;
    }

    public static void main(String[] args) {
        Person person = new Person();

        Phone phone = new Phone("000-000-0000", "010-2821-7207");

        person.setHomePhone(phone);

        System.out.println("per = " + person.getHomePhone().getHomePhone());

    }
}
