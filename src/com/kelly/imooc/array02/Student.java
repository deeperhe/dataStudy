package com.kelly.imooc.array02;

/**
 * Created by 贺望香 on 2019/2/14.
 */
public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Student(name:%s，score:%d)",name,score);
    }

    public static void main(String[] args) {
        UpdateArray<Student> arr = new UpdateArray();
        arr.addLast(new Student("aa",100));
        arr.addLast(new Student("bb",101));
        arr.addLast(new Student("cc",102));
        System.out.println(arr);
    }
}
