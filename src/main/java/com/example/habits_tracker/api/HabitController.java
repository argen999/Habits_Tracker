package com.example.habits_tracker.api;

import com.example.habits_tracker.db.service.HabitService;
import com.example.habits_tracker.dto.request.HabitRequest;
import com.example.habits_tracker.dto.response.HabitResponse;
import com.example.habits_tracker.dto.response.SimpleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habit")
@RequiredArgsConstructor
public class HabitController {

    private final HabitService habitService;

    @PostMapping("/save")
    public HabitResponse save(@RequestBody HabitRequest habitRequest) {
        return habitService.create(habitRequest);
    }

    @GetMapping()
    public List<HabitResponse> getAll() {
        return habitService.getAll();
    }
    @DeleteMapping("/delete/{id}")
    public SimpleResponse delete(@PathVariable Long id){
        return habitService.delete(id);
    }

}