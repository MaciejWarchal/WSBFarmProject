package humans;

import management.Vacation;

public class Manager extends Employee{

    Employee workersUnderSupervision;

    public Manager(int id, String name, int phoneNumber, int age, double salaryMonthlyPLN, double earnedSienceLastPayDayPLN,
                   double workingHours, double workingDays, double overtimeHours, double hourlyRateInPLN, int workingPerWeekDays,
                   double workingHoursPerDay, Vacation vacationForAYearDays, double cash, Employee workersUnderSupervision) {
                   super(id, name, phoneNumber, age, salaryMonthlyPLN, earnedSienceLastPayDayPLN, workingHours, workingDays, overtimeHours,
                           hourlyRateInPLN, workingPerWeekDays, workingHoursPerDay, vacationForAYearDays, cash);
        this.workersUnderSupervision = workersUnderSupervision;
    }
}
