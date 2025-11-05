package com.pluralsight;

public class Reservation {

    private String roomType;
    private int numberOfNights;
    private boolean isWeekend;


    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    public Reservation(){}
    //getters and setters
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }

    //derived methods
    private double getPrice() {
        return switch (roomType.toLowerCase()) {
            case "king" -> 139;
            case "double" -> 124;
            default -> 0;
        };
    }


    public double getReservationTotal(){
        double total = getPrice() * this.numberOfNights;
        if (isWeekend) {
            //If the stay is over a weekend, the price per night should increase by 10%
            total = total * 1.10;
        }
        return total;
    }


}
