package com.hampcode.bankingservice.mapper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.hampcode.bankingservice.model.dto.ResourceRequestDTO;
import com.hampcode.bankingservice.model.dto.ResourceResponseDTO;
import com.hampcode.bankingservice.model.entities.Resource;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ResourceMapper {
    private final ModelMapper modelMapper;
    
    public Resource convertToEntity(ResourceRequestDTO resourceRequestDTO){
        return modelMapper.map(resourceRequestDTO, Resource.class);
    }
    public ResourceResponseDTO convertToResourceDTO(Resource resource){
        return modelMapper.map(resource, ResourceResponseDTO.class);
    }
    public List<ResourceResponseDTO> convertToResourceListDTO(List<Resource> resources){
        return resources.stream().map(this::convertToResourceDTO).toList();
    }
}
