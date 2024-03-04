package main;

import Beans.Student;
import Util.InputUtil;
import Util.MenuUtil;
import Util.StudentUtil;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int menu=0;
        while (true)
        {
            menu=InputUtil.requireNumber("Welcome."+"" +
                    "\n1.Enter new student."+
                    "\n2.Show all students."+
                    "\n3.Find student."+
                    "\n4.Update student."+
                    "\n5.Exit."    );
            MenuUtil.processMenu(menu);
        }
    }
}