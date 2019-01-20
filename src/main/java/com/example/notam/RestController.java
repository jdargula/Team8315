package com.example.notam;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/hello")
    String hello() {
        return "hello";
    }

    @GetMapping("/database_test")
    String database_test() {

        //Creating initial database_connection
        Database_Layout_Manager database_connection =  new Database_Layout_Manager();

        //Establish Connection to Database
        database_connection.connect();

        //Create Tables
        database_connection.createTables();

        //Adding Test Entry
        database_connection.testAddEntry();

        //Count Entrees
        database_connection.countEntres();

        //Disconnect from Database
        database_connection.disconnect();
        return "Tested_database";
    }

    @PostMapping("/hello")
    String helloName(@RequestBody String name) {
        return "hello " + name;
    }

    @GetMapping("/atlanta")
    String atlanta() { return "atlanta"; }
}
