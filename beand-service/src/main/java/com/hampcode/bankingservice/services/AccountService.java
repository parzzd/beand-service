package com.hampcode.bankingservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hampcode.bankingservice.exceptions.ResourceNotFoundException;
import com.hampcode.bankingservice.mapper.AccountMapper;
import com.hampcode.bankingservice.model.dto.AccountRequestDTO;
import com.hampcode.bankingservice.model.dto.AccountResponseDTO;
import com.hampcode.bankingservice.model.entities.Account;
import com.hampcode.bankingservice.repository.AccountRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Transactional(readOnly = true)
    public List<AccountResponseDTO> getAllAccounts(){
        List<Account> accounts = accountRepository.findAll();
        return accountMapper.convertToListDTO(accounts);
    }

    @Transactional(readOnly = true)
    public AccountResponseDTO getAccountById(Long id){
        Account account = accountRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Cuesta no encontrada con el numero:"+id));
        return accountMapper.convertToDTO(account);
    }

    @Transactional
    public AccountResponseDTO createAccount(AccountRequestDTO accountRequestDTO){

        String encryptedPassword = encryptPassword(accountRequestDTO.getPassword());

        Account account = accountMapper.convertToEntity(accountRequestDTO);
        account.setTypeAccount(accountRequestDTO.getTypeAccount());
        account.setOwnerEmail(accountRequestDTO.getOwnerEmail());
        account.setPassword(encryptedPassword);
        accountRepository.save(account);
        return accountMapper.convertToDTO(account);
    }

    @Transactional
    public AccountResponseDTO updateAccount(Long id, AccountRequestDTO accountRequestDTO) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada con el número:" + id));

        account.setTypeAccount(accountRequestDTO.getTypeAccount());
        account.setOwnerEmail(accountRequestDTO.getOwnerEmail());

        if (accountRequestDTO.getPassword() != null && !accountRequestDTO.getPassword().isEmpty()) {
            String encryptedPassword = encryptPassword(accountRequestDTO.getPassword());
            account.setPassword(encryptedPassword);
        }

        accountRepository.save(account);

        return accountMapper.convertToDTO(account);
    }

    private String encryptPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    @Autowired
    public boolean authenticate(String ownerEmail, String password) {
        
        Account account = accountRepository.findByOwnerEmail(ownerEmail)
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada para el correo electrónico: " + ownerEmail));

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password, account.getPassword());
    }

    @Transactional
    public  void deleteAccount(Long id){
        accountRepository.deleteById(id);
    }
}
