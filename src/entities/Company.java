package entities;


public class Company {
    private int id;
    private String name;
    private double salary;
    private String specialization;
    private String surname;
    private String email;
    public Company() {
    }

    public Company (int id, String name, double salary, String specialization, String surname, String email ) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.specialization = specialization ;
        this.surname = surname;
        this.email = email;

    }

    public Company(String name, double salary, String specialization, String surname, String email) {
        this.name = name;
        this.salary = salary;
        this.specialization = specialization ;
        this.surname = surname;
        this.email = email;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "IT-Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", specialization=" + specialization +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
