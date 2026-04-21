package com.habittracker.backend.repository;

import com.habittracker.backend.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitRepository extends JpaRepository<Habit, Long> {

}
