package com.example.nordicmotorhomerental.Model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.*;

class ContractTest {
    MotorHome motorHome = new MotorHome(1, "Mercedes",
            "HYMER B-Klasse MasterLine", 0, "4-5", 40);
    double ppd = motorHome.getPricePerDay();
    @Test
    void getTotalPrice(double ppd) {

        LocalDate startDay = LocalDate.of(2021,05,30);
        LocalDate endDay = LocalDate.of(2021,06,06);
        Period period = Period.between(startDay, endDay);

        // værdien 40 er pricePerDay fra motorhome
        ppd = 40;
        //1.60 er de 60% forøget værdi for en kontrakt inden for peak sæsonen
        double total = (ppd * 1.60) * period.getDays();
        //vi forventer at resultatet bliver 224, da (40 * 1.60) * 7 = 224

        assertEquals(224,total);
    }
}