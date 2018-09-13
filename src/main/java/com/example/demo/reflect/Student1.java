package com.example.demo.reflect;

/**
 * @Description
 * @Author huqifeng
 * @Date 2018/09/13 14:39
 */
public class Student1 {

    public Student1() {
    }

    //**********字段*************//
    public String name;
    protected int age;
    char sex;
    private String phoneNum;

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", sex=" + sex
                + ", phoneNum=" + phoneNum + "]";
    }


}
