/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryFunctions;

import Gui.*;

public class stack {

    private int stackSize;
    private String[] stack;
    private int top;

    public void createStack() {
        stackSize = 50;
        stack = new String[stackSize];
        top = -1;
    }

    public boolean isStackFull() {
        boolean full = false;
        if (top == stackSize - 1) {
            full = true;
        }
        return full;
    }

    public boolean isStackEmpty() {
        boolean empty = false;
        if (top == -1) {
            empty = true;
        }
        return empty;
    }

    public void addElement(String current) {

        boolean full = isStackFull();
        if (full) {

        } else {
            top = top + 1;
            stack[top] = current;

            
        }
    }

    public void removeElement() {

        boolean empty = isStackEmpty();
        if (empty) {
        } else {
            top = top -1;
        }

    }

    public String getTopElement() {

        boolean empty = isStackEmpty();
        String topPage = null;
        if (empty) {
            return null;
        } else {
            topPage = stack[top];
        }
        return topPage;
    }
    
    public void goBack(){
        
        removeElement();
        String previous = getTopElement();
        switch(previous){
            case "homePage": 
                HomePage home = new HomePage();
                home.setVisible(true);
              case "availableStands":

                AvailableStands stand = new AvailableStands();
                stand.setVisible(true);
                break;
            case "ticketDetails":

                TicketDetails ticketDetails = new TicketDetails();
                ticketDetails.setVisible(true);
                break;
            case "upcomingEvent":

                UpcomingEventsPage upcomingEvent = new UpcomingEventsPage();
                upcomingEvent.setVisible(true);
                break;
            case "adminHome":

                adminHome adminHome = new adminHome();
                adminHome.setVisible(true);
                break;
            case "availableSeats":

                availableSeats availableSeats = new availableSeats();
                availableSeats.setVisible(true);
                break;
            case "addEvent":

                addUpcomingEvent addEvent = new addUpcomingEvent();
                addEvent.setVisible(true);
                break;
           
        }  
        }
    
}
