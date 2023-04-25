package com.example.habits_tracker.api;

import com.example.habits_tracker.db.service.HabitService;
import com.example.habits_tracker.dto.request.HabitRequest;
import com.example.habits_tracker.dto.response.HabitResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/habit")
public class HabitController {

    private final HabitService habitService;

    @GetMapping("/")
    public List<HabitResponse> getAll() {
        return habitService.getAll();
    }

    @PostMapping("/")
    public HabitResponse save(@RequestBody HabitRequest habitRequest) {
        return habitService.create(habitRequest);
    }

    @PutMapping("/{id}")
    public HabitResponse update(@PathVariable Long id, @RequestBody HabitRequest habitRequest) {
        return habitService.update(id, habitRequest);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return habitService.delete(id);
    }

}