package com.example.fabrikaline_backend.Repositories;


import com.example.fabrikaline_backend.Entities.Account;
import com.example.fabrikaline_backend.Entities.Purpose;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPurposeRepository extends JpaRepository<Purpose,Long> {
}
