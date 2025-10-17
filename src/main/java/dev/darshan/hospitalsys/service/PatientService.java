package dev.darshan.hospitalsys.service;

import dev.darshan.hospitalsys.model.dto.PatientDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PatientService {
    List<PatientDto> getAllPatients();
}
