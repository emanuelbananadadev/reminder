package com.example.service_reminder.service;

import com.example.service_reminder.DTO.requestDTO.ReminderReqDTO;
import com.example.service_reminder.DTO.responseDTO.ReminderRespDTO;
import com.example.service_reminder.model.Reminder;
import com.example.service_reminder.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;

    // Criar lembrete
    public Reminder createReminder(ReminderReqDTO reminderReqDTO) {
        // Transformar o DTO em uma entidade Reminder
        Reminder reminder = new Reminder(
                null, // O ID será gerado automaticamente
                UUID.randomUUID(), // Ou use um UUID para o id do usuário, caso o serviço já tenha um
                LocalDateTime.now(), // Data de criação
                LocalDateTime.now(), // Data de atualização
                reminderReqDTO.getTargetReminder(),
                reminderReqDTO.getTitleReminder(),
                reminderReqDTO.getDescriptionReminder()
        );
        // Salvar o lembrete no banco de dados
        return reminderRepository.save(reminder);
    }

    // Obter lembrete por ID
    public Reminder getReminder(UUID idReminder) {
        Optional<Reminder> reminder = reminderRepository.findByIdReminder(idReminder);
        return reminder.orElse(null); // Retorna null se não encontrar
    }

    // Listar todos os lembretes
    public List<Reminder> getAllReminders() {
        return reminderRepository.findAll();
    }

    // Deletar lembrete por ID
    public boolean deleteReminder(UUID idReminder) {
        if (reminderRepository.existsById(idReminder)) {
            reminderRepository.deleteByIdReminder(idReminder);
            return true;
        }
        return false; // Retorna falso se não encontrar
    }

    // Transformar Reminder em ReminderRespDTO
    public ReminderRespDTO convertToRespDTO(Reminder reminder) {
        return new ReminderRespDTO(
                reminder.getIdReminder(),
                reminder.getTitleReminder(),
                reminder.getTargetReminder(),
                reminder.getDescriptionReminder(),
                reminder.getDateCreated(),
                reminder.getDateUpdated()
        );
    }

    // Obter todos os lembretes e retornar como DTO
    public List<ReminderRespDTO> getAllRemindersAsDTO() {
        List<Reminder> reminders = reminderRepository.findAll();
        return reminders.stream()
                .map(this::convertToRespDTO)
                .collect(Collectors.toList());
    }
}
