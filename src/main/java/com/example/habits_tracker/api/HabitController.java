package com.example.habits_tracker.api;

import com.example.habits_tracker.db.service.HabitService;
import com.example.habits_tracker.dto.request.HabitRequest;
import com.example.habits_tracker.dto.response.HabitResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/habit")
public class HabitController {

    private final HabitService habitService;
    @PostMapping("/save")
    public HabitResponse saveApplication(@RequestBody HabitRequest habitRequest) {
        return habitService.create(habitRequest);
    }
}