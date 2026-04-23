package com.habittracker.backend.controller;


import com.habittracker.backend.model.Habit;
import com.habittracker.backend.service.HabitService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
