package com.processPension.controller;


import com.processPension.Repositories.PensionRepository;
import com.processPension.models.Pension;
import com.processPension.models.PensionerDetails;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/claims")
@CrossOrigin("*")

public class ClaimsController {




    @Autowired
    PensionRepository pensionRepository;

    @ApiImplicitParams({
            @ApiImplicitParam(name="ProcessAuthorization", value = "Token", required = true, allowEmptyValue = false,paramType = "header", dataTypeClass = String.class,example = "Bearer access_token")
    })
    @PostMapping("/ProcessPension")
    public Pension processPension(@RequestBody PensionerDetails pensionerDetails) throws Exception {



        if (pensionerDetails != null) {
            String type = pensionerDetails.getClassification();
            double percent = 0.1;
            double bankcharge = 0.0;
            if (type.equalsIgnoreCase( "self") ){
                percent = 0.8;
            } else if (type.equalsIgnoreCase("family")) {
                percent = 0.5;
            }
            String bankType = pensionerDetails.getTypeOfbank();
            if (bankType.equalsIgnoreCase("Private")) {
                bankcharge = 550;

            } else if (bankType.equalsIgnoreCase("Public")) {
                bankcharge = 500;
            }

            double totalPension = ((pensionerDetails.getSalaryEarned() * percent) + pensionerDetails.getAllowances()) - bankcharge;


            Pension pension = new Pension();
            pension.setAadhar(pensionerDetails.getAadhar());
            pension.setName(pensionerDetails.getName());

            pension.setPensionAmount(((pensionerDetails.getSalaryEarned() * percent) + pensionerDetails.getAllowances()));
            pension.setAllowances(pensionerDetails.getAllowances());
            pension.setBankCharge(bankcharge);
            pension.setTotalpensionamount(totalPension);
            pension.setAccountNumber(pensionerDetails.getAccountNumber());
            pension.setBankName(pensionerDetails.getBankName());
            pension.setBankType(pensionerDetails.getTypeOfbank());



            pensionRepository.save(pension);
            return pension;


        }


        return null;


    }

    @GetMapping("/getPreviousCalculation")
    @ApiImplicitParams({
            @ApiImplicitParam(name="ProcessAuthorization", value = "Token", required = true, allowEmptyValue = false,paramType = "header", dataTypeClass = String.class,example = "Bearer access_token")
    })
    public List<Pension> getPreviousCalculation(){
        return pensionRepository.findAll();

    }



}
