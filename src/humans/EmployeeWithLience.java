package humans;

import management.Vacation;

public class EmployeeWithLience extends Employee{
    String licence;

    public EmployeeWithLience(int id, String name, int phoneNumber, int age, double salaryMonthlyPLN, double earnedSienceLastPayDayPLN,
                              double workingHours, double workingDays, double overtimeHours, double hourlyRateInPLN,
                              int workingPerWeekDays, double workingHoursPerDay, Vacation vacationForAYearDays, double cash,
                              String licence) {
        super(id, name, phoneNumber, age, salaryMonthlyPLN, earnedSienceLastPayDayPLN, workingHours, workingDays,
                overtimeHours, hourlyRateInPLN, workingPerWeekDays, workingHoursPerDay, vacationForAYearDays, cash);
        this.licence = licence;
    }

    public String getLicence() {
        return licence;
    }
}
