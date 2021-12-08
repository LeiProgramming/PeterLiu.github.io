package com.edu.innerclass;

import com.edu.exercise.B;

public class InnerClassExercise02 {
    public static void main(String[] args) {
        cellphone phone = new cellphone();
        phone.alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("Get up!");
            }
        });

        phone.alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("Go to class!");
            }
        });
    }
}

interface Bell{
    void ring();
}

class cellphone{
    public void alarmclock(Bell bell){
        bell.ring();
    }
}