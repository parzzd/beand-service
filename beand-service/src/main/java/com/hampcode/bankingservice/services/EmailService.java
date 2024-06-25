package com.hampcode.bankingservice.services;

import com.hampcode.bankingservice.exceptions.ResourceNotFoundException;
import com.hampcode.bankingservice.model.dto.EmailRequestDTO;
import com.hampcode.bankingservice.model.dto.WeeklyReportResponseDTO;
import com.hampcode.bankingservice.model.entities.WeeklyReport;
import com.hampcode.bankingservice.repository.WeeklyReportRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;
    private final WeeklyReportRepository weeklyReportRepository;

    public void sendEmailWithReport(EmailRequestDTO requestDTO) {
        WeeklyReport report = weeklyReportRepository.findById(requestDTO.getReportId())
                .orElseThrow(() -> new ResourceNotFoundException("Report not found"));

        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(requestDTO.getText(), true);
            helper.setTo(requestDTO.getTo());
            helper.setSubject(requestDTO.getSubject());
            
            // Append report details
            helper.setText(requestDTO.getText() + "<br>" +
                "Resumen del Progreso: " + report.getProgressSummary() + "<br>" +
                "Cambio de Peso: " + report.getWeightChange() + " kg<br>" +
                "Mejora de Hábitos: " + report.getHabitsImprovement() + "<br>" +
                "Logro de Objetivos: " + report.getGoalsAchievement(), true);

            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }
}