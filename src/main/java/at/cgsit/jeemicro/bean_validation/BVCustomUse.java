/*
 * Copyright (C) 2023 CGS-IT Solutions GmbH - All Rights Reserved
 */

package at.cgsit.jeemicro.bean_validation;

import at.cgsit.jeemicro.bean_validation.custom.MyCustomConstraint;

public class BVCustomUse {

    @MyCustomConstraint(validStrings = {"test", "test2"})
    String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
