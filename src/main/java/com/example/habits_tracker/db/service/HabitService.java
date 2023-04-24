package com.example.habits_tracker.db.service;

import com.example.habits_tracker.dto.request.HabitRequest;
import com.example.habits_tracker.dto.response.HabitResponse;

import java.util.List;

public interface HabitService {

    List<HabitResponse> getAll();

    HabitResponse create(HabitRequest habitRequest);

    HabitResponse update(Long id, HabitRequest habitRequest);

    HabitResponse delete(Long id);

}
