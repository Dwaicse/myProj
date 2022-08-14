package com.processPension.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class PensionerDetails {



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