package com.ttn.assignment.mar_1_design_patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implement proxy design for accessing Record of a student and allow the access only to Admin.
 * <p>
 * Proxy is used provide controlled access.
 */
public class Exercise8 {
    public static void main(String[] args) {
        List<ProxyUser> users = Arrays.asList(new ProxyUser("Yatin", Roles.STUDENT)
                , new ProxyUser("Vishakha", Roles.STUDENT)
                , new ProxyUser("Arshad", Roles.ADMIN)
                , new ProxyUser("Nikhil", Roles.ADMIN));
        users.forEach(ProxyUser::add);
        users.forEach(ProxyUser::viewUsers);
    }
}

enum Roles {
    ADMIN, STUDENT
}

interface CheckRole {
    boolean hasViewRights();
}

class User implements CheckRole {
    private String name;
    private Roles role;

    User(String name, Roles role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    Roles getRole() {
        return role;
    }

    @Override
    public boolean hasViewRights() {
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}

// Proxy class to restrict used details Access.
class ProxyUser extends User {
    private static List<User> users = new ArrayList<>();

    ProxyUser(String name, Roles role) {
        super(name, role);
    }

    static void add(User user) {
        users.add(user);
    }

    @Override
    public boolean hasViewRights() {
        return this.getRole() == Roles.ADMIN;
    }

    void viewUsers() {
        if (this.hasViewRights()) {
            System.out.println("Hello " + super.getName() + " user details are : ");
            users.forEach(user -> {
                if (!user.getName().equals(this.getName())) {
                    System.out.println(user);
                }
            });
        } else {
            System.out.println(super.getName() + " : You Don't have rights to view the User Details.Access Denied.");
        }
    }

}