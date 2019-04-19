package com.example.notam;

import java.util.ArrayList;

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
        database_connection.countNumEntries();

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
        NotamModel results = database_connection.getEntry(AirportCode);

        //Disconnect from Database
        database_connection.disconnect();
        return results;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/AirportCodeMultiple")
    Object[] airportcodemultiplestring(@RequestBody String AirportCode) {
        //Creating initial database_connection
        Database_Layout_Manager database_connection =  new Database_Layout_Manager();

        //Establish Connection to Database
        database_connection.connect();

        //Getting String Value from Matching Notams
        Object[] results = database_connection.getMultipleEntries(AirportCode);

        //Disconnect from Database
        database_connection.disconnect();
        return results;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/GetAllNotams")
    Object[] getAllNotamsInDatabase() {
        //Creating initial database_connection
        Database_Layout_Manager database_connection =  new Database_Layout_Manager();

        //Establish Connection to Database
        database_connection.connect();

        //Getting String Value from Matching Notams
        Object[] results = database_connection.getAllNotams();

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
        String results = database_connection.getRawNotamData(NotamKey.toUpperCase());

        //Disconnect from Database
        database_connection.disconnect();
        return results;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/LongandLatfromCoords")
    String longAndLatFromCoords(@RequestBody String AirportCode) {
        //Creating initial database_connection
        Database_Layout_Manager database_connection = new Database_Layout_Manager();

        //Establish Connection to Database
        database_connection.connect();

        //Getting String Value from Matching Notams
        String results = database_connection.getAirportCoordinates(AirportCode);
        //Disconnect from Database
        database_connection.disconnect();
        return results;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/AllNotamCoords")
    ArrayList<Object> getAllNotamCoords(@RequestBody Object[] airportCodes) {
        //Creating initial database_connection
        Database_Layout_Manager database_connection = new Database_Layout_Manager();

        //Establish Connection to Database
        database_connection.connect();
        // results are arraylist of airport coordinates in JSON string format
        ArrayList<Object> results;
        results = database_connection.getAllAirportCoordinates(airportCodes);

        //Disconnect from Database
        database_connection.disconnect();
        return results;
    }

    @GetMapping("/atlanta")
    String atlanta() { return "atlanta"; }
}
