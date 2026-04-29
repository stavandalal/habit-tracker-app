package com.habittracker.backend.controller;


import com.habittracker.backend.dto.HabitResponse;
import com.habittracker.backend.model.Habit;
import com.habittracker.backend.model.HabitLog;
import com.habittracker.backend.service.HabitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habits")
public class HabitController {
    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @PostMapping
    public Habit createHabit(@RequestBody Habit habit){
        return habitService.createHabit(habit);
    }


    @PostMapping("/{id}/complete")
    public HabitLog completeHabit(@PathVariable Long id) {
        return habitService.completeToday(id);
    }

    @DeleteMapping("/{id}")
    public void deleteHabit(@PathVariable Long id) {
        habitService.deleteHabit(id);
    }

    @GetMapping
    public List<HabitResponse> getAllHabits() {
        return habitService.getAllHabits();
    }
}
