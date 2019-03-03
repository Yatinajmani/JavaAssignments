package com.ttn.assignment.mar_1_design_patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement Composite Design Pattern to maintaining the directories of employees on the basis of departments.
 * <p>
 * Composite Pattern is used when we are using a tree structure in our classes.
 */
public class Exercise7 {
    public static void main(String[] args) {
        DeveloperDirectory developerDirectory = new DeveloperDirectory();
        developerDirectory.addNewDeveloper(new Developer("Yatin Ajmani", "Java"));
        developerDirectory.addNewDeveloper(new Developer("Gaurav Sharma", "Java"));
        developerDirectory.addNewDeveloper(new Developer("Vishakha Gandhi", "PHP"));
        developerDirectory.getDirectories();


        AdminDirectory adminDirectory = new AdminDirectory();
        adminDirectory.addNewAdmin(new Admin("Varun", "Senior Executive"));
        adminDirectory.addNewAdmin(new Admin("Prateek", "Assistance Executive"));
        adminDirectory.addNewAdmin(new Admin("Satya", "Trainee"));
        adminDirectory.getDirectories();
    }
}

//  Component for mapping objects of child component.
interface Directory {
    void getDirectories();
}

//  leaf is the objects of component.
class Developer implements Directory {
    private String name;
    private String language;

    Developer(String name, String language) {
        this.name = name;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void getDirectories() {
        System.out.println("Developer{" +
                "name='" + name + '\'' +
                ", language='" + language + '\'' +
                '}');
    }
}

//  leaf
class Admin implements Directory {
    private String name;
    private String post;

    Admin(String name, String post) {
        this.name = name;
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void getDirectories() {
        System.out.println("Admin{" +
                "name='" + name + '\'' +
                ", post='" + post + '\'' +
                '}');
    }
}

// leaf
class HR implements Directory {
    private String name;
    private String specialisation;

    public HR(String name, String specialisation) {
        this.name = name;
        this.specialisation = specialisation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void getDirectories() {
        System.out.println("HR{" +
                "name='" + name + '\'' +
                ", specialisation='" + specialisation + '\'' +
                '}');
    }

}

//  Composite stores leaf and uses component for the behaviour
class DeveloperDirectory implements Directory {
    private List<Directory> developers = new ArrayList<>();

    void addNewDeveloper(Developer developer) {
        developers.add(developer);
    }

    @Override
    public void getDirectories() {
        System.out.println("Developer's Directories");
        developers.forEach(Directory::getDirectories);
    }
}

// Composite
class AdminDirectory implements Directory {
    private List<Directory> admins = new ArrayList<>();

    void addNewAdmin(Admin admin) {
        admins.add(admin);
    }

    @Override
    public void getDirectories() {
        System.out.println("Admin's Directories");
        admins.forEach(Directory::getDirectories);
    }
}

// Composite
class HRDirectory implements Directory {
    private List<Directory> hrs = new ArrayList<>();

    @Override
    public void getDirectories() {
        System.out.println("HR's Directories");
        hrs.forEach(Directory::getDirectories);
    }
}