package Problem5_ObjectSortApp;

import Problem1_BubbleSortApp.Problem1_BubbleSortApp;

import java.util.Arrays;
import java.util.Scanner;

public class Student implements Comparable<Student>{
    private String firstName;
    private String lastName;
    private int grade;

    public Student(String firstName, String lastName, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(Student o) {
        int compareNames = getLastName().compareTo(o.getLastName());
        if (compareNames == 0) {
            compareNames = getFirstName().compareTo(o.getFirstName());
        }
        if (compareNames == 0) {
            return Integer.compare(getGrade(), o.getGrade());
        }
        return compareNames;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", grade=" + grade +
                '}';
    }

    public static void main(String[] args) {
        Student[] students = new Student[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            String firstName = sc.next();
            String lastName = sc.next();
            int grade = sc.nextInt();
            students[i] = new Student(firstName, lastName, grade);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(students[i]);
        }

        System.out.println("After Sorted ");


        // Apply Bubble Sort
        Student temp1;
        for (int i = 0; i < 10 - 1; i++) {
            for (int j = 0; j < 10 - i - 1; j++) {
                if (students[j].compareTo(students[j + 1]) > 0) {
                    temp1 = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp1;
                }
            }
        }


        // Apply Selection Sort

//        for (int i = 0; i < 10 - 1; i++) {
//            Student min = students[i];
//            int minIndex = i;
//            Student temp2 = students[i];
//            for (int j = i; j < 10; j++) {
//                if (min.compareTo(students[j]) > 0) {
//                    min = students[j];
//                    minIndex = j;
//                }
//            }
//
//
//            if (students[minIndex].compareTo(temp2) < 0) {
//                students[i] = min;
//                students[minIndex] = temp2;
//            }
//        }

        // Apply Insertion Sort

//        for (int i = 1; i < 10; i++) {
//            Student temp3 = students[i];
//
//            // use while loop
//            int j = i - 1;
//            while (j >= 0) {
//                if (temp3.compareTo(students[j]) < 0) {
//
//                    students[j + 1] = students[j];
//                } else {
//                    break;
//                }
//                j = j - 1;
//            }
//            students[j+1] = temp3;
//        }

        for (int i = 0; i < 10; i++) {
            System.out.println(students[i]);
        }

    }


}
