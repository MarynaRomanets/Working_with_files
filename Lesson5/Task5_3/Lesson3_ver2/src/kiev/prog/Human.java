package kiev.prog;

public class Human {
    private String lastName;
    private String firstName;
    private boolean sex;
    private int age;

    public Human() {
    }

    public Human(String lastName, String firstName, boolean sex, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.sex = sex;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return  "LastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}
