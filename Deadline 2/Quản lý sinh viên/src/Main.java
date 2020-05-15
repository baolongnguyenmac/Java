public class Main {
    public static void main(String[] args) throws Exception {
        School sc = new School();
        sc.addStudent();
        sc.printListStudent();
        System.out.println("================================");
        sc.importDataFromFile();
        sc.printListStudent();
    }
}
