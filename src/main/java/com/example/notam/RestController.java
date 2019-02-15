package com.example.notam;


import org.springframework.web.bind.annotation.CrossOrigin;
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

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/AirportCode")
    NotamModel airportcodestring(@RequestBody String AirportCode) {
        //Creating initial database_connection
        Database_Layout_Manager database_connection =  new Database_Layout_Manager();

        //Establish Connection to Database
        database_connection.connect();

        //Getting String Value from Matching Notams
        NotamModel results = database_connection.testGetEntry(AirportCode);

        //Disconnect from Database
        database_connection.disconnect();
        return results;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/RawNotamFromKey")
    String rawnotamstring(@RequestBody String NotamKey) {
        //Creating initial database_connection
        Database_Layout_Manager database_connection =  new Database_Layout_Manager();

        //Establish Connection to Database
        database_connection.connect();

        //Getting String Value from Matching Notams
        String results = database_connection.testGetRaw(NotamKey);

        //Disconnect from Database
        database_connection.disconnect();
        return results;
    }

    @GetMapping("/atlanta")
    String atlanta() { return "atlanta"; }
}
