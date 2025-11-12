package dev.darshan.hospitalsys.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorDto {

    private Integer doctorId;
    private String firstName;
    private String lastName;
    private String specialization;
    private String phoneNumber;
    private String email;
}
