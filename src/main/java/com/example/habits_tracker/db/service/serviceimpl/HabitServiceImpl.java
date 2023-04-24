package com.example.habits_tracker.db.service.serviceimpl;

import com.example.habits_tracker.db.converter.HabitConverterRequest;
import com.example.habits_tracker.db.entities.Habit;
import com.example.habits_tracker.db.repository.HabitRepository;
import com.example.habits_tracker.db.service.HabitService;
import com.example.habits_tracker.dto.request.HabitRequest;
import com.example.habits_tracker.dto.response.HabitResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HabitServiceImpl implements HabitService {

    private final HabitRepository habitRepository;
    private final HabitConverterRequest habitConverterRequest;

    @Override
    public List<HabitResponse> getAll() {
        return habitRepository.getAll();
    }

    @Override
    public HabitResponse create(HabitRequest habitRequest) {
        Habit habit = habitConverterRequest.addHabit(habitRequest);
        habitRepository.save(habit);
        return new HabitResponse(habit.getId(), habit.getName(), habit.getDescription(), habit.getGoal(),
                habit.getStartDate(), habit.getEndDate());
    }

    @Override
    public HabitResponse update(Long id, HabitRequest habitRequest) {
        return null;
    }

    @Override
    public HabitResponse delete(Long id) {
        return null;
    }

}
