package com.example.fabrikaline_backend.Repositories;


import com.example.fabrikaline_backend.Entities.CreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICreditEntityRepository extends JpaRepository<CreditEntity,Long> {
}
