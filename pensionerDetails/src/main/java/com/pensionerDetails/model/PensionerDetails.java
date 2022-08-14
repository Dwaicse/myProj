package com.pensionerDetails.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Builder
public class PensionerDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;






    private String name;

    private String dateOfbirth;

    private String pan;
    private Long aadhar;
    private double salaryEarned;
    private double allowances;
    private String classification;

    private String bankName;
    private Long accountNumber;
    private String typeOfbank;

}

