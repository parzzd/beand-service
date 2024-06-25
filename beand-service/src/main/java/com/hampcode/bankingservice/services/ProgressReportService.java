package com.hampcode.bankingservice.services;

import com.hampcode.bankingservice.exceptions.ResourceNotFoundException;
import com.hampcode.bankingservice.mapper.ProgressReportMapper;
import com.hampcode.bankingservice.model.dto.ProgressReportRequestDTO;
import com.hampcode.bankingservice.model.dto.ProgressReportResponseDTO;
import com.hampcode.bankingservice.model.entities.ProgressReport;
import com.hampcode.bankingservice.model.entities.User;
import com.hampcode.bankingservice.repository.ProgressReportRepository;
import com.hampcode.bankingservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ProgressReportService {

    private final ProgressReportRepository progressReportRepository;
    private final UserRepository userRepository;
    private final ProgressReportMapper progressReportMapper;
    private final JavaMailSender mailSender;

    @Transactional(readOnly = true)
    public List<ProgressReportResponseDTO> getAllProgressReports(Long userId){
        User user = userRepository.findById(userId).orElseThrow(ResourceNotFoundException::new);
        List<ProgressReport> reports = progressReportRepository.findByUser(user);
        return progressReportMapper.convertToListDTO(reports);
    }

    @Transactional
    public ProgressReportResponseDTO createProgressReport(ProgressReportRequestDTO progressReportRequestDTO){
        User user = userRepository.findById(progressReportRequestDTO.getUserId()).orElseThrow(ResourceNotFoundException::new);
        ProgressReport report = progressReportMapper.convertToEntity(progressReportRequestDTO);
        report.setUser(user);
        report.setReportDate(LocalDateTime.now());
        progressReportRepository.save(report);
        sendReportByEmail(user, report);
        return progressReportMapper.convertToDto(report);
    }

    private void sendReportByEmail(User user, ProgressReport report) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Informe Semanal de Progreso");
        message.setText("Informe de progreso: \n\n" +
                "Pérdida de peso: " + report.getWeightChange() + "\n" +
                "Hábitos mejorados: " + report.getHabitsImproved() + "\n" +
                "Objetivos alcanzados: " + report.getGoalsMet());
        mailSender.send(message);
    }

    @Scheduled(cron = "0 0 0 * * SUN") // Ejecutar cada domingo a medianoche
    public void generateWeeklyReports() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            ProgressReport report = new ProgressReport();
            report.setUser(user);
            report.setReportDate(LocalDateTime.now());
            report.setWeightChange(0.0); // Lógica de cálculo real aquí
            report.setHabitsImproved("Placeholder");
            report.setGoalsMet("Placeholder");

            progressReportRepository.save(report);
            sendReportByEmail(user, report);
        }
    }
}
