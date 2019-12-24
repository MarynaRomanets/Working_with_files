package kiev.prog;

public class Student extends Human {
    private int department;
    private int groupNumber;
    private int recordBook;

    public Student() {
    }

    public Student(String lastName, String firstName, boolean sex, int age, int department, int groupNumber, int recordBook) {
        super(lastName, firstName, sex, age);
        this.department = department;
        this.groupNumber = groupNumber;
        this.recordBook = recordBook;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public int getRecordBook() {
        return recordBook;
    }

    public void setRecordBook(int recordBook) {
        this.recordBook = recordBook;
    }

    @Override
    public String toString() {
        return  "Student{" + super.toString() +
                "department=" + department +
                ", group=" + groupNumber +
                ", recordBook=" + recordBook +
                '}';
    }
}