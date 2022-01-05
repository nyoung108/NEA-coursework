
package Objects;

import org.apache.derby.client.am.DateTime;

public class eventDetailsObject {
    String eventID;
    String eventName;
    String eventType;
    DateTime dateTime;
    float eventPrice;

    public eventDetailsObject(String eventID, String eventName, String eventType, DateTime dateTime, float eventPrice) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventType = eventType;
        this.dateTime = dateTime;
        this.eventPrice = eventPrice;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public float getEventPrice() {
        return eventPrice;
    }

    public void setEventPrice(float eventPrice) {
        this.eventPrice = eventPrice;
    }
    
}
