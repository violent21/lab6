package ad211.dovbyshev;

import java.util.Scanner;

public class Main {

    public static void main (String[] args){
        final int arrSize = 2;
        Person[] personArray = new Person[arrSize];
        personArray[0] = new Student();
        personArray[1] = new Lecturer();
        Scanner num = new Scanner(System.in);
        int menu;
        do {
            System.out.println("1. Student\n2. Lecturer");
            menu = num.nextInt();
        } while (menu > 2 || menu < 1);
        personInfo(personArray, menu);
        personArray[menu - 1].printInfo();
    }
    private static void personInfo(Person[] personAr, int answer){
        Scanner num = new Scanner(System.in);
        Scanner name = new Scanner(System.in);
        System.out.print("\nName: ");
        personAr[answer - 1].setName(name.nextLine());
        System.out.print("Surname: ");
        personAr[answer - 1].setSurname(name.nextLine());
        System.out.print("Age: ");
        personAr[answer - 1].setAge(num.nextInt());
        switch (answer){
            case 1:
                System.out.print("Group: ");
                ((Student)personAr[answer - 1]).setGroup(String.valueOf(num.nextInt()));
                System.out.print("ID: ");
                ((Student)personAr[answer - 1]).setStudentID(num.nextInt());
            case 2:
                System.out.print("\nDepartment: ");
                ((Lecturer)personAr[answer - 1]).setDepartment(name.nextLine());
                System.out.print("Salary: ");
                ((Lecturer)personAr[answer - 1]).setSalary(name.nextInt());
        }
    }
    /*public static void main (String[] args){
        final int arrSize = 3;
        Person[] personArray = new Person[arrSize];
        personArray[0] = new Person();
        personArray[1] = new Student();
        personArray[2] = new Lecturer();
        Scanner num = new Scanner(System.in);

        int menu;
        do {
            System.out.println("1. Person\n2. Student\n3.Lecturer");
            menu = num.nextInt();
        } while (menu > 3 || menu < 1);
        personInfo(personArray, menu);
        personArray[menu - 1].printInfo();
    }

    private static void personInfo(Person[] personAr, int answer){
        Scanner num = new Scanner(System.in);
        Scanner name = new Scanner(System.in);
        System.out.print("\nName: ");
        personAr[answer - 1].setName(name.nextLine());
        System.out.print("Surname: ");
        personAr[answer - 1].setSurname(name.nextLine());
        System.out.print("Age: ");
        personAr[answer - 1].setAge(num.nextInt());

        switch (answer){
            case 2:
                System.out.print("\nGroup: ");
                ((Student)personAr[answer - 1]).setGroup(num.nextInt());
                System.out.print("ID: ");
                ((Student)personAr[answer - 1]).setStudentID(num.nextInt());
            case 3:
                System.out.print("\nDepartment: ");
                ((Lecturer)personAr[answer - 1]).setDepartment(name.nextLine());
                System.out.print("Salary: ");
                ((Lecturer)personAr[answer - 1]).setSalary(name.nextInt());
        }
    }*/
}
