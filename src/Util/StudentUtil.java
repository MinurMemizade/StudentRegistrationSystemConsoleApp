package Util;

import Beans.Student;
import main.Config;

public class StudentUtil {
    public static Student fillStudent()
    {
        String name=MenuUtil.requireName();
        String surname=MenuUtil.requireSurname();
        int age=MenuUtil.requireAge();
        String className=MenuUtil.requireClass();
        Student st=new Student(name,surname,age,className);
        return st;
    }

    public static void printAllRegisteredStudent()
    {
        if(Config.students==null) return;
        for (int i = 0; i< Config.students.length; i++)
        {
            Student st=Config.students[i];
            System.out.println((i+1)+"."+st.getFullInfo());
        }
    }

    public static void registerStudents()
    {
        int count=InputUtil.requireNumber("How many student you will register?");
        Config.students=new Student[count];

        for (int i=0;i<count;i++) {

            System.out.println((i+1)+".Register.");
            Config.students[i]= StudentUtil.fillStudent();;

        }
        MenuUtil.showSuccessOpMessage();
        StudentUtil.printAllRegisteredStudent();
    }

    public static void findStudentsAndPrint()
    {
        String text=InputUtil.requireText("Enter name, surname or class:");
        Student[] result=findStudents(text);
        for (int i=0;i< result.length;i++)
            System.out.println(result[i].getFullInfo());

    }
    public static Student[] findStudents(String text) {
        int count = 0;
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text))
                count++;
        }

        Student[] result = new Student[count];
        int found = 0;
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text))

                result[found++] = st;
        }
        return result;
    }

    public static void updateStudentWithNewObject()
    {
        StudentUtil.printAllRegisteredStudent();
        int i=InputUtil.requireNumber("Enter the index of student:");
        Student s=StudentUtil.fillStudent();
        Config.students[i-1]=s;
    }
    public static void updateStudentWithSameObject()
    {
        StudentUtil.printAllRegisteredStudent();
        int i=InputUtil.requireNumber("Enter the index of student:");
        Student selectedStudent=Config.students[i-1];
        String changeParams=InputUtil.requireText("What do you want to change?");

        if (changeParams.contains("'name'"))
            selectedStudent.setName(MenuUtil.requireName());
        if (changeParams.contains("'surname'"))
            selectedStudent.setSurname(MenuUtil.requireSurname());
        if (changeParams.contains("'age'"))
            selectedStudent.setAge(MenuUtil.requireAge());
        if (changeParams.contains("'classname'"))
            selectedStudent.setClassName(MenuUtil.requireClass());
    }

    public static void updateStudentWithSplit()
    {
        StudentUtil.printAllRegisteredStudent();
        int index=InputUtil.requireNumber("Enter the index of student:");
        Student selectedStudent=Config.students[index-1];
        String changeParams=InputUtil.requireText("What do you want to change?");

        String [] parameters=changeParams.split(",");
        for(int i=0;i<parameters.length;i++) {
            String param=parameters[i];
        }

        if (changeParams.equalsIgnoreCase("name"))
            selectedStudent.setName(MenuUtil.requireName());
        if (changeParams.equalsIgnoreCase("surname"))
            selectedStudent.setSurname(MenuUtil.requireSurname());
        if (changeParams.equalsIgnoreCase("age"))
            selectedStudent.setAge(MenuUtil.requireAge());
        if (changeParams.equalsIgnoreCase("class"))
            selectedStudent.setClassName(MenuUtil.requireClass());
    }
}
