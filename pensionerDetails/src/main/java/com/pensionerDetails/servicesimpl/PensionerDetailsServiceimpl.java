package com.pensionerDetails.servicesimpl;

import com.pensionerDetails.model.PensionerDetails;
import com.pensionerDetails.services.PensionDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import com.pensionerDetails.repositories.pensionDetailsRepository;
import org.springframework.stereotype.Service;

@Service
public class PensionerDetailsServiceimpl implements PensionDetailsService {



@Autowired
private pensionDetailsRepository pensionDetailRepository;


    @Override
    public PensionerDetails findByAadhar(Long Aadhar) throws Exception {

        if(this.pensionDetailRepository.findByAadhar(Aadhar)==null)
        {
            System.out.println("User Not Found with this Aadhar Number");
            throw new Exception("User Not Found with this Aadhar Number");
        }

        return  this.pensionDetailRepository.findByAadhar(Aadhar);

    }
}
