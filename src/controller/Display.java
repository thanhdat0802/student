
package controller;

import java.util.ArrayList;
import java.util.Collections;
import model.Student;
import view.Validation;
public class Display {
    Validation validation = new Validation();
     public void addStudent(ArrayList<Student> StudentList) {
        System.out.println("Please input student information ");
        System.out.print("Name: ");
        String name = validation.checkInputString();
        System.out.print("Classes: ");
        String classes = validation.checkInputString();
        System.out.print("Mark: ");
        float mark = validation.checkInputFloat();
        StudentList.add(new Student(name, mark, classes));
    }

    public void print(ArrayList<Student> StudentList) {
        if (StudentList.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        Collections.sort(StudentList);
        for (int i = 0; i < StudentList.size(); i++) {
            System.out.println("--------Student " + i + 1 + "--------");
            System.out.println("Name: " + StudentList.get(i).getName());
            System.out.println("Classes: " + StudentList.get(i).getClasses());
            System.out.println("Mark: " + StudentList.get(i).getMark());
        }
    }

   public void display() {
        ArrayList<Student> StudentList = new ArrayList<>();
        addStudent(StudentList);
        while (true) {
            System.out.print("Do you want to enter more student information?(Y/N): ");
            if (validation.checkInputYN()) {
                addStudent(StudentList);
            } else {
                break;
            }
        }
        print(StudentList);
    }
}
