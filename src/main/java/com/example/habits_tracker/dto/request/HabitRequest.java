package com.example.habits_tracker.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HabitRequest {
    private String name;
    private String description;
    private Integer goal;
    private LocalDate startDate;
    private LocalDate endDate;
}
