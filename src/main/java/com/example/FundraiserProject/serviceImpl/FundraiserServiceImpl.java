package com.example.FundraiserProject.serviceImpl;

import com.example.FundraiserProject.entity.FundraiserEntity;
import com.example.FundraiserProject.exception.FundraiserException;
import com.example.FundraiserProject.repository.FundraiserRpository;
import com.example.FundraiserProject.service.FundraiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FundraiserServiceImpl implements FundraiserService {


    private FundraiserRpository fundraiserRpository;

    public FundraiserServiceImpl(FundraiserRpository fundraiserRpository) {
        this.fundraiserRpository = fundraiserRpository;
    }

    @Override
    public FundraiserEntity addFundraiser(FundraiserEntity fundraiser) {
        return fundraiserRpository.save(fundraiser);
    }

    @Override
    public List<FundraiserEntity> getAllFundraiser() {
        return fundraiserRpository.findAll();
    }

    @Override
    public FundraiserEntity getFundraiserById(Long id) {
        FundraiserEntity fundraiser = fundraiserRpository.findById(id)
                .orElseThrow(()->new FundraiserException("Not found"));
        return fundraiser;
    }

    @Override
    public FundraiserEntity updateFundraiser(Long id, FundraiserEntity fundraiser) {
        FundraiserEntity fundraiser1 = fundraiserRpository.findById(id)
                .orElseThrow(()->new FundraiserException("Not found"));

        fundraiser1.setFundraiserId(fundraiser.getFundraiserId());
        fundraiser1.setFundraiserName(fundraiser.getFundraiserName());
        fundraiser1.setCurrentAmount(fundraiser.getCurrentAmount());
        fundraiser1.setTargetAmount(fundraiser.getTargetAmount());
        fundraiser1.setStartDate(fundraiser.getStartDate());
        fundraiser1.setEndDate(fundraiser.getEndDate());

        FundraiserEntity updateFundraiser = fundraiserRpository.save(fundraiser1);
        return updateFundraiser;
    }

    @Override
    public void deleteFundraiser(Long id) {
        FundraiserEntity fundraiser = fundraiserRpository.findById(id)
                .orElseThrow(()->new FundraiserException("Not found"));

        fundraiserRpository.delete(fundraiser);
    }
}
