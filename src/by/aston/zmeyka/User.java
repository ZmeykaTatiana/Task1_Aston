package by.aston.zmeyka;

public class User implements Comparable<User> {
    private int age;


    public User(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        return this.age-o.age;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                '}';
    }
}
