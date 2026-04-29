package com.habittracker.backend.dto;


public record HabitResponse(
        Long id,
        String name,
        String description,
        String frequency,
        boolean completedToday
) {}