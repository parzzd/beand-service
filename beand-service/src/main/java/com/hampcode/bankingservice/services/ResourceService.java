package com.hampcode.bankingservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hampcode.bankingservice.mapper.ResourceMapper;
import com.hampcode.bankingservice.model.dto.ResourceRequestDTO;
import com.hampcode.bankingservice.model.dto.ResourceResponseDTO;
import com.hampcode.bankingservice.model.entities.Resource;
import com.hampcode.bankingservice.repository.ResourceRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ResourceService {
    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;
    public List<ResourceResponseDTO> getAllResources(){
        List<Resource> resources= resourceRepository.findAll();
        return resourceMapper.convertToResourceListDTO(resources);
    }  

    public ResourceResponseDTO createResource(ResourceRequestDTO resourceRequestDTO){
        Resource resource=new Resource();
        resource.setResourceDescription(resourceRequestDTO.getResourceDescription());
        resource.setResourceName(resourceRequestDTO.getResourceName());
        resource.setPhoto(resourceRequestDTO.getPhoto());
        resource=resourceRepository.save(resource);
        return resourceMapper.convertToResourceDTO(resource);
    }
}
