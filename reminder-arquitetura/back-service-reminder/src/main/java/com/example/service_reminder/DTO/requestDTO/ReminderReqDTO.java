package com.example.service_reminder.DTO.requestDTO;

import java.time.LocalDateTime;

public class ReminderReqDTO {

    private String titleReminder;
    private String targetReminder;
    private String descriptionReminder;
    private LocalDateTime targetDate;

    // Construtores, Getters e Setters
    public ReminderReqDTO(String titleReminder, String targetReminder, String descriptionReminder, LocalDateTime targetDate) {
        this.titleReminder = titleReminder;
        this.targetReminder = targetReminder;
        this.descriptionReminder = descriptionReminder;
        this.targetDate = targetDate;
    }

    public String getTitleReminder() {
        return titleReminder;
    }

    public void setTitleReminder(String titleReminder) {
        this.titleReminder = titleReminder;
    }

    public String getTargetReminder() {
        return targetReminder;
    }

    public void setTargetReminder(String targetReminder) {
        this.targetReminder = targetReminder;
    }

    public String getDescriptionReminder() {
        return descriptionReminder;
    }

    public void setDescriptionReminder(String descriptionReminder) {
        this.descriptionReminder = descriptionReminder;
    }

    public LocalDateTime getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDateTime targetDate) {
        this.targetDate = targetDate;
    }
}
