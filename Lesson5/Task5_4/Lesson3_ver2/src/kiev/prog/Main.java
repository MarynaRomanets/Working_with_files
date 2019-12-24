package kiev.prog;

import java.io.File;
import java.io.IOException;

import static kiev.prog.FileServiceGroup.*;
import static kiev.prog.Group.createGroup;
import static kiev.prog.Group.readGroupFromFile;

public class Main {

    public static void main(String[] args) {
        Group group1 = new Group();
        Student student1 = new Student("Z", "Sergiy", true, 18, 25, 1, 1024);
        Student student2 = new Student("V", "Nataliya", false, 18, 25, 1, 1025);
        Student student3 = new Student("A", "Alex", true, 17, 25, 1, 1026);
        Student student4 = new Student("C", "Maria", false, 16, 25, 1, 1027);
        Student student5 = new Student("T", "Stepan", true, 18, 25, 1, 1028);
        Student student6 = new Student("S", "Stephan", true, 19, 25, 1, 1029);
        Student student7 = new Student("L", "Olha", false, 17, 25, 1, 1030);
        Student student8 = new Student("L", "Andrey", true, 20, 25, 1, 1031);
        Student student9 = new Student("A", "Ihor", true, 18, 25, 1, 1032);
        Student student10 = new Student("W", "Boris", true, 17, 25, 1, 1033);

        Student student11 = new Student("S", "David", true, 21, 25, 1, 1034);
        Student student12 = new Student("R", "Nick", true, 17, 25, 1, 1035);
        Student student13 = new Student("F", "Peter", true, 19, 25, 1, 1036);

        try {
            group1.addStudent(student1);
            group1.addStudent(student2);
            group1.addStudent(student3);
            group1.addStudent(student4);
            group1.addStudent(student5);
            group1.addStudent(student6);
            group1.addStudent(student7);
            group1.addStudent(student8);
            group1.addStudent(student9);
            group1.addStudent(student10);
            System.out.println(group1);

            /* reading students from file and creating new group */
            String path = "c:/myFolder/groupStudent.txt";
            File fileGroup = new File(path);
            Group group2 = new Group();
            Student[] studentsFromFile = readGroupFromFile(path);
            createGroup(group2, studentsFromFile);
            System.out.println("Group2: " + group2);

            /* delete student from group */
            group1.deleteStudent(student2);
            System.out.println(group1);

            /* attempt to delete student which is not from this group */
            group1.deleteStudent(student12);
            System.out.println(group1);

            /* delete student from group */
            group1.deleteStudent(student3);
            System.out.println(group1);

            /* search student6 */
            System.out.println("Search student: " + group1.searchStudent(student6));

            /* search student12 which is not from this group */
            System.out.println("Search student: " + group1.searchStudent(student12));

            /* add student11 */
            group1.addStudent(student11);
            System.out.println(group1);

            /* add student12 */
            group1.addStudent(student12);
            System.out.println(group1);

            /* add more students then size of group */
            //group1.addStudent(student13);
            //System.out.println(group1);

        } catch (SizeGroupException e) {
            System.out.println(e.getMessage() + e.getSize());
        } catch (StudentInfoException e) {
            System.out.println(e.getMessage() + e.getStudent());
        } catch (IOException e) {
            System.out.println("Error with file operation: " + e.getStackTrace());
        }

        /* view student after attempt to add student, when group size = 10 */
        System.out.println("MistakeList: " + group1.viewMistakeList());
    }
}

