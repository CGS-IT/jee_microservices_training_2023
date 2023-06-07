/*
 * Copyright (C) 2023 CGS-IT Solutions GmbH - All Rights Reserved
 */

package at.cgsit.jeemicro.bean_validation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Past;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Calendar;

public class BVTestObject2 {

    @Past
    LocalDateTime futureDate;

    BVTestObject2(){
        futureDate = LocalDateTime.now().minusDays(1);
    }

    public LocalDateTime getFutureDate() {
        return futureDate;
    }

    @AssertTrue(message = "this object is invalid because the date is not in the future")
    public boolean isValidateDate() {
        // the validation will be after the object is created
        return futureDate.isAfter(LocalDateTime.now());
    }

}
