package com.ttn.assignment.mar_1_design_patterns;

/**
 * Implement Builder pattern to create a student object with more than 6 fields.
 * <p>
 * Builder class is suitable for using when the POJO class has many optional attributes. So, if we do this creating
 * different constructors it will be more chaotic code.
 */
public class Exercise4 {
    public static void main(String[] args) {
        System.out.println("Student Created using Student Builder \n" + new StudentBuilder()
                .withName("Yatin")
                .withRollNo(50)
                .withAge(24)
                .withGender('M')
                .optedSchoolTransport(true)
                .withPercentage(98)
                .build());
        System.out.println("Student Created using Student Builder \n" + new StudentBuilder()
                .withName("Gaurav")
                .withRollNo(15)
                .withAge(22)
                .withGender('M')
                .withPercentage(91)
                .build());

    }
}

class Student {

    private Integer rollNo;
    private String name;
    private Integer age;
    private Integer percentage;
    private char gender;
    private boolean isUsingSchoolTransport;

    Student(StudentBuilder studentBuilder) {
        rollNo = studentBuilder.getRollNo();
        name = studentBuilder.getName();
        age = studentBuilder.getAge();
        gender = studentBuilder.getGender();
        percentage = studentBuilder.getPercentage();
        isUsingSchoolTransport = studentBuilder.isOptedSchoolTransport();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                ", age=" + age +
                ", gender=" + gender +
                ", percentage=" + percentage +
                ", isUsingSchoolTransport=" + isUsingSchoolTransport +
                '}';
    }
}

/**
 * StudentBuilder is a Builder class who's object is passed to Student class to build a student.
 * Setter of this class returns the calling object so that further method if required can be applied and build is
 * the method that creates new object for student class using StudentBuilder object.
 */
class StudentBuilder {
    private Integer rollNo;
    private String name;
    private Integer age;
    private Integer percentage;
    private char gender;
    private boolean optedSchoolTransport;

    String getName() {
        return name;
    }

    StudentBuilder withName(String name) {
        this.name = name;
        return this;
    }

    Integer getRollNo() {
        return rollNo;
    }

    StudentBuilder withRollNo(Integer rollNo) {
        this.rollNo = rollNo;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    StudentBuilder withAge(Integer age) {
        this.age = age;
        return this;
    }

    char getGender() {
        return gender;
    }

    StudentBuilder withGender(char gender) {
        this.gender = gender;
        return this;
    }

    boolean isOptedSchoolTransport() {
        return optedSchoolTransport;
    }

    StudentBuilder optedSchoolTransport(boolean optedSchoolTransport) {
        this.optedSchoolTransport = optedSchoolTransport;
        return this;
    }

    Integer getPercentage() {
        return percentage;
    }

    StudentBuilder withPercentage(Integer percentage) {
        this.percentage = percentage;
        return this;
    }

    Student build() {
        return new Student(this);
    }
}
