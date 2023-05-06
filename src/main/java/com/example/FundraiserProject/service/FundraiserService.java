package com.example.FundraiserProject.service;

import com.example.FundraiserProject.entity.FundraiserEntity;

import java.util.List;

public interface FundraiserService {

    //create
    FundraiserEntity addFundraiser(FundraiserEntity fundraiser);
    //get all
    List<FundraiserEntity> getAllFundraiser();
    //get by id
    FundraiserEntity getFundraiserById(Long id);
    //update
    FundraiserEntity updateFundraiser(Long id, FundraiserEntity fundraiser);
    //delete
    void  deleteFundraiser(Long id);
}