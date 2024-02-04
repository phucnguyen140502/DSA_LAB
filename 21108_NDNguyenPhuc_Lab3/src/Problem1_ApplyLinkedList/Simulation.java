package Problem1_ApplyLinkedList;


public class Simulation {
    public static void main(String[] args) {
        //
        LinkQueueApp<Customer> queueApp = new LinkQueueApp<>();

        System.out.println("THE SIMULATION THE QUEUE OF CUSTOMERS IN 1 HOUR");

        // Simulation parameters
        int arrivalRate = 10; // Customers per minute
        int serviceTimeMin = 5; // Minimum service time in minutes
        int serviceTimeMax = 10; // Maximum service time in minutes
        int simulationTime = 60; // Simulation duration in minutes

        int servedCount = 0; // Number of customers served

        for (int time = 0; time < simulationTime * 60; time++) {
            if (Math.random() < arrivalRate / 60.0) {
                int serviceTime = (serviceTimeMax - serviceTimeMin + 1) + serviceTimeMin;
                Customer customer = new Customer(time, serviceTime);
                queueApp.add(customer);
            }

            // Served Customer
            System.out.println("The amounts of customers need to process: " + queueApp.size());
            if (!queueApp.isEmpty()) {
                Customer proccessingCustomer = queueApp.peekFirst();
                int TimeProcessing = proccessingCustomer.getServiceTime();
                TimeProcessing--;
                proccessingCustomer.setServiceTime(TimeProcessing);
                System.out.println("The remaining time to process for customer at "+proccessingCustomer.getArrivalTime() +"th minute is processed: "+proccessingCustomer.getServiceTime()+"\n");
                if (proccessingCustomer.getServiceTime() == 0) {
                    System.out.println("The Customer at "+proccessingCustomer.getArrivalTime()+"th minute is processed\n");
                    queueApp.pop();
                    servedCount++;
                }
            }
            System.out.println("The amount of customers are served: "+ servedCount);
            System.out.println();
        }
        System.out.println("------------------------------------------------");
        System.out.println("FINISH THE SIMULATION IN 1 HOUR");
        System.out.println("The customers are not served: ");
        queueApp.traverse();
    }
}
