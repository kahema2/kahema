package com.example.FundraiserProject.controller;

import com.example.FundraiserProject.entity.FundraiserEntity;
import com.example.FundraiserProject.service.FundraiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/limbu/fundraiser")
public class FundraiserController {

    private FundraiserService fundraiserService;

    public FundraiserController(FundraiserService fundraiserService) {
        this.fundraiserService = fundraiserService;
    }

    //create
    @PostMapping
    public ResponseEntity<FundraiserEntity> addFundraiser(@RequestBody FundraiserEntity fundraiser){
        return new ResponseEntity<>(fundraiserService.addFundraiser(fundraiser), HttpStatus.CREATED);
    }

    //get all
    @GetMapping
    public List<FundraiserEntity> getAllFundraiser(){
        return fundraiserService.getAllFundraiser();
    }
    //get by id
    @GetMapping("{id}")
    public ResponseEntity<FundraiserEntity> getFundraiserById(@PathVariable Long id){
        return new ResponseEntity<>(fundraiserService.getFundraiserById(id), HttpStatus.OK);
    }
    //update
    @PutMapping("{id}")
    public ResponseEntity<FundraiserEntity> updateFundraiser(@PathVariable Long id, @RequestBody FundraiserEntity fundraiser){
        return new ResponseEntity<>(fundraiserService.updateFundraiser(id, fundraiser), HttpStatus.OK);
    }
    //delete
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFundraiser(@PathVariable Long id){
        fundraiserService.deleteFundraiser(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
