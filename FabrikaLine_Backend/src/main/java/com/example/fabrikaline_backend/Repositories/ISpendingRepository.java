package com.example.fabrikaline_backend.Repositories;


import com.example.fabrikaline_backend.Entities.Account;
import com.example.fabrikaline_backend.Entities.Spending;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISpendingRepository extends JpaRepository<Spending,Long> {
    List<Spending> getSpendingsByAccount_Id(Long accountId);

}
