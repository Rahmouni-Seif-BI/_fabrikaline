package com.example.fabrikaline_backend.Repositories;


import com.example.fabrikaline_backend.Entities.Account;
import com.example.fabrikaline_backend.Entities.Spending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAccountRepository extends JpaRepository<Account,Long> {

}
