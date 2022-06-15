package humans;

import management.Vacation;

import java.time.Period;

public class Employee extends Human {
    private double salaryMonthlyPLN;
    private double earnedSienceLastPayDayPLN;
    private double workingHours;
    private double workingDays;
    private double overtimeHours;
    private double hourlyRateInPLN;
    private int workingPerWeekDays;
    private double workingHoursPerDay;
    private Vacation vacationForAYearDays;    // Created additional class Vacation in managment package.

    private double cash;

    public Employee(int id, String name, int phoneNumber, int age, double salaryMonthlyPLN, double earnedSienceLastPayDayPLN, double workingHours, double workingDays, double overtimeHours, double hourlyRateInPLN, int workingPerWeekDays, double workingHoursPerDay, Vacation vacationForAYearDays, double cash) {
        super(id, name, phoneNumber, age);
        this.salaryMonthlyPLN = salaryMonthlyPLN;
        this.earnedSienceLastPayDayPLN = earnedSienceLastPayDayPLN;
        this.workingHours = workingHours;
        this.workingDays = workingDays;
        this.overtimeHours = overtimeHours;
        this.hourlyRateInPLN = hourlyRateInPLN;
        this.workingPerWeekDays = workingPerWeekDays;
        this.workingHoursPerDay = workingHoursPerDay;
        this.vacationForAYearDays = vacationForAYearDays;
        this.cash = cash;
    }

    public Employee(int id, String name, int phoneNumber, String age) {
        super(id, name, phoneNumber, Integer.parseInt(age));
    }


    public double getWorkingHours() {
        return workingHours;
    }
    public double getCash() {
        return cash;
    }
}
