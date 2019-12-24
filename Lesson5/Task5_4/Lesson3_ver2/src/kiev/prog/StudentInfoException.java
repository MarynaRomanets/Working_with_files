package kiev.prog;

public class StudentInfoException extends Exception {
    private Student student;

    public StudentInfoException(String message, Student student) {
        super(message);
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "DeleteStudentException{" +
                "student=" + student +
                '}';
    }
}
