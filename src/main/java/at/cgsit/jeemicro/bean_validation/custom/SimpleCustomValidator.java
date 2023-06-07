/*
 * Copyright (C) 2023 CGS-IT Solutions GmbH - All Rights Reserved
 */

package at.cgsit.jeemicro.bean_validation.custom;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SimpleCustomValidator implements ConstraintValidator<MyCustomConstraint, String> {
    String[] stringsToUse = null;

    @Override
    public void initialize(MyCustomConstraint constraintAnnotation) {
        stringsToUse = constraintAnnotation.validStrings();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return validate(value); // shown in next slide
    }

    private boolean validate(String dateString) {
        boolean valid = false;
        if (dateString.length() == 0){
            return true;
        }
        for (String stringToUse : stringsToUse) {
            if (dateString.contains(stringToUse)) {
                valid = true;
                break;
            }
        }
        return valid;
    }

}