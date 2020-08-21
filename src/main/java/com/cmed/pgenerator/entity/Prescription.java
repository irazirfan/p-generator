package com.cmed.pgenerator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRESCRIPTION_TBL")

public class Prescription {
    @Id
    @GeneratedValue
    private int id;
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    @NonNull
    private Date prescriptionDate;
    @NonNull
    private String patientName;
    @NonNull
    private int patientAge;
    @NonNull
    private byte patientGender;
    private String diagnosis;
    @NonNull
    private String medicine;
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    private Date nextVisitDate;
}
