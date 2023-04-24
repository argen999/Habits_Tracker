package com.example.habits_tracker.db.service;

import com.example.habits_tracker.dto.request.HabitRequest;
import com.example.habits_tracker.dto.response.HabitResponse;
import com.example.habits_tracker.dto.response.SimpleResponse;

import java.util.List;

public interface HabitService {

    List<HabitResponse> getAll();

    HabitResponse create(HabitRequest habitRequest);


    SimpleResponse delete(Long id);

}
