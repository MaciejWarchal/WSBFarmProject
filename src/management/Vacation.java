package management;
import java.time.LocalDate;

import java.time.LocalDate;
import java.time.Period;

public class Vacation {

    private LocalDate beginVcation;
    private LocalDate endVacation;
    private Period DurationDays;

    public Vacation(LocalDate beginVcation, LocalDate endVacation) {
        this.beginVcation = beginVcation;
        this.endVacation = endVacation;
        this.DurationDays= Period.between(beginVcation, endVacation);
    }




}
