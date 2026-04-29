package com.habittracker.backend.controller;


import com.habittracker.backend.model.Habit;
import com.habittracker.backend.model.HabitLog;
import com.habittracker.backend.service.HabitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
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

    @GetMapping
    public List<Habit> getAllHabits(){
        return habitService.getAllHabits();
    }


    @PutMapping("{id}/toggle")
    public Habit toggltHabit(@PathVariable Long id){
        return habitService.toggleHabit(id);
    }

    @PostMapping("/{id}/complete")
    public HabitLog completeHabit(@PathVariable Long id) {
        return habitService.completeToday(id);
    }
    
    @DeleteMapping("/{id}")
    public void deleteHabit(@PathVariable Long id) {
        habitService.deleteHabit(id);
    }
}
