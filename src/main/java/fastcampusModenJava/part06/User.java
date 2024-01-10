package fastcampusModenJava.part06;

import lombok.Builder;

import java.util.List;


public class User {
    private int id;
    private String name;
    private String emailAddress;
    private boolean isVerified; // 검증
    private List<Integer> friendsUserIds;

    public User() {

    }

    public User(int id, String name, String emailAddress, boolean isVerified) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.isVerified = isVerified;
    }

    public User(int id, String name, String emailAddress, boolean isVerified, List<Integer> friendsUserIds) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.isVerified = isVerified;
        this.friendsUserIds = friendsUserIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public List<Integer> getFriendsUserIds() {
        return friendsUserIds;
    }

    public void setFriendsUserIds(List<Integer> friendsUserIds) {
        this.friendsUserIds = friendsUserIds;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", isVerified=" + isVerified +
                ", friendsUserIds=" + friendsUserIds +
                '}';
    }
}
