
import java.util.ArrayList;

class Q8{
    
    public static void main(String[] args) {
    EventManager manager = new EventManager();
    Event c = new Concert("Summer Music Festival",100,"The Jazz Band.");
    Event p = new TheaterPlay("Shakespeare's Hamlet",50,"John Doe");
    Event s = new SportsGame("City Derby",200,"Team A v/s Team B");
    manager.addEvent(c);
    manager.addEvent(s);
    manager.addEvent(p);
    manager.bookEventTickets("Summer Music Festival",100);
    manager.cancelEventTickets("Summer Music Festival",10);
    manager.bookEventTickets("City Derby",24);
    manager.bookEventTickets("City Derby",33);
    manager.displayAllEvents();
    }


}

interface Event{

    String getEventName();
    int getAvailableTickets();
    boolean bookTickets(int numberOfTickets);
    boolean cancelTickets(int numberOfTickets);
    void displayInfo();


}

class Concert implements Event{
    String eventName;
    int avTickets;
    int curTickets;
    String performer;

    public Concert(String eventName, int avTickets, String performer) {
        this.eventName = eventName;
        this.avTickets = avTickets;
        this.performer = performer;
        this.curTickets = avTickets;
    }

    @Override
    public String getEventName() {
        return this.eventName;
    }

    @Override
    public int getAvailableTickets() {
        return this.avTickets;
    }

    @Override
    public boolean bookTickets(int numberOfTickets) {
        if( numberOfTickets > curTickets ){
            System.out.println("Cannot book too many tickets.");
            return false;
        }
        curTickets-=numberOfTickets;
        System.out.println("Booking Successfull.");
        return true;
    }

    @Override
    public boolean cancelTickets(int numberOfTickets) {
        if( numberOfTickets + this.curTickets > this.avTickets ){
            System.out.println("Cannot cancel excess amount of Tickets.");
            return false;
        }
        this.curTickets += numberOfTickets;
        return true;
    }

    @Override
    public void displayInfo() {
        System.out.println("Event name : " + this.eventName);
        System.out.println("Event Performer : " + this.performer);
        System.out.println("Tickets left : " + this.curTickets);
    }

    





    

}

class TheaterPlay implements Event{
    String eventName;
    int avTickets;
    int curTickets;
    String director;

    public TheaterPlay(String eventName, int avTickets, String director) {
        this.eventName = eventName;
        this.avTickets = avTickets;
        this.director = director;
        this.curTickets = avTickets;
    }

    @Override
    public String getEventName() {
        return this.eventName;
    }

    @Override
    public int getAvailableTickets() {
        return this.avTickets;
    }

    @Override
    public boolean bookTickets(int numberOfTickets) {
        if( numberOfTickets > curTickets ){
            System.out.println("Cannot book too many tickets.");
            return false;
        }
        curTickets-=numberOfTickets;
        System.out.println("Booking Successfull.");
        return true;
    }

    @Override
    public boolean cancelTickets(int numberOfTickets) {
        if( numberOfTickets + this.curTickets > this.avTickets ){
            System.out.println("Cannot cancel excess amount of Tickets.");
            return false;
        }
        this.curTickets += numberOfTickets;
        return true;
    }

    @Override
    public void displayInfo() {
        System.out.println("Event name : " + this.eventName);
        System.out.println("Event Director : " + this.director);
        System.out.println("Tickets left : " + this.curTickets);
    }


    

}

class SportsGame implements Event{
    String eventName;
    int avTickets;
    int curTickets;
    String teamNames;

    public SportsGame(String eventName, int avTickets, String teamNames) {
        this.eventName = eventName;
        this.avTickets = avTickets;
        this.teamNames = teamNames;
        this.curTickets = avTickets;
    }

    @Override
    public String getEventName() {
        return this.eventName;
    }

    @Override
    public int getAvailableTickets() {
        return this.curTickets;
    }

    @Override
    public boolean bookTickets(int numberOfTickets) {
        if( numberOfTickets > curTickets ){
            System.out.println("Cannot book too many tickets.");
            return false;
        }
        curTickets-=numberOfTickets;
        System.out.println("Booking Successfull.");
        return true;
    }

    @Override
    public boolean cancelTickets(int numberOfTickets) {
        if( numberOfTickets + this.curTickets > this.avTickets ){
            System.out.println("Cannot cancel excess amount of Tickets.");
            return false;
        }
        this.curTickets += numberOfTickets;
        return true;
    }

    @Override
    public void displayInfo() {
        System.out.println("Event name : " + this.eventName);
        System.out.println("Event Teamnames : " + this.teamNames);
        System.out.println("Tickets left : " + this.curTickets);
    }



}

class EventManager{
    ArrayList<Event>allEvents = new ArrayList<>();

    void addEvent(Event e){
        allEvents.add(e);
    }

    void bookEventTickets(String eventName,int not){
        allEvents.forEach(event->{
            if(eventName.equals(event.getEventName())){
                event.bookTickets(not);
            }
        });
    }

    void cancelEventTickets(String eventName,int not){
        allEvents.forEach(event->{
            if(eventName.equals(event.getEventName())){
                event.cancelTickets(not);
            }
        });
    }

    void displayAllEvents(){
        allEvents.forEach(event->{
            event.displayInfo();
        });
    }

}