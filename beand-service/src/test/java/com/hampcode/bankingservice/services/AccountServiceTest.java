package com.hampcode.bankingservice.services;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.hampcode.bankingservice.mapper.AccountMapper;
import com.hampcode.bankingservice.model.dto.AccountRequestDTO;
import com.hampcode.bankingservice.model.dto.AccountResponseDTO;
import com.hampcode.bankingservice.model.entities.Account;
import com.hampcode.bankingservice.repository.AccountRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private AccountMapper accountMapper;

    @InjectMocks
    private AccountService accountService;

    private AccountRequestDTO accountRequestDTO;
    private Account account;
    private AccountResponseDTO accountResponseDTO;

    @Test
    public void testCreateAccount() {
        AccountRequestDTO requestDTO = new AccountRequestDTO();
        requestDTO.setTypeAccount("user");
        requestDTO.setOwnerEmail("ejemplo@upc.edu.pe");
        requestDTO.setPassword("password123");

        Account account = new Account();
        account.setId(1L);
        account.setTypeAccount(requestDTO.getTypeAccount());
        account.setOwnerEmail(requestDTO.getOwnerEmail());
        account.setPassword(requestDTO.getPassword());

        when(accountMapper.convertToEntity(requestDTO)).thenReturn(account); 
        when(accountMapper.convertToDTO(account)).thenReturn(new AccountResponseDTO(account.getId(), account.getTypeAccount(), account.getOwnerEmail(), account.getPassword()));

        AccountResponseDTO result = accountService.createAccount(requestDTO);

        assertNotNull(result);
        assertEquals(account.getId(), result.getId());
        assertEquals(account.getTypeAccount(), result.getTypeAccount());
        assertEquals(account.getOwnerEmail(), result.getOwnerEmail());
        assertEquals(account.getPassword(), result.getPassword());


        verify(accountMapper, times(1)).convertToEntity(requestDTO);  
        verify(accountRepository, times(1)).save(account);
        verify(accountMapper, times(1)).convertToDTO(account);
    }

}