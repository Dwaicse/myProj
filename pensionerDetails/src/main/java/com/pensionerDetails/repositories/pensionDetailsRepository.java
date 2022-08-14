package com.pensionerDetails.repositories;

import com.pensionerDetails.model.PensionerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface pensionDetailsRepository extends JpaRepository<PensionerDetails, Long> {

    public PensionerDetails findByAadhar(Long aadhar);



}
