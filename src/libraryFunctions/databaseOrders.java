/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryFunctions;

import Objects.*;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class databaseOrders {

    private static userDetailsObject currentUser;
    private static ticketDetailsObject currentTicket;

    public static boolean userLogIn(String email, String password) {
        boolean validUser = false;
        try {
            String hashedPassword = hash.hashedPassword(password);
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM usertable where email = '" + email + "' AND password = '" + password + "'";
            ResultSet rs = databaseManagement.executeQuery(sql);

            if (rs.next()) {
                currentUser = new userDetailsObject(rs.getString("USERID"), rs.getString("email"), rs.getString("password"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("dateOfBirth"));
                validUser = true;
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }
        return validUser;
    }
    public static String returnUserID(){
        String userID = currentUser.getUserID();
        return userID;
    }

    public static void addUser(String userID, String email, String password, String firstName, String lastName, String dateOfBirth) {
        try {
            String hashedPassword = hash.hashedPassword(password);
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "INSERT INTO USERTABLE (userID, email, password, firstname, lastname, dateofbirth) VALUES (" + userID + ", " + email + ", " + hashedPassword + ", " + firstName + ", " + lastName + ", " + dateOfBirth + ")";
            ResultSet rs = databaseManagement.executeQuery(sql);

            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }

    }
    

    public static void addBooking(bookingDetailsObject booking) {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql= "INSERT INTO BOOKINGTABLE (bookingId, userId, ticketID, datebooked) VALUES ('"+booking.getBookingID()+"', '"+booking.getUserID()+"', '"+booking.getTicketID()+"', '"+booking.getDateBooked()+"');";
            ResultSet rs = databaseManagement.executeQuery(sql);
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }

    }
    
    public static void addTicket(){
         try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql= "INSERT INTO ";
            ResultSet rs = databaseManagement.executeQuery(sql);
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }
      
    }
    public static void seatsBooked(){
        ArrayList<String> seatsBooked = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql= "SELECT TICKETTABLE.seatID FROM ticketTABLE WHERE EXISTS (SELECT SEATTABLE.seatID FROM SEATTABLE WHERE stand = "+1+") AND TICKETID.EVENTID ="+2;
            ResultSet rs = databaseManagement.executeQuery(sql);
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }
    }
    
    public static String updateEmail(String email, String userID){
       
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql= "update usertable set email ="+email+" where userID = "+userID;
            ResultSet rs = databaseManagement.executeQuery(sql);          
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }
    public static boolean isAdmin(String email, String password) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select adminID from admintable where exists (select userID from usertable where password= '" + password + "' and email= '" + "email');";
            ResultSet rs = databaseManagement.executeQuery(sql);
            boolean admin = rs.getBoolean(sql);
            rs.close();

            con.close();
            return admin;
        } catch (Exception e) {
            System.out.println(e);

        }

        return false;
    }

    public static void deleteEvent(String eventID) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Delete from eventtable and musictable and sporttable where eventID = '" + eventID + "';";
            ResultSet rs = databaseManagement.executeQuery(sql);
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }
        
    }

    public static String getEventID(String name) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select eventID from eventtable where name = '" + name + "';";
            ResultSet rs = databaseManagement.executeQuery(sql);
            String eventID = rs.getNString(sql);
            rs.close();
            con.close();
            return eventID;
        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }
    
    
    public static ArrayList<String> getTakenSeatID(String name, ArrayList<String> takenSeatID) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select seatID from ticketTable where eventID='"+name+"';";
            ResultSet rs = databaseManagement.executeQuery(sql);
            while(rs.next()){
                String seatNumber = rs.getString(sql);
                takenSeatID.add(seatNumber);
            }
            rs.close();
            con.close();
            return takenSeatID;
        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }
    public static int getSeatRow(String stand, String seatID) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            String sql = "Select row from seatTable where stand='"+stand+"' AND seatID= '"+seatID+"';";
            ResultSet rs = databaseManagement.executeQuery(sql);
            int row = Integer.parseInt(rs.getNString(sql));
            rs.close();
            con.close();
            return row;
        } catch (Exception e) {
            System.out.println(e);

        }
        return -1;
    }
    public static int getSeatColumn(String stand, String seatID) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            String sql = "Select column from seatTable where stand='"+stand+"' AND seatID= '"+seatID+"';";
            ResultSet rs = databaseManagement.executeQuery(sql);
            int column = Integer.parseInt(rs.getNString(sql));
            rs.close();
            con.close();
            return column;
        } catch (Exception e) {
            System.out.println(e);

        }
        return -1;
    }
    public static ArrayList<String> getUpcomingEvents(ArrayList<String> events) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select name from eventTable;";
            ResultSet rs = databaseManagement.executeQuery(sql);
            while(rs.next()){
                String name = rs.getString(sql);
                events.add(name);
            }
            rs.close();
            con.close();
            return events;
        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }
    public static double getEventPrice(String eventID) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select price from eventTable where eventID ='"+eventID+"';";
            ResultSet rs = databaseManagement.executeQuery(sql);
            double eventPrice = rs.getDouble(sql);
            rs.close();
            con.close();
            return eventPrice;
        } catch (Exception e) {
            System.out.println(e);

        }
        return 0;
    }
}
