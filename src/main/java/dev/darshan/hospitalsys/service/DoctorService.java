package dev.darshan.hospitalsys.service;

import dev.darshan.hospitalsys.model.dto.DoctorDto;
import jakarta.validation.Valid;

import java.util.List;

public interface DoctorService {
    List<DoctorDto> getAllDoctors();

    DoctorDto getDoctorById(int i);

    DoctorDto addDoctor(@Valid DoctorDto reqDoctorDto);

    DoctorDto updateDoctor(int id, @Valid DoctorDto updatedDoctorDto);
}
