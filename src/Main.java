import manager.StudentManager;
import menu.MenuSortAverage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager(scanner);
        MenuSortAverage menuSortAverage = new MenuSortAverage();
        int choice;
        do {
            System.out.println("--------CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN------");
            System.out.println("1. Display list student");
            System.out.println("2. Add student");
            System.out.println("3. Update student");
            System.out.println("4. Delete student");
            System.out.println("5. Sort list student by average");
            System.out.println("6. Read file");
            System.out.println("7. Write file");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    studentManager.display();
                    break;
                case 2:
                    studentManager.addStudent();
                    break;
                case 3:
                    studentManager.updateStudent();
                    break;
                case 4:
                    studentManager.deleteStudent();
                    break;
                case 5:
                    menuSortAverage.menu(scanner,studentManager);
                    break;
                case 6:
                    studentManager.readFile();
                    break;
                case 7:
                    studentManager.writeFile();
            }
        } while (choice != 0);

    }
}