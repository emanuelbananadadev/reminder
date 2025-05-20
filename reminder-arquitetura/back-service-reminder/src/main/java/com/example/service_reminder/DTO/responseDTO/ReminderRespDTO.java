package com.example.service_reminder.DTO.responseDTO;

import java.time.LocalDateTime;
import java.util.UUID;

public class ReminderRespDTO {

    private UUID idReminder;
    private String titleReminder;
    private String targetReminder;
    private String descriptionReminder;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    // Construtores, Getters e Setters
    public ReminderRespDTO(UUID idReminder, String titleReminder, String targetReminder, String descriptionReminder,
                           LocalDateTime dateCreated, LocalDateTime dateUpdated) {
        this.idReminder = idReminder;
        this.titleReminder = titleReminder;
        this.targetReminder = targetReminder;
        this.descriptionReminder = descriptionReminder;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public UUID getIdReminder() {
        return idReminder;
    }

    public void setIdReminder(UUID idReminder) {
        this.idReminder = idReminder;
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

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
