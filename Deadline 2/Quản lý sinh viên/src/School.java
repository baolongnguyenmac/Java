import java.io.*;
import java.util.*;

public class School {

    public void addStudent() {
        Student s = new Student();
        s.inputInfo();
        if (addStudent(_listStudent, s)) {
            System.out.println("Add succeed");
        }
        else {
            System.out.println("Add fail");
        }
    }

    private boolean addStudent(ArrayList<Student> list, Student s) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get_studentCode() == s.get_studentCode()) {
                return false;
            }
        }
        list.add(s);
        return true;
    }

    public void eraseStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student code: ");
        String studentCode = sc.nextLine();
        sc.close();
        if (eraseStudent(_listStudent, studentCode) != null) {
            System.out.println("Erase succeed");
        }
        else {
            System.out.println("Student not found");
        }
    }

    private Student eraseStudent(ArrayList<Student> list, String studentCode) {
        Student s = searchStudent(studentCode);
        if (s == null) {
            return null;
        }
        return eraseStudent(list, s);
    }

    private Student eraseStudent(ArrayList<Student> list, Student s) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get_studentCode() == s.get_studentCode()) {
                list.remove(i);
                return s;
            }
        }
        return null;
    }

    public void updateStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student code: ");
        String studentCode = sc.nextLine();
        sc.close();
        if (updateStudent(_listStudent, studentCode)) {
            System.out.println("Update succeed");
        }
        else {
            System.out.println("Update fail");
        }
    }

    private boolean updateStudent(ArrayList<Student> list, Student s) {
        Student temp = eraseStudent(list, s);
        if (temp != null) {
            Student sv = new Student();
            sv.inputInfo();
            if (addStudent(list, sv)) {
                return true;
            }
            else {
                addStudent(list, temp);
                return false;
            }
        }
        return false;
    }

    private boolean updateStudent(ArrayList<Student> list, String studentCode) {
        Student s = eraseStudent(list, studentCode);
        if (updateStudent(list, s)) {
            return true;
        }
        return false;
    }

    // public void importDataFromFile(String fileName) throws FileNotFoundException {
    //     DataInputStream fileInput = new DataInputStream(new FileInputStream(fileName));
    //     try {
    //         while (true) {
    //             String line = fileInput.readLine();
    //             if (line == null) {
    //                 break;
    //             }
    //             Student temp = readStudent(line);
    //             addStudent(_listStudent, temp);
    //         }
    //     }
    //     catch (IOException e) {
    //         System.err.println(e);
    //     }
    //     fileInput.close();
    // }

    public void importDataFromFile() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();
        importDataFromFile(fileName, _listStudent);
        sc.close();
    }

    private void importDataFromFile(String fileName, ArrayList<Student> list) {
        BufferedReader br = null;
        String line;
        try {
            br = new BufferedReader(new FileReader(fileName));
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                Student student = readStudent(line);
                addStudent(list, student);
            }
        }
        catch (FileNotFoundException e) {
            System.err.println(e);
        }
        catch (IOException e) {
            System.err.println(e);
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
    }

    public Student readStudent(String line) {
        String[] s = line.split(",");
        Student student = new Student(s[0], s[1], Float.parseFloat(s[2]), s[3], s[4]);
        return student;
    }

    public void printListStudent() {
        for (int i = 0; i < _listStudent.size(); i++) {
            System.out.println("Name: " + _listStudent.get(i).get_name());
            System.out.println("Student code: " + _listStudent.get(i).get_studentCode());
            System.out.println("Mark: " + _listStudent.get(i).get_mark());
            System.out.println("Address: " + _listStudent.get(i).get_address());
            System.out.println("Note: " + _listStudent.get(i).get_note());
            System.out.println("-----------------------------");
        }
    }

    private Student searchStudent(String studentCode) {
        for (int i = 0; i < _listStudent.size(); i++) {
            if (_listStudent.get(i).get_studentCode() == studentCode) {
                return _listStudent.get(i);
            }
        }
        return null;
    }

    private ArrayList<Student> _listStudent;

    public School () {
        _listStudent = new ArrayList<>();
    }

    public ArrayList<Student> get_listStudent() {
        return _listStudent;
    }

    public void set_listStudent(ArrayList<Student> _listStudent) {
        this._listStudent = _listStudent;
    }
}