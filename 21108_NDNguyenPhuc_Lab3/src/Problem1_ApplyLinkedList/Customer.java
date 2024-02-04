package Problem1_ApplyLinkedList;

public class Customer{
    private int arrivalTime; // Time when customer arrives
    private int serviceTime; // Time needed to serve the customer

    public Customer(int arrivalTime, int serviceTime) {
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }



    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "arrivalTime=" + arrivalTime +
                ", serviceTime=" + serviceTime +
                '}';
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }


}
