package com.hampcode.bankingservice.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hampcode.bankingservice.model.dto.ResourceRequestDTO;
import com.hampcode.bankingservice.model.dto.ResourceResponseDTO;
import com.hampcode.bankingservice.services.ResourceService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/resources")
@AllArgsConstructor
public class ResourceController {
    private final ResourceService resourceService;
    @GetMapping
    public ResponseEntity<List<ResourceResponseDTO>> getAllResourcers(){
        List<ResourceResponseDTO> resourcers=resourceService.getAllResources();
        return new ResponseEntity<>(resourcers,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ResourceResponseDTO> createRecipe(@RequestBody @Validated ResourceRequestDTO resourceRequestDTO){
        ResourceResponseDTO createresource=resourceService.createResource(resourceRequestDTO);
        return new ResponseEntity<>(createresource,HttpStatus.CREATED);
    }


}
