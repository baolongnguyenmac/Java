import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public void printMenu() {
        System.out.print("\033[H\033[2J");
        System.out.println("1. Add a student");
        System.out.println("2. Erase a student");
        System.out.println("3. Update a student");
        System.out.println("4. Print list student");
        System.out.println("5. Import file csv");
        System.out.println("6. Export file csv");
        System.out.println("0. Exit and save");
        System.out.print("> ");
    }

    public void executeMenu(School school) {
        printMenu();
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1: {
                school.addStudent();
            } break;

            case 2: {
                school.eraseStudent();
            } break;

            case 3: {
                school.updateStudent();
            } break;

            case 4: {
                school.printListStudent();
            } break;

            case 5: {
                school.importDataFromFile();
            } break;

            case 6: {
                school.exportDataToFile();
            } break;

            case 0: {
                school.save();
                System.exit(1);
            } break;

            default: {
                System.out.println("Wrong input");
            } break;
        }
        try {
            System.in.read();
        }
        catch (IOException e) {
            System.err.println(e);
        }
        executeMenu(school);
    }
}