package org.example.designpatterns.builder;

public class Student {
    private String name;
    private int age;
    private double psp;
    private String universityName;
    private String batch;
    private long id;
    private int gradYear;
    private String phoneNumber;

    public static StudentBuilder getBuilder() {
        return new StudentBuilder();
    }
    
    private Student(StudentBuilder builder) {
        this.name = builder.getName();
        this.age = builder.getAge();
        this.batch = builder.getBatch();
        this.gradYear = builder.getGradYear();
        this.id = builder.getId();
        this.universityName = builder.getUniversityName();
        this.psp = builder.getPsp();
        this.phoneNumber = builder.getPhoneNumber();
    }

    // INNER BUILDER CLASS

    static class StudentBuilder {
        private String name;
        private int age;
        private double psp;
        private String universityName;
        private String batch;
        private long id;
        private int gradYear;
        private String phoneNumber;

        public String getName() {
            return name;
        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public int getAge() {
            return age;
        }

        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public double getPsp() {
            return psp;
        }

        public StudentBuilder setPsp(double psp) {
            this.psp = psp;
            return this;
        }

        public String getUniversityName() {
            return universityName;
        }

        public StudentBuilder setUniversityName(String universityName) {
            this.universityName = universityName;
            return this;
        }

        public String getBatch() {
            return batch;
        }

        public StudentBuilder setBatch(String batch) {
            this.batch = batch;
            return this;
        }

        public long getId() {
            return id;
        }

        public StudentBuilder setId(long id) {
            this.id = id;
            return this;
        }

        public int getGradYear() {
            return gradYear;
        }

        public StudentBuilder setGradYear(int gradYear) {
            this.gradYear = gradYear;
            return this;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public StudentBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Student build() {
            validate();
            return new Student(this);
        }

        private void validate() {
            // validations starts
            if (this.getGradYear() > 2026) {
                throw new IllegalArgumentException("Grad year cannot be > 2026");
            }
            // validations end
        }
    }
}

// Flaws in the map approach
/*
map.put("psp", "hello") -> ClassCastException at runtime
map.put("nmae", "Alok") -> silently ignored, name is null
No compile time safety here -> Errors will only surface at run-time
*/
