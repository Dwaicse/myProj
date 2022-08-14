package com.processPension.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pension {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long aadhar;
    private String name;

    private double pensionAmount;
    private double bankCharge;
    private double allowances;
    private double totalpensionamount;
    private String lastcalculationrequestedby;
    private String  bankName;
    private Long accountNumber;
    private String bankType;

    @UpdateTimestamp
    private LocalDateTime lastUpDateTime;

}
