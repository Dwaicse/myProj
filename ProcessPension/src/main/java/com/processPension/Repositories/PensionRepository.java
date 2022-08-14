package com.processPension.Repositories;

import com.processPension.models.Pension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PensionRepository extends JpaRepository<Pension,Long> {

        public Pension findByAadhar(Long Aadhar);
    }

