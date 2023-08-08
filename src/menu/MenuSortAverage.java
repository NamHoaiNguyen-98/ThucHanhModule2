package menu;

import manager.StudentManager;

import java.util.Scanner;

public class MenuSortAverage {
    public void menu(Scanner scanner, StudentManager studentManager) {
        int choice;
        do {
            System.out.println("--------SẮP XẾP SINH VIÊN THEO ĐIỂM TRUNG BÌNH------");
            System.out.println("1. Sort ascending by average");
            System.out.println("2. Sort decrease by average");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    studentManager.sortAscendingByAverage();
                    break;
                case 2:
                    studentManager.sortDecreaseByAverage();
                    break;
            }
        } while (choice != 0);

    }

}

