package com.edu.enum_;

public class Enumeration01 {

    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.WINTER);
    }
}


enum Season{
    SPRING("spring","warm"),    WINTER("winter","cold");
    private String name;
    private String desc;

//    constructor to private
//    move setXXX
//    creat objects


    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }


    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}