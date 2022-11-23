package ad211.dovbyshev;

public abstract class Person {

    private String name;
    private String surname;
    private int age;
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public abstract void printInfo();
}
class Student extends Person{

    private String group;
    private int ID;

    public void setGroup(String group) {this.group = group;}

    public void setStudentID(int studentID) {this.ID = studentID;}

    public void printInfo() {
        System.out.println("\n\nGroup:" + group + ", name: " + getSurname() + " " + getName() + ", age: " + getAge() + ", ID: " + ID);
    }
}
class Lecturer extends Person{

    private int salary;
    private String department;

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void printInfo() {
        System.out.println("\n\nDepartment: " + department + ", name: " + getSurname() + " " + getName() + ", age: " + getAge() + ", salary:" + salary);
    }
}
