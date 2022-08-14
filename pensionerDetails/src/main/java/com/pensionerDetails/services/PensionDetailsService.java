package com.pensionerDetails.services;

import com.pensionerDetails.model.PensionerDetails;

public interface PensionDetailsService {

    public PensionerDetails findByAadhar(Long aadhar) throws Exception;
}
