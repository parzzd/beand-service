package com.hampcode.bankingservice.mapper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.hampcode.bankingservice.model.dto.PublicationRequestDTO;
import com.hampcode.bankingservice.model.dto.PublicationResponseDTO;
import com.hampcode.bankingservice.model.entities.Publication;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PublicationMapper {

    private final ModelMapper modelMapper;

    public Publication convertToEntity(PublicationRequestDTO publicationRequestDTO){
        return modelMapper.map(publicationRequestDTO, Publication.class);
    }

    public PublicationResponseDTO convertToDTO(Publication publication){
        return modelMapper.map(publication, PublicationResponseDTO.class);
    }

    public List<PublicationResponseDTO>  convertToListDTO(List<Publication> publications){
        return publications.stream()
                .map(this::convertToDTO)
                .toList();
    }

}