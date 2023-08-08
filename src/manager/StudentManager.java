package manager;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private List<Student> studentList;
    private Scanner scanner;

    public StudentManager(Scanner scanner) {
        this.studentList = readFile();
        this.scanner = scanner;
    }

    public void addStudent() {
        System.out.println("Input id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Input name: ");
        String name = scanner.nextLine();
        System.out.println("Input age");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Input gender: ");
        String gender = scanner.nextLine();
        System.out.println("Input address: ");
        String address = scanner.nextLine();
        System.out.println("Input average: ");
        double average = Double.parseDouble(scanner.nextLine());
        Student student = new Student(id, name, age, gender, address, average);
        studentList.add(student);
        System.out.println("Add success!");

    }


    public void updateStudent() {
        if (!studentList.isEmpty()) {
            Student student = findById();
            if (student != null) {
                System.out.println("Input new name: ");
                String name = scanner.nextLine();
                student.setName(name);
                System.out.println("Input new age");
                int age = Integer.parseInt(scanner.nextLine());
                student.setAge(age);
                System.out.println("Input new gender: ");
                String gender = scanner.nextLine();
                student.setGender(gender);
                System.out.println("Input new address: ");
                String address = scanner.nextLine();
                student.setAddress(address);
                System.out.println("Input new average: ");
                double average = Double.parseDouble(scanner.nextLine());
                student.setAverage(average);
                System.out.println("Update success!");
            } else {
                System.out.println("ID student is does not exist");
            }
        } else {
            System.out.println("List student is empty");
        }
    }

    public void deleteStudent() {
        if (!studentList.isEmpty()) {
            Student student = findById();
            if (student != null) {
                studentList.remove(student);
                System.out.println("Delete success!");
            } else {
                System.out.println("ID student is does not exist");
            }
        } else {
            System.out.println("List student is empty");
        }
    }
    public void display() {
        System.out.printf("%-5s%-20s%-5s%-15s%-25s%-10s","ID","Name","Age","Gender","Address","Average");
        System.out.println();
        if (!studentList.isEmpty()) {
            for (Student student : studentList) {
                System.out.println(student);
            }
        } else {
            System.out.println("List student is empty");
        }
    }

    public void sortAscendingByAverage() {
        SortAscendingByAverage ascending = new SortAscendingByAverage();
        studentList.sort(ascending);
        System.out.printf("%-5s%-20s%-5s%-15s%-25s%-10s","ID","Name","Age","Gender","Address","Average");
        for (Student student : studentList) {
            System.out.println(student);
        }

    }
    public void sortDecreaseByAverage() {
        SortDecreaseByAverage decrease = new SortDecreaseByAverage();
        studentList.sort(decrease);
        System.out.printf("%-5s%-20s%-5s%-15s%-25s%-10s", "ID", "Name", "Age", "Gender", "Address", "Average");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    public List<Student> readFile() {
        List<Student> students = new ArrayList<>();
        try {
            File file = new File("D:\\ThucHanhModule2\\src\\file\\student.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine())!= null) {
                String[] strings = line.split(",");
                Student student = new Student(Integer.parseInt(strings[0]),
                        strings[1], Integer.parseInt(strings[2]), strings[3],
                        strings[4], Double.parseDouble(strings[5]));
                students.add(student);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } return students;
    }

    public void writeFile () {
        try {
            File file = new File("D:\\ThucHanhModule2\\src\\file\\student.csv");
            FileWriter fileWriter = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Student student : studentList) {
                String line = student.getId() + "," + student.getName()
                        + "," + student.getAge() + "," + student.getGender()
                        + "," + student.getAddress() + "," + student.getAverage() +"\n";
                bufferedWriter.write(line);
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Student findById() {
        System.out.println("Input id: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }


}
