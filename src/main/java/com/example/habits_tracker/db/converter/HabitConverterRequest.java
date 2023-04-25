package com.example.habits_tracker.db.converter;

import com.example.habits_tracker.db.entities.Habit;
import com.example.habits_tracker.dto.request.HabitRequest;
import com.example.habits_tracker.exceptions.BadRequestException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class HabitConverterRequest {
    public Habit addHabit(HabitRequest habitRequest) {

        if (habitRequest == null) {
            return null;
        }
        Habit habit = new Habit();
        habit.setName(habitRequest.getName());
        habit.setDescription(habitRequest.getDescription());
        habit.setGoal(habitRequest.getGoal());
        if (habitRequest.getStartDate().isBefore(habitRequest.getEndDate())) {
            habit.setStartDate(habitRequest.getStartDate());
            habit.setEndDate(habitRequest.getEndDate());
        } else {
            throw new BadRequestException("The start of the date cannot be after the end of the date!");
        }
        return habit;
    }

    @Transactional
    public Habit update(HabitRequest habitRequest, Habit habit) {
        if (habitRequest == null) {
            return null;
        }
        if (habitRequest.getName() != null) {
            habit.setName(habitRequest.getName());
        }
        if (habitRequest.getDescription() != null) {
            habit.setDescription(habitRequest.getDescription());
        }
        if (habitRequest.getGoal() != null) {
            habit.setGoal(habitRequest.getGoal());
        }
        if (habitRequest.getStartDate().isBefore(habitRequest.getEndDate())) {
            if (habitRequest.getStartDate() != null) {
                habit.setStartDate(habitRequest.getStartDate());
            }
            if (habitRequest.getEndDate() != null) {
                habit.setEndDate(habitRequest.getEndDate());
            }
        } else {
            throw new BadRequestException("The start of the date cannot be after the end of the date!");
        }
        return habit;
    }

}
