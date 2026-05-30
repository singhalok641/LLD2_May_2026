package org.example.designpatterns.builder;

public class Client {
    public static void main(String[] args) {
        // Verbose
//        StudentBuilder builder = Student.getBuilder();
//        builder.setName("Alok");
//        builder.setAge(28);
//        builder.setPsp(99.0);
//        builder.setUniversityName("Thapar University");
//        builder.setGradYear(2027);

//        Student student = builder.build(); // builder builds the Student object

        // Fluent way
        Student student = Student.getBuilder()
                .setName("Alok")
                .setAge(28)
                .setPsp(92)
                .setId(12)
                .setGradYear(2019)
                .build();
        System.out.println("Student created successfully");

    }
}
