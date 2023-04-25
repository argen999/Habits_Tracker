package com.example.habits_tracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class HabitResponse {

    private Long id;

    private String name;

    private String description;

    private int goal;

    private LocalDate startDate;

    private LocalDate endDate;

    public HabitResponse(Long id, String name, String description, int goal, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.goal = goal;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}
