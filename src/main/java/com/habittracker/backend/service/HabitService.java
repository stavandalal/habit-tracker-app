package com.habittracker.backend.service;


import com.habittracker.backend.model.Habit;
import com.habittracker.backend.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
public class HabitService {

    private final HabitRepository habitRepository;

    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    public Habit createHabit(Habit habit) {
        if (habit.getActive() == null) {
            habit.setActive(true);
        }
        return habitRepository.save(habit);
    }

    public List<Habit> getAllHabits() {
        return habitRepository.findAll();
    }

    public Habit toggleHabit(Long id) {
        Habit habit = habitRepository.findById(id).orElseThrow(()-> new ResolutionException("Habit not found"));

        habit.setActive(!habit.getActive());

        return habitRepository.save(habit);
    }
}
