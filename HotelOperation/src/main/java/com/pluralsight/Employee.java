package com.pluralsight;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    private double REGULAR_HOURS = 40;
    private final double OVERTIME_PAY_RATE = 1.15;

    private double workStartTime;


    public double getTotalPay() {
        return (getRegularHours() * payRate) + (getOvertimeHours() * OVERTIME_PAY_RATE);
    }



    public double getRegularHours() {
        return Math.min(hoursWorked, REGULAR_HOURS);
    }

    public double getOvertimeHours() {
       return  hoursWorked-getRegularHours();
    }

    public void punchIn(double time){
        workStartTime=time;
    }

    public void punchOut(double time){
        hoursWorked+= time-workStartTime;
    }

    public void punchTimeCard(double startTime, double endTime){
        hoursWorked+= endTime-startTime;
    }


}
