package com.edu.innerclass;

public class InnerClass01 {
    public static void main(String[] args) {

    }
}

class Outer{
    private int n1 = 100;
    public void m1(){

    }

    public Outer(int n1) {
        this.n1 = n1;
    }

    {
        System.out.println("code block");
    }

    class Inner{

    }
}
