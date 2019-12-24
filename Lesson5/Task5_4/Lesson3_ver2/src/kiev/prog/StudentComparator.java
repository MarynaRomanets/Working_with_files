package kiev.prog;

import java.util.Comparator;

public class StudentComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 != null && o2 == null) {
            return 1;
        }
        if (o1 == null && o2 != null) {
            return -1;
        }
        if (o1 == null && o2 == null) {
            return 0;
        }
        Student st1 = (Student) o1;
        Student st2 = (Student) o2;
        return st1.getLastName().compareTo(st2.getLastName());
    }
}