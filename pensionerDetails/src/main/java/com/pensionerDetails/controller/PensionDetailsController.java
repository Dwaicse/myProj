package com.pensionerDetails.controller;

import com.pensionerDetails.model.PensionerDetails;
import com.pensionerDetails.services.PensionDetailsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pensionerDetails")
@CrossOrigin("*")

public class PensionDetailsController {


    @Autowired
    private PensionDetailsService pensionerDetailsService;


    @GetMapping("/PensionerDetailsByAadhaar/{aadharNo}")
    @ApiImplicitParams({
            @ApiImplicitParam(name="DetailsAuthorization", value = "Token", required = true, allowEmptyValue = false,paramType = "header", dataTypeClass = String.class,example = "Bearer access_token")
    })
    public PensionerDetails findByAadhar(@PathVariable("aadharNo") Long Aadhar) throws Exception
    {
        return this.pensionerDetailsService.findByAadhar(Aadhar);
    }



}

