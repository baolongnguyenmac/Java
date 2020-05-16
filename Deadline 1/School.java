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
            if (list.get(i).get_studentCode().equals(s.get_studentCode())) {
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
        if (eraseStudent(_listStudent, studentCode) != null) {
            System.out.println("Erase succeed");
        }
        else {
            System.out.println("Student not found");
        }
        // sc.close();
    }

    private Student eraseStudent(ArrayList<Student> list, String studentCode) {
        Student s = searchStudent(list, studentCode);
        if (s == null) {
            return null;
        }
        return eraseStudent(list, s);
    }

    private Student eraseStudent(ArrayList<Student> list, Student s) {
        if (list.remove(s)) {
            return s;
        }
        return null;
    }

    public void updateStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student code: ");
        String studentCode = sc.nextLine();
        if (updateStudent(_listStudent, studentCode)) {
            System.out.println("Update succeed");
        }
        else {
            System.out.println("Update fail");
        }
        // sc.close();
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
        Student s = searchStudent(list, studentCode);
        if (updateStudent(list, s)) {
            return true;
        }
        return false;
    }

    public void exportDataToFile() {
        System.out.print("Enter filename(.csv): ");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        exportDataToFile(fileName);
        // sc.close();
    }

    private void exportDataToFile(String fileName) {
        save(_listStudent, fileName);
    }

    public void save() {
        save(_listStudent, "Data.csv");
    }

    private void save(ArrayList<Student> list, String fileName) {
        BufferedWriter bw = null;
        String line;
        try {
            bw = new BufferedWriter(new FileWriter(fileName));
            bw.write("name,code,mark,address,note\n");
            for (int i = 0; i < list.size(); i++) {
                line = list.get(i).get_name() + "," + list.get(i).get_studentCode() + "," + list.get(i).get_mark() + "," + list.get(i).get_address() + "," + list.get(i).get_note() + "\n";
                bw.write(line);
            }
        }
        catch (IOException e) {
            System.err.println(e);
        }
        finally {
            if (bw != null) {
                try {
                    bw.close();
                }
                catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
    }

    public void importDataFromFile() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();
        importDataFromFile(fileName, _listStudent);
        // sc.close();
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

    public Student searchStudent(String studentCode) {
        return searchStudent(_listStudent, studentCode);
    }

    private Student searchStudent(ArrayList<Student> list, String studentCode) {
        for (int i = 0; i < _listStudent.size(); i++) {
            if (list.get(i).get_studentCode().equals(studentCode)) {
                return list.get(i);
            }
        }
        return null;
    }

    private ArrayList<Student> _listStudent;

    public School () {
        _listStudent = new ArrayList<>();
        importDataFromFile("Data.csv", _listStudent);
    }

    public ArrayList<Student> get_listStudent() {
        return _listStudent;
    }

    public void set_listStudent(ArrayList<Student> _listStudent) {
        this._listStudent = _listStudent;
    }
}