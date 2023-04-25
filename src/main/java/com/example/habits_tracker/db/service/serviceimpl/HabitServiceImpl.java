package com.example.habits_tracker.db.service.serviceimpl;

import com.example.habits_tracker.db.converter.HabitConverterRequest;
import com.example.habits_tracker.db.entities.Habit;
import com.example.habits_tracker.db.entities.User;
import com.example.habits_tracker.db.repository.HabitRepository;
import com.example.habits_tracker.db.repository.UserRepository;
import com.example.habits_tracker.db.service.HabitService;
import com.example.habits_tracker.dto.request.HabitRequest;
import com.example.habits_tracker.dto.response.HabitResponse;
import com.example.habits_tracker.dto.response.SimpleResponse;
import com.example.habits_tracker.exceptions.BadRequestException;
import com.example.habits_tracker.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HabitServiceImpl implements HabitService {

    private final HabitRepository habitRepository;

    private final HabitConverterRequest habitConverterRequest;

    private final UserRepository userRepository;

    private User getUserAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();
        return userRepository.findByEmail(login).orElseThrow(
                () -> new NotFoundException(String.format("User with email: %s not found!", login))
        );
    }

    @Override
    public List<HabitResponse> getAll() {
        return habitRepository.getAll();
    }

    @Override
    public HabitResponse create(HabitRequest habitRequest) {
        Habit habit = habitConverterRequest.addHabit(habitRequest);
        User user = getUserAuthentication();
        habit.setUser(user);
        user.addHabit(habit);
        habitRepository.save(habit);
        return new HabitResponse(habit.getId(), habit.getName(), habit.getDescription(), habit.getGoal(),
                habit.getStartDate(), habit.getEndDate());
    }

    @Override
    public HabitResponse update(Long id, HabitRequest habitRequest) {
        Habit habit = habitRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Habit with id: %d not found!", id))
        );

        habit.setName(habitRequest.getName());
        habit.setDescription(habit.getDescription());
        habit.setGoal(habitRequest.getGoal());

        if (habitRequest.getStartDate().isBefore(habitRequest.getEndDate())) {
            habit.setStartDate(habitRequest.getStartDate());
            habit.setEndDate(habitRequest.getEndDate());
        } else {
            throw new BadRequestException("The start of the date cannot be after the end of the date!");
        }

        habitRepository.save(habit);

        return habitRepository.convertForUpdateMethod(id);
    }

    @Override
    public String delete(Long id) {
        Habit habit = habitRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Habit with id: %d not found!", id))
        );
        habitRepository.delete(habit);
        SimpleResponse simpleResponse = new SimpleResponse(String.format("Habit with id: %d deleted successfully!", id));
        return simpleResponse.getMessage();
    }

}
