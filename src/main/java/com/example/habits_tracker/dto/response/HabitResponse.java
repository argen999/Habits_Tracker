package com.example.habits_tracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HabitResponse {

    private Long id;

    private String name;

    private String description;

    private int goal;

    private LocalDate startDate;

    private LocalDate endDate;

}
