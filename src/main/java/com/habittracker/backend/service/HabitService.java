package com.habittracker.backend.service;
import com.habittracker.backend.dto.HabitResponse;


import com.habittracker.backend.model.Habit;
import com.habittracker.backend.model.HabitLog;
import com.habittracker.backend.repository.HabitLogRepository;
import com.habittracker.backend.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.time.LocalDate;
import java.util.List;

@Service
public class HabitService {

    private final HabitRepository habitRepository;
    private final HabitLogRepository habitLogRepository;

    public HabitService(HabitRepository habitRepository,
                        HabitLogRepository habitLogRepository) {
        this.habitRepository = habitRepository;
        this.habitLogRepository = habitLogRepository;
    }

    public Habit createHabit(Habit habit) {
        return habitRepository.save(habit);
    }

    public List<HabitResponse> getAllHabits() {
        return habitRepository.findAll().stream()
                .map(habit -> new HabitResponse(
                        habit.getId(),
                        habit.getName(),
                        habit.getDescription(),
                        habit.getFrequency().name(),
                        isCompletedToday(habit.getId()),
                        calculateStreak(habit.getId())
                ))
                .toList();
    }

    public HabitLog completeToday(Long habitId) {
        LocalDate today = LocalDate.now();

        Habit habit = habitRepository.findById(habitId)
                .orElseThrow(() -> new RuntimeException("Habit not found"));

        HabitLog log = habitLogRepository
                .findByHabitIdAndDate(habitId, today)
                .orElse(new HabitLog());

        log.setHabit(habit);
        log.setDate(today);
        log.setCompleted(true);

        return habitLogRepository.save(log);
    }

    public void deleteHabit(Long id) {
        Habit habit = habitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habit not found"));

        habitLogRepository.deleteAll(
                habitLogRepository.findAll().stream()
                        .filter(log -> log.getHabit().getId().equals(id))
                        .toList()
        );

        habitRepository.delete(habit);
    }

    public boolean isCompletedToday(Long habitId) {
        return habitLogRepository.existsByHabitIdAndDate(
                habitId,
                LocalDate.now()
        );
    }

    public int calculateStreak(Long habitId){
        List<HabitLog> logs = habitLogRepository.findAll().stream()
                .filter(log -> log.getHabit().getId().equals(habitId))
                .filter(HabitLog::isCompleted)
                .sorted((a, b) -> b.getDate().compareTo(a.getDate()))
                .toList();

        int streak = 0;
        LocalDate today = LocalDate.now();

        for (HabitLog log : logs){
            if(log.getDate().equals(today.minusDays(streak))){
                streak++;
            }else{
                break;
            }
        }
        return streak;
    }


}
