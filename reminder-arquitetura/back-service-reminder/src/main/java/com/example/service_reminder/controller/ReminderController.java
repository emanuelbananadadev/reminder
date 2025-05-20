package com.example.service_reminder.controller;

import com.example.service_reminder.DTO.requestDTO.ReminderReqDTO;
import com.example.service_reminder.DTO.responseDTO.ReminderRespDTO;
import com.example.service_reminder.model.Reminder;
import com.example.service_reminder.service.ReminderService; // Supondo que você tenha um serviço de Reminder
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/reminders")
public class ReminderController {

    @Autowired
    private ReminderService reminderService; // Supondo que você tenha um serviço para lidar com a lógica de negócios

    @PostMapping
    public ResponseEntity<ReminderRespDTO> createReminder(@RequestBody ReminderReqDTO reminderReqDTO) {
        Reminder reminder = reminderService.createReminder(reminderReqDTO);
        ReminderRespDTO reminderRespDTO = new ReminderRespDTO(reminder.getIdReminder(), reminder.getTitleReminder(),
                reminder.getTargetReminder(), reminder.getDescriptionReminder(), reminder.getDateCreated(), reminder.getDateUpdated());
        return new ResponseEntity<>(reminderRespDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReminderRespDTO> getReminder(@PathVariable UUID id) {
        Reminder reminder = reminderService.getReminder(id);
        if (reminder != null) {
            ReminderRespDTO reminderRespDTO = new ReminderRespDTO(reminder.getIdReminder(), reminder.getTitleReminder(),
                    reminder.getTargetReminder(), reminder.getDescriptionReminder(), reminder.getDateCreated(), reminder.getDateUpdated());
            return new ResponseEntity<>(reminderRespDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<ReminderRespDTO>> getAllReminders() {
        List<Reminder> reminders = reminderService.getAllReminders();
        List<ReminderRespDTO> reminderRespDTOList = reminders.stream()
                .map(reminder -> new ReminderRespDTO(reminder.getIdReminder(), reminder.getTitleReminder(),
                        reminder.getTargetReminder(), reminder.getDescriptionReminder(), reminder.getDateCreated(), reminder.getDateUpdated()))
                .toList();
        return new ResponseEntity<>(reminderRespDTOList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReminder(@PathVariable UUID id) {
        boolean isDeleted = reminderService.deleteReminder(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
