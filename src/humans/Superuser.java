package humans;

import management.Vacation;

public class Superuser extends Employee{

    private String info;

    public Superuser(int id, String name, int phoneNumber, int age, double salaryMonthlyPLN, double earnedSienceLastPayDayPLN,
                     double workingHours, double workingDays, double overtimeHours, double hourlyRateInPLN, int workingPerWeekDays,
                     double workingHoursPerDay, Vacation vacationForAYearDays, double cash, String info) {
        super(id, name, phoneNumber, age, salaryMonthlyPLN, earnedSienceLastPayDayPLN, workingHours, workingDays, overtimeHours,
                hourlyRateInPLN, workingPerWeekDays, workingHoursPerDay, vacationForAYearDays, cash);
        this.info = info;
    }
}
