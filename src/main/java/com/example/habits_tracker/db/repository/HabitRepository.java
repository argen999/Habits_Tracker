package com.example.habits_tracker.db.repository;

import com.example.habits_tracker.db.entities.Habit;
import com.example.habits_tracker.dto.response.HabitResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Long> {

    @Query("select new com.example.habits_tracker.dto.response.HabitResponse" +
            "(h.id, h.name, h.description, h.goal, h.startDate, h.endDate) from Habit h")
    List<HabitResponse> getAll();

}