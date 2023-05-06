package com.example.FundraiserProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fundraiser")
public class FundraiserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "fundraiserId")
    int fundraiserId;
    @Column(name = "fundraiserName")
    String fundraiserName;
    @Column(name = "currentAmount")
    int currentAmount;
    @Column(name = "startDate")
    String startDate;
    @Column(name = "endDate")
    String endDate;
    @Column(name = "targetAmount")
    int targetAmount;
}
