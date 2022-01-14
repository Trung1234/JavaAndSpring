package com.trungnt.excep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public Customer findByName(String name) throws NameNotFoundException {

        if (name == null || name == "") {
            throw new NameNotFoundException("Name is NULL or EMPTY!");
        }

        return new Customer(name);

    }
    public void analyze(List<String> data) {

        if (data.size() > 50) {
            //runtime exception
            throw new ListTooLargeException("List can't exceed 50 items!");
        }
    }
    public static void main(String[] args) {

        Main obj = new Main();

//        try {
//
//            Customer cus = obj.findByName("");
//
//        } catch (NameNotFoundException e) {
//            e.printStackTrace();
//        }
        //create 100 size
        List<String> data = new ArrayList<>(Collections.nCopies(100, "Vunv"));

        obj.analyze(data);

    }
}
