package com.hampcode.bankingservice.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hampcode.bankingservice.mapper.PublicationMapper;
import com.hampcode.bankingservice.model.dto.PublicationRequestDTO;
import com.hampcode.bankingservice.model.dto.PublicationResponseDTO;
import com.hampcode.bankingservice.model.entities.Notification;
import com.hampcode.bankingservice.model.entities.Publication;
import com.hampcode.bankingservice.model.entities.User;
import com.hampcode.bankingservice.repository.NotificationRepository;
import com.hampcode.bankingservice.repository.PublicationRepository;
import com.hampcode.bankingservice.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PublicationService {

    private final PublicationRepository publicationRepository;
    private final PublicationMapper publicationMapper;

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;


    @Transactional
    public PublicationResponseDTO createPublication(PublicationRequestDTO publicationRequestDTO){
        Publication publication = publicationMapper.convertToEntity(publicationRequestDTO);
        publicationRepository.save(publication);


        Notification notification = new Notification();
        notification.setNotificationDescription("Nueva publicación creada: " + publication.getPublicationTitle());
        notification.setSourcePublication(publication);
        notificationRepository.save(notification);


        List<User> users = userRepository.findAll();


        for (User user : users) {
            user.setCantNotifications(user.getCantNotifications() + 1);
        }

        // Guardar todos los usuarios actualizados
        userRepository.saveAll(users);

        return publicationMapper.convertToDTO(publication);
    }

}
