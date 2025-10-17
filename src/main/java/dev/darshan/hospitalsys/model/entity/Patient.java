package dev.darshan.hospitalsys.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patient_id;

    private String first_name;

    private String last_name;

    private LocalDate date_of_birth;

    private String gender;

    private String phone_number;

    private String address;

    private Integer insurance_id;
}
