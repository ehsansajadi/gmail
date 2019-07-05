package utility;

import java.io.Serializable;
import java.util.ArrayList;

public class user implements Serializable {

    private static final long serialVersionUID = 1;

    private String name;
    private String lastname;
    private String age;
    private String username;
    private String password;


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username + "@gmail.com";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        user user = (user) o;
        return username.equals(user.username);
    }

/*    @Override
    public int hashCode() {
        return username.hashCode();
    }*/

    @Override
    public String toString() {
        return username + " " + password ;
    }
}