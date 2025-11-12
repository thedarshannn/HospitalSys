package dev.darshan.hospitalsys.service;

import dev.darshan.hospitalsys.model.dto.PatientDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PatientService {
    List<PatientDto> getAllPatients();

    PatientDto getPatientById(Integer id);

    PatientDto addPatient(@Valid PatientDto reqPatientDto);

    PatientDto updatePatient(Integer id, @Valid PatientDto updatePatientDto);

    void deletePatientById(int id);
}
