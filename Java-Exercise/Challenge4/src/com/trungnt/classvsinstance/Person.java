package com.trungnt.classvsinstance;

public class Person {
    public int age;

    public Person(int initialAge) {
        this.age = initialAge;
        if(age < 0){
            age = 0;
            System.out.println("Age is not valid, setting age to 0");
        }
    }
    public void yearPasses(){
        this.age ++;
    }
    public void amIOld(){
        if(age<13){
            System.out.println("You are young");
        }
        else if(age<=13){
            System.out.println("You are a teenager");
        }else {
            System.out.println("You are old");

        }
    }
}
