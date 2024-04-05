package com.example.fabrikaline_backend.Repositories;


import com.example.fabrikaline_backend.Entities.RepaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepaymentEntityRepository extends JpaRepository<RepaymentEntity,Long> {
}
