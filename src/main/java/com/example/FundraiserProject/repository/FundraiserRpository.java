package com.example.FundraiserProject.repository;

import com.example.FundraiserProject.entity.FundraiserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundraiserRpository extends JpaRepository<FundraiserEntity, Long> {
}
