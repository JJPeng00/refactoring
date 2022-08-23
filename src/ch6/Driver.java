package ch6;

public class Driver {

    //延迟交货数量
    private int numberOfLateDeliveries;

    public Driver(int numberOfLateDeliveries) {
        this.numberOfLateDeliveries = numberOfLateDeliveries;
    }

    public int getNumberOfLateDeliveries() {
        return numberOfLateDeliveries;
    }

    public void setNumberOfLateDeliveries(int numberOfLateDeliveries) {
        this.numberOfLateDeliveries = numberOfLateDeliveries;
    }
}

