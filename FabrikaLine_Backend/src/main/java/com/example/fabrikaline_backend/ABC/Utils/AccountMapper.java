package com.example.fabrikaline_backend.ABC.Utils;

import com.example.fabrikaline_backend.DTO.AccountDTO;
import com.example.fabrikaline_backend.Entities.Account;
//import org.mapstruct.Mapper;

//@Mapper(componentModel = "spring")

public interface AccountMapper {
    AccountDTO toDTO(Account account);
    Account fromDTO(AccountDTO accountDTO);
}
