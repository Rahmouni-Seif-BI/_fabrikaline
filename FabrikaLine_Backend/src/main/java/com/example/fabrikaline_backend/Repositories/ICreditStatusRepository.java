package com.example.fabrikaline_backend.Repositories;


import com.example.fabrikaline_backend.Entities.Account;
import com.example.fabrikaline_backend.Entities.CreditStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICreditStatusRepository extends JpaRepository<CreditStatus,Long> {
}
