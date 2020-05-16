import java.util.Scanner;

public class Student {

    public void inputInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student's name: ");
        _name = sc.nextLine();
        System.out.print("Enter student code: ");
        _studentCode = sc.nextLine();
        System.out.print("Enter student's mark: ");
        _mark = sc.nextFloat();
        sc.nextLine();
        System.out.print("Enter student's address: ");
        _address = sc.nextLine();
        System.out.print("Enter note: ");
        _note = sc.nextLine();
        // sc.close();
    }

    private String _name;
    private String _studentCode;
    private float _mark;
    private String _address;
    private String _note;

    public Student() {
        _name = _studentCode = _address = _note = "";
        _mark = 0f;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_studentCode() {
        return _studentCode;
    }

    public void set_studentCode(String _studentCode) {
        this._studentCode = _studentCode;
    }

    public float get_mark() {
        return _mark;
    }

    public void set_mark(float _mark) {
        this._mark = _mark;
    }

    public String get_address() {
        return _address;
    }

    public void set_address(String _address) {
        this._address = _address;
    }

    public String get_note() {
        return _note;
    }

    public void set_note(String _note) {
        this._note = _note;
    }

    public Student(String _name, String _studentCode, float _mark, String _address, String _note) {
        this._name = _name;
        this._studentCode = _studentCode;
        this._mark = _mark;
        this._address = _address;
        this._note = _note;
    }
}