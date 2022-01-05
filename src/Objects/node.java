package Objects;


public class node {
    private String eventObject;
    private String nextNode;

    public node(String eventObject) {
        this.eventObject = eventObject;
        this.nextNode = null;
    }

    public String getEventObject() {
        return eventObject;
    }

    public void setEventObject(String eventObject) {
        this.eventObject = eventObject;
    }

    public String getNextNode() {
        return nextNode;
    }

    public void setNextNode(String nextNode) {
        this.nextNode = nextNode;
    }
   
}
