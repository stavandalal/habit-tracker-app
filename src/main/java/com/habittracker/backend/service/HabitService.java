package com.habittracker.backend.service;


import com.habittracker.backend.model.Habit;
import com.habittracker.backend.repository.HabitRepository;
import org.springframework.stereotype.Service;

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
}
