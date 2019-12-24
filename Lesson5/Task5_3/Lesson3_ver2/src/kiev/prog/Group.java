package kiev.prog;

import java.util.Arrays;

public class Group {
    private final byte SIZE = 10;
    private final byte SIZE_MISTAKE = 1;
    private int index;
    private Student[] group = new Student[SIZE];
    private Student[] mistakeList = new Student[SIZE_MISTAKE];

    public Group() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Student[] getGroup() {
        return group;
    }

    public void setGroup(Student[] group) {
        this.group = group;
    }

    public Student[] getMistakeList() {
        return mistakeList;
    }

    public void setMistakeList(Student[] mistakeList) {
        this.mistakeList = mistakeList;
    }

    @Override
    public String toString() {
        Arrays.sort(group, new StudentComparator());
        return "Group " + index + "{" +
                Arrays.toString(group)  +
                '}';
    }


    public Student[] addStudent (Student student) throws SizeGroupException, StudentInfoException {
        if (index < SIZE) {
            if (student instanceof Student) {
                if (student.getLastName() == null) {
                    throw new StudentInfoException("It's not possible to add Student without LastName: ", student);
                } else if (student.getFirstName() == null) {
                    throw new StudentInfoException("It's not possible to add Student without FirstName: ", student);
                } else if (student.getAge() < 16) {
                    throw new StudentInfoException("It's not possible to add Student with age < 16: ", student);
                } else {
                    if (index >= group.length) {
                        Student[] temp = new Student[index + 1];
                        for (int i = 0; i < index; i++) {
                            temp[i] = group[i];
                        }
                        temp[index] = student;
                        group = temp;
                        index++;
                        return group;
                    } else {
                        group[index++] = student;
                    }
                }
            }
        } else {
            mistakeList[0] = student;
            throw new SizeGroupException("Size of group must be < 10, size now is: ", index);
        }
        return group;
    }

    public Student[] deleteStudent (Student student) throws SizeGroupException, StudentInfoException {
        boolean flag = true;
        if (student instanceof Student) {
            if (index == 0) {
                throw new SizeGroupException("It's not possible to delete Student from empty group: ", index);
            } else {
                for (int i = 0; i < index; i++) {
                    if (group[i].getLastName().equals(student.getLastName()) && group[i].getFirstName().equals(student.getFirstName())) {
                        Student[] temp = new Student[index - 1];
                        for (int j = 0; j < i; j++) {
                            temp[j] = group[j];
                        }
                        for (int j = i; j < index-1; j++) {
                            temp[j] = group[j + 1];
                        }
                        index--;
                        group = temp;
                        flag = false;
                    }
                }
            }
        }
        return group;
    }

    public Student searchStudent (Student student) throws StudentInfoException {
        Student result = new Student();
        if (student instanceof Student) {
            for (int i = 0; i < index; i++) {
                if (group[i].getLastName().equals(student.getLastName()) && group[i].getFirstName().equals(student.getFirstName())) {
                    result = group[i];
                }
            }
        }
        return result;
    }

    public String viewMistakeList() {
        return "MistakeList{" + Arrays.toString(mistakeList) + '}';
    }

}
