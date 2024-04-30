package com.hampcode.bankingservice.model.dto;

import com.hampcode.bankingservice.model.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRestrictionRequestDTO {

    private User user;
    private String restriction;

}
