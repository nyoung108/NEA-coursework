
package Objects;

public class seatDetailsObject {
    String seatID;
    int row;
    int column;
    String Stand;
    float price;

    public seatDetailsObject(String seatID, int row, int column, String Stand, float price) {
        this.seatID = seatID;
        this.row = row;
        this.column = column;
        this.Stand = Stand;
        this.price = price;
    }

    public String getSeatID() {
        return seatID;
    }

    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getStand() {
        return Stand;
    }

    public void setStand(String Stand) {
        this.Stand = Stand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return seatID + ", " + row + ", " + column + ", " + Stand + ", " + price;
    }
    
}
