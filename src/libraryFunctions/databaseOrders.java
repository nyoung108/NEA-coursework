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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class databaseOrders {

    private static userDetailsObject currentUser;
    private static ticketDetailsObject currentTicket;
    private static stack myStack;
    private static String tempEventName;
    private static String stand;

    public static boolean userLogIn(String email, String password) {
        boolean validUser = false;
        try {
            String hashedPassword = hash.hashedPassword(password);
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM usertable where email = '" + email + "' AND password = '" + hashedPassword + "'";
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

    public static String returnUserID() {
        String userID = currentUser.getUserID();
        return userID;
    }

    public static stack returnStack() {
        return myStack;
    }

    public static void setTicketType(String type) {
        currentTicket.setType(type);
    }

    public static String returnTicketType() {
        return currentTicket.getType();
    }

    public static void setStand(String standName) {
        stand = standName;
    }

    public static String returnStand() {
        return stand;
    }

    public static void tempEvent(String eventName) {
        tempEventName = eventName;
    }

    public static String returnEventName() {
        return tempEventName;
    }

    public static String returnEmail() {
        return currentUser.getEmail();
    }

    public static String returnFirstName() {
        return currentUser.getFirstName();
    }

    public static String returnLastName() {
        return currentUser.getLastName();
    }

    public static String returnDateOfBirth() {
        return currentUser.getDateOfBirth();
    }

    public static String returnPassword() {
        return currentUser.getPassword();
    }

    public static ArrayList<String> getTicketID() {
        try {
            ArrayList<String> ticketID = new ArrayList<>();
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select ticketID from bookingtable where userID = '" + currentUser.getUserID() + "';";
            ResultSet rs = databaseManagement.executeQuery(sql);
            while (rs.next()) {
                String seatNumber = rs.getString(sql);
                ticketID.add(seatNumber);
            }

            rs.close();
            con.close();
            return ticketID;
        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }

    public static void updateEmail(String email) {
        try {

            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Update usertable set email = '" + email + "' where userID = '" + currentUser.getEmail() + "';";
            ResultSet rs = databaseManagement.executeQuery(sql);

            rs.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);

        }

    }
    public static void updatePassword(String password) {
        try {

            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Update usertable set password = '" + password + "' where userID = '" + currentUser.getEmail() + "';";
            ResultSet rs = databaseManagement.executeQuery(sql);

            rs.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);

        }

    }
    public static void updateLastName(String password) {
        try {

            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Update usertable set password = '" + password + "' where userID = '" + currentUser.getEmail() + "';";
            ResultSet rs = databaseManagement.executeQuery(sql);

            rs.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public static String getTicketIDChosen(String ticketIDStr, String eventID) {
        try {

            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select ticketID from tickettable where ticketID = '" + ticketIDStr + "'AND eventID = '" + eventID + "';";
            ResultSet rs = databaseManagement.executeQuery(sql);

            String ticketID = rs.getString(sql);

            rs.close();
            con.close();
            return ticketID;
        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }

    public static void addUser(userDetailsObject user) {
        try {

            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "INSERT INTO USERTABLE Values('" + user.getUserID() + "', '" + user.getEmail() + "', '" + user.getPassword() + "', '" + user.getFirstName() + "', '" + user.getLastName() + "', '" + user.getDateOfBirth() + "');";
            ResultSet rs = databaseManagement.executeQuery(sql);
            currentUser.equals(user);
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
            String sql = "INSERT INTO BOOKINGTABLE (bookingId, userId, ticketID, datebooked) VALUES ('" + booking.getBookingID() + "', '" + booking.getUserID() + "', '" + booking.getTicketID() + "', '" + booking.getDateBooked() + "');";
            ResultSet rs = databaseManagement.executeQuery(sql);
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public static void addTicket(ticketDetailsObject ticket) {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "INSERT INTO tickettable values ('" + ticket.getTicketID() + "', '" + ticket.getEventID() + "', '" + ticket.getSeatID() + "', '" + ticket.getType() + "', '" + ticket.getPrice() + "');";
            ResultSet rs = databaseManagement.executeQuery(sql);
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public static void seatsBooked() {
        ArrayList<String> seatsBooked = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT TICKETTABLE.seatID FROM ticketTABLE WHERE EXISTS (SELECT SEATTABLE.seatID FROM SEATTABLE WHERE stand = " + 1 + ") AND TICKETID.EVENTID =" + 2;
            ResultSet rs = databaseManagement.executeQuery(sql);
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }
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

    public static String getEvent(String ticketID, String name) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select eventID from tickettable where ticketID = '" + ticketID + "'AND name = '" + name + "';";
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

    public static String getSeat(String ticketID) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select seatID from tickettable where ticketID = '" + ticketID + "';";
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

    public static String getEventName(String eventID) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select name from eventtable where eventID = '" + eventID + "';";
            ResultSet rs = databaseManagement.executeQuery(sql);
            String name = rs.getNString(sql);
            rs.close();
            con.close();
            return name;
        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }

    public static String getStandName(String seatID) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select stand from eventtable where seatID = '" + seatID + "';";
            ResultSet rs = databaseManagement.executeQuery(sql);
            String stand = rs.getNString(sql);
            rs.close();
            con.close();
            return stand;
        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }

    public static int getSeatRow(String seatID) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select row from seattable where seatID = '" + seatID + "';";
            ResultSet rs = databaseManagement.executeQuery(sql);
            int row = rs.getInt(sql);
            rs.close();
            con.close();
            return row;
        } catch (Exception e) {
            System.out.println(e);

        }
        return -1;
    }

    public static int getSeatColumn(String seatID) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select column from seattable where seatID = '" + seatID + "';";
            ResultSet rs = databaseManagement.executeQuery(sql);
            int column = rs.getInt(sql);
            rs.close();
            con.close();
            return column;
        } catch (Exception e) {
            System.out.println(e);

        }
        return -1;
    }

    public static ArrayList<String> getTakenSeatID(String name, ArrayList<String> takenSeatID) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select seatID from ticketTable where eventID='" + name + "';";
            ResultSet rs = databaseManagement.executeQuery(sql);
            while (rs.next()) {
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

            String sql = "Select row from seatTable where stand='" + stand + "' AND seatID= '" + seatID + "';";
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

            String sql = "Select column from seatTable where stand='" + stand + "' AND seatID= '" + seatID + "';";
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
            while (rs.next()) {
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
            String sql = "Select price from eventTable where eventID ='" + eventID + "';";
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

    public static String getSeatID(String stand, int row, int column) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select seatID from seattable where stand = '" + stand + "' AND row = '" + row + "' AND column = '" + column + "';";
            ResultSet rs = databaseManagement.executeQuery(sql);
            String seatID = rs.getNString(sql);
            rs.close();
            con.close();
            return seatID;
        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }

    public static void addMusic(musicObject music) {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "INSERT INTO musicTABLE (musicID, eventID, genre, performer, warmUpAct) VALUES ('" + music.getMusicID() + "', '" + music.getEventID() + "', '" + music.getMusicType() + "', '" + music.getPerformerName() + "', '" + music.getWarmupAct() + "');";
            ResultSet rs = databaseManagement.executeQuery(sql);
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public static void addMusicEvent(musicObject music) {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "INSERT INTO eventTABLE (eventID, name, type, date, time, price) VALUES ('" + music.getEventID() + "', '" + music.getEventName() + "', '" + music.getEventType() + "', '" + music.getDate() + "', '" + music.getTime() + "', '" + music.getEventPrice() + "');";
            ResultSet rs = databaseManagement.executeQuery(sql);
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public static void addSport(sportObject sport) {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "INSERT INTO sportTABLE (sportID, eventID, type, homeTeam, awayTeam) VALUES ('" + sport.getSportID() + "', '" + sport.getEventID() + "', '" + sport.getSportType() + "', '" + sport.getHomeTeam() + "', '" + sport.getAwayTeam() + "');";
            ResultSet rs = databaseManagement.executeQuery(sql);
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public static void addSportEvent(sportObject sport) {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "INSERT INTO eventTABLE (eventID, name, type, date, time, price) VALUES ('" + sport.getEventID() + "', '" + sport.getEventName() + "', '" + sport.getEventType() + "', '" + sport.getDate() + "', '" + sport.getTime() + "', '" + sport.getEventPrice() + "');";
            ResultSet rs = databaseManagement.executeQuery(sql);
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public static int getNumberOfTickets() {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select count (bookingID) from bookingtable where userID = '" + currentUser.getUserID() + "';";
            ResultSet rs = databaseManagement.executeQuery(sql);
            int numberOfTickets = rs.getInt(sql);
            rs.close();
            con.close();
            return numberOfTickets;
        } catch (Exception e) {
            System.out.println(e);

        }
        return 0;
    }

    public static LocalDate getDate(String name) {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingSystemNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "Select date from eventTable where name = '" + name + "';";
            ResultSet rs = databaseManagement.executeQuery(sql);
            String dateStr = rs.getNString(sql);
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(dateStr, dateFormatter);

            rs.close();
            con.close();
            return date;
        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }
}
