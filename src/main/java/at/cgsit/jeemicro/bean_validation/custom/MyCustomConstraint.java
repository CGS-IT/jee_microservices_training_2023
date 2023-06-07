/*
 * Copyright (C) 2023 CGS-IT Solutions GmbH - All Rights Reserved
 */

package at.cgsit.jeemicro.bean_validation.custom;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = SimpleCustomValidator.class)
public @interface MyCustomConstraint {
    //required
    String message() default "this is the default message for a validation error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    //optional
    String[] validStrings();
}
