package com.tekshia.springhealth.Helpers;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Calculate {

    public static int getAge(LocalDate birthDate, LocalDate currentDate){
        if ((birthDate != null) && (currentDate != null)){
            return Period.between(birthDate, currentDate).getYears();
        }else{
            return 0;
        }
    }
}
