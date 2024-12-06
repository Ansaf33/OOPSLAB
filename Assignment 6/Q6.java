public class Q6 {

    public static void main(String[] args) {
        TicketBooking t1 = new TicketBooking();
        VIPBooking v1 = new VIPBooking();

        System.out.println("==== REGULAR TICKET ====");
        t1.bookTicket();
        double tFee = t1.calculateBookingFees(200.0);

        System.out.println("Regular Booking Fee : $ " + tFee);
        System.out.println();

        System.out.println("==== VIP TICKET ====");
        v1.bookTicket();
        double vFee = v1.calculateBookingFees(2000);
        System.out.println("VIP Booking Fee : $ " + vFee);
        
    }
    
}


class TicketBooking{

    void bookTicket(){
        System.out.println("Booking Regular Ticket...");
    }

    double calculateBookingFees(double ticketPrice){
        return 0.1*ticketPrice;
    }

}

class VIPBooking extends TicketBooking{

    void bookTicket(){
        System.out.println("Booking VIP ticket with additional perks..");

    }

    double calculateBookingFees(double ticketPrice){
        return 0.05*ticketPrice;
    }

}
