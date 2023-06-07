/*
 * Copyright (C) 2023 CGS-IT Solutions GmbH - All Rights Reserved
 *
 */

package at.cgsit.jeemicro.bean_validation;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 *  @Author CGS-IT Solutions @2022
 */
public class BVTestObject {

    @NotEmpty(message = "name may not be empty")
    @Pattern(regexp = "[a-zA-Z0-9]*", message = "name must be alphanumeric")
    private String name;

    @NotNull
    private String description;

    @Future
    private Calendar futureDate;

    @Email
    private String email;

    @Min(0)
    @Max(100)
    private int percent;

    @PositiveOrZero
    @Digits(integer = 5, fraction = 2) // 5 digits in total, 2 after the decimal point
    private BigDecimal amount;

    @AssertTrue(message = "this chat message is not allowed. because of user name")
    public boolean isChatMessageAllowed() {
        if("chris".equalsIgnoreCase(this.name)) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getFutureDate() {
        return futureDate;
    }

    public void setFutureDate(Calendar futureDate) {
        this.futureDate = futureDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BVTestObject{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", futureDate=" + futureDate +
                ", email='" + email + '\'' +
                ", percent=" + percent +
                ", amount=" + amount +
                '}';
    }
}
