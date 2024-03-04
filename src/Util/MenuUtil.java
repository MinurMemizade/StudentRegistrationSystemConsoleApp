package Util;

public class MenuUtil {
    public static void processMenu(int selectedMenu)
    {
        switch (selectedMenu) {
            case 1 -> StudentUtil.registerStudents();
            case 2 -> StudentUtil.printAllRegisteredStudent();
            case 3 -> StudentUtil.findStudentsAndPrint();
            case 4 -> StudentUtil.updateStudentWithSplit();
            case 5 -> System.exit(0);
            default -> System.out.println("Invalid input.");
        }
    }

    public static String requireName()
    {
        return InputUtil.requireText("Enter name");
    }

    public static String requireSurname()
    {
        return InputUtil.requireText("Enter surname");
    }

    public static int requireAge()
    {
        return InputUtil.requireNumber("Enter age");
    }

    public static String requireClass()
    {
        return InputUtil.requireText("Enter class");
    }

    public static void showSuccessOpMessage()
    {
        System.out.println("Operation completed succesfully.");
    }
}
