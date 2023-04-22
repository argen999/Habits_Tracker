package com.example.habits_tracker.db.entities.enums;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public enum ExecutionFrequency {

    DAILY,

    WEEKLY,

    MONTHLY;

    @Enumerated(EnumType.STRING)
    private Days days;

    private int weeks;

    @Enumerated(EnumType.STRING)
    private Months months;

    ExecutionFrequency(Days days) {
        this.days = days;
    }

    ExecutionFrequency(int weeks) {
        this.weeks = weeks;
    }

    ExecutionFrequency(Months months) {
        this.months = months;
    }

    ExecutionFrequency() {

    }

}
