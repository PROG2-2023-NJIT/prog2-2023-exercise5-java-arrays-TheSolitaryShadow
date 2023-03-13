package prog2.exercise5.flight.booking.system;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class FlightBooking {
    private String flightCompany;
    private String flightID;
    private String[] passengerFullName=new String[100];
    private TripSource tripSource;
    private SourceAirport sourceAirport;
    private TripDestination tripDestination;
    private DestinationAirport destinationAirport;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private int childPassengers;
    private int adultPassengers;
    private int totalPassengers;
    private double departingTicketPrice;
    private double returnTicketPrice;
    private double totalTicketPrice;
    private String[] ticketNumber=new String[100];
    private BookingClass bookingClass;
    private TripType tripType;
    private boolean sourceInChina;
    private boolean destinationInChina;
    private boolean flag=true;
    private LocalDate beforeReturnDate;
    private int size;
    private String[] passengerGender=new String[100];
    private int[] passengerAge=new int[100];




    public enum BookingClass{
        FIRST,BUSINESS,ECONOMY;
    }

    public enum TripType{
        ONE_WAY,RETURN;
    }

    public enum TripSource{
        NANJING,BEIJING,SHANGHAI,OULU,HELSINKI,PARIS;
    }

    public enum TripDestination{
        NANJING,BEIJING,SHANGHAI,OULU,HELSINKI,PARIS;
    }

    public enum SourceAirport{
        Nanjing_Lukou_International_Airport,Beijing_Capital_International_Airport,Shanghai_Pudong_International_Airport,Oulu_Airport,Helsinki_Airport,Paris_Charles_de_Gaulle_Airport;
    }

    public enum DestinationAirport{
        Nanjing_Lukou_International_Airport,Beijing_Capital_International_Airport,Shanghai_Pudong_International_Airport,Oulu_Airport,Helsinki_Airport,Paris_Charles_de_Gaulle_Airport;
    }




    public FlightBooking(String passengerFullName,LocalDate departureDate,LocalDate returnDate,int childPassengers,int adultPassengers){
        this.departureDate=departureDate;
        this.returnDate=returnDate;
        this.childPassengers=childPassengers;
        this.adultPassengers=adultPassengers;
    }

    public FlightBooking(int size){
        this.size=size;
    }

    public void setPassengerFullName(int size, String passengerFullName){
        this.passengerFullName[size]=passengerFullName;
    }

    public void setPassengerGender(int size, String passengerGender){
        this.passengerGender[size]=passengerGender;
    }

    public void setPassengerAge(int size, int passengerAge){
        this.passengerAge[size]=passengerAge;
    }

    public void setSourceAirport(SourceAirport sourceAirport){
        this.sourceAirport=sourceAirport;
    }

    public void setDestinationAirport(DestinationAirport destinationAirport){
        this.destinationAirport=destinationAirport;
    }



    public void setFlightCompany(String flightCompany){
        this.flightCompany=flightCompany;
    }

    public void setDepartureDate(LocalDate departureDate){
        this.departureDate=departureDate;
    }

    public void setReturnDate(LocalDate returnDate){
        long day=ChronoUnit.DAYS.between(departureDate, returnDate);
        if(day<2){
            flag=false;
            beforeReturnDate=returnDate;
            day=2;
            returnDate=departureDate.plusDays(day);
        }
        this.returnDate=returnDate;
    }

    public void setTotalPassengers(int childPassengers,int adultPassengers){
        totalPassengers=childPassengers+adultPassengers;
    }


    public String getFlightCompany(){
        return flightCompany;
    }

    public TripSource getTripSource(){
        return tripSource;
    }

    public LocalDate getDepartureDate(){
        return departureDate;
     }

    public LocalDate getReturnDate(){
        return returnDate;
     }

    public double getTotalTicketPrice(){
        return totalTicketPrice;
    }

    public double getDepartingTicketPrice(){
        return departingTicketPrice;
    }

    public double getReturnTicketPrice(){
        return returnTicketPrice;
    }

    public int getChildPassengers(){
        return childPassengers;
    }

    public int getAdultPassengers(){
        return adultPassengers;
    }
    public String getTicketNumber(int size){
        return ticketNumber[size];
    }


    public int getTotalPassengers(){
        return totalPassengers;
    }

    public BookingClass getBookingClass(){
        return bookingClass;
    }

    public TripType getTripType() {
        return tripType;
    }

    public TripDestination getTripDestination(){
        return tripDestination;
    }

    public SourceAirport getSourceAirport(){
        return sourceAirport;
    }

    public DestinationAirport getDestinationAirport(){
        return destinationAirport;
    }

    public String getPassengerFullName(int size){
        return passengerFullName[size];
    }

    public String getPassengerGender(int size){
        return passengerGender[size];
    }

    public int getPassengerAge(int size){
        return passengerAge[size];
    }


    public String toString(){
        if(flag==true){
            return "Thank you for booking your flight with "+flightCompany+".\n"+
            "You reserved a total of "+size+" tickets."+"\n"+
            "Ticket Number: "+ticketNumber+ "\n" + 
            "Passenger Name: "+passengerFullName+"\n" + 
            "From "+tripSource+" to "+tripDestination+ "\n" + 
            "Date of departure: "+ departureDate + "\n" + 
            "Date of return: "+ returnDate + "\n" + 
            "Total passengers: "+totalPassengers+ "\n" + 
            "Total ticket price in Euros: "+totalTicketPrice; 
        }
        else{
            return "Thank you for booking your flight with "+flightCompany+".\n"+
            "You reserved a total of "+size+" tickets."+"\n"+
            "Ticket Number: "+ticketNumber+ "\n" + 
            "Passenger Name: "+passengerFullName+"\n" + 
            "From "+tripSource+" to "+tripDestination+ "\n" + 
            "Date of departure: "+ departureDate + "\n" + 
            "Date of return: "+ returnDate +" (Changed from "+beforeReturnDate+" to "+returnDate+")"+ "\n" + 
            "Total passengers: "+totalPassengers+ "\n" + 
            "Total ticket price in Euros: "+totalTicketPrice+ "\n" + 
            "IMPORTANT NOTICE: As per our policy, the return date was changed because it was less than two days apart from your departure date.";
        }
    }

    
    public void setBookingClass(String bookingClass){
        switch(bookingClass){
            case "1":
            this.bookingClass= BookingClass.FIRST;
            break;
            case "2":
            this.bookingClass= BookingClass.BUSINESS;
            break;
            case "3":
            this.bookingClass= BookingClass.ECONOMY;
            break;
            default:
        }
    }

    public void setTripType(String tripType){
        switch(tripType){
            case "1":
            this.tripType= TripType.ONE_WAY;
            break;
            case "2":
            this.tripType= TripType.RETURN;
            break;
            default:
        }
    }

    public void setTripSource(String tripSource){
        switch(tripSource){
            case "1":
            this.tripSource=TripSource.NANJING;
            break;
            case "2":
            this.tripSource=TripSource.BEIJING;
            break;
            case "3":
            this.tripSource=TripSource.OULU;
            break;
            case "4":
            this.tripSource=TripSource.HELSINKI;
            break;
            default:
        }
    }

    public void setSourceAirport(String sourceAirport){
        switch(sourceAirport){
            case "1":
            this.sourceAirport=SourceAirport.Nanjing_Lukou_International_Airport;
            break;
            case "2":
            this.sourceAirport=SourceAirport.Beijing_Capital_International_Airport;
            break;
            case "3":
            this.sourceAirport=SourceAirport.Oulu_Airport;
            break;
            case "4":
            this.sourceAirport=SourceAirport.Helsinki_Airport;
            break;
            default:
        }
    }
    public void setTripDestination(String tripSource, String tripDestination){
        switch(tripSource){
            case "1":
            this.tripSource=TripSource.NANJING;
            this.sourceAirport=SourceAirport.Nanjing_Lukou_International_Airport;
            break;
            case "2":
            this.tripSource=TripSource.BEIJING;
            this.sourceAirport=SourceAirport.Beijing_Capital_International_Airport;
            break;
            case "3":
            this.tripSource=TripSource.OULU;
            this.sourceAirport=SourceAirport.Oulu_Airport;
            break;
            case "4":
            this.tripSource=TripSource.HELSINKI;
            this.sourceAirport=SourceAirport.Helsinki_Airport;
            break;
            default:
        }

        switch(tripDestination){
            case "1":
            this.tripDestination=TripDestination.NANJING;
            this.destinationAirport=DestinationAirport.Nanjing_Lukou_International_Airport;
            break;
            case "2":
            this.tripDestination=TripDestination.BEIJING;
            this.destinationAirport=DestinationAirport.Beijing_Capital_International_Airport;
            break;
            case "3":
            this.tripDestination=TripDestination.OULU;
            this.destinationAirport=DestinationAirport.Oulu_Airport;
            break;
            case "4":
            this.tripDestination=TripDestination.HELSINKI;
            this.destinationAirport=DestinationAirport.Helsinki_Airport;
            break;
            default:
        }
    }

    public void setDestinationAirport(String sourceAirport, String destinationAirport){
        switch(sourceAirport){
            case "1":
            this.sourceAirport=SourceAirport.Nanjing_Lukou_International_Airport;
            break;
            case "2":
            this.sourceAirport=SourceAirport.Beijing_Capital_International_Airport;
            break;
            case "3":
            this.sourceAirport=SourceAirport.Oulu_Airport;
            break;
            case "4":
            this.sourceAirport=SourceAirport.Helsinki_Airport;
            break;
            default:
        }

        switch(destinationAirport){
            case "1":
            this.destinationAirport=DestinationAirport.Nanjing_Lukou_International_Airport;
            break;
            case "2":
            this.destinationAirport=DestinationAirport.Beijing_Capital_International_Airport;
            break;
            case "3":
            this.destinationAirport=DestinationAirport.Oulu_Airport;
            break;
            case "4":
            this.destinationAirport=DestinationAirport.Helsinki_Airport;
            break;
            default:
        }
    }


    public void setTicketNumber(int size){
        ticketNumber[size]="";

        if(tripType==TripType.ONE_WAY){
            ticketNumber[size]+="11";
        }
        else if (tripType==TripType.RETURN){
            ticketNumber[size]+="22";
        }


        if(bookingClass==BookingClass.FIRST){
            ticketNumber[size]+="F";
        }
        else if(bookingClass==BookingClass.BUSINESS){
            ticketNumber[size]+="B";
        }
        else if(bookingClass==BookingClass.ECONOMY){
            ticketNumber[size]+="E";
        }


        for(int i=0;i<4;i++){
            int chars=(int)'A';
            chars+=(int)(Math.random()*26);
            ticketNumber[size]+=(char)chars;
        }



        if(tripSource==TripSource.NANJING||tripSource==TripSource.BEIJING){
            sourceInChina=true;
        }
        else if(tripSource==TripSource.HELSINKI||tripSource==TripSource.OULU){
            sourceInChina=false;
        }
        if(tripDestination==TripDestination.NANJING||tripDestination==TripDestination.BEIJING){
            destinationInChina=true;
        }
        else if(tripDestination==TripDestination.HELSINKI||tripDestination==TripDestination.OULU){
            destinationInChina=false;
        }
        if(sourceInChina==destinationInChina){
            ticketNumber[size]+="DOM";
        }
        else{
            ticketNumber[size]+="INT";
        }

    }

    public void setDepartingTicketPrice(int child,int adults){
        totalPassengers=child+adults;

        if(tripSource==TripSource.NANJING||tripSource==TripSource.BEIJING){
            sourceInChina=true;
        }
        else if(tripSource==TripSource.HELSINKI||tripSource==TripSource.OULU){
            sourceInChina=false;
        }
        if(tripDestination==TripDestination.NANJING||tripDestination==TripDestination.BEIJING){
            destinationInChina=true;
        }
        else if(tripDestination==TripDestination.HELSINKI||tripDestination==TripDestination.OULU){
            destinationInChina=false;
        }
        if(sourceInChina==destinationInChina){
            ticketNumber[size]+="DOM";
        }
        else{
            ticketNumber[size]+="INT";
        }

        if(sourceInChina==destinationInChina){
            departingTicketPrice=(300+(300*0.1)+(300*0.05))*totalPassengers;
        }
        else{
            departingTicketPrice=(300+(300*0.15)+(300*0.1))*totalPassengers;
        }

        if(bookingClass==BookingClass.FIRST){
            departingTicketPrice+=250*totalPassengers;
        }
        else if(bookingClass==BookingClass.BUSINESS){
            departingTicketPrice+=150*totalPassengers;
        }
        else if(bookingClass==BookingClass.ECONOMY){
            departingTicketPrice+=50*totalPassengers;
        }
    }

    public void setReturnTicketPrice(){
        returnTicketPrice=departingTicketPrice;
    }

    public void setTotalTicketPrice(){
        totalTicketPrice=departingTicketPrice+returnTicketPrice;
    }


}

