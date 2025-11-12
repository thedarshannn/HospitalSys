package dev.darshan.hospitalsys.service.impl;

import dev.darshan.hospitalsys.config.PatientMapper;
import dev.darshan.hospitalsys.model.dto.PatientDto;
import dev.darshan.hospitalsys.model.entity.Patient;
import dev.darshan.hospitalsys.repo.PatientRepo;
import dev.darshan.hospitalsys.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepo patientRepo;
    private final PatientMapper patientMapper;

    @Override
    public List<PatientDto> getAllPatients() {
        List<Patient> patients = patientRepo.findAll();
        return patientMapper.toDtoList(patients);
    }

    @Override
    public PatientDto getPatientById(Integer id) {
        Patient res = patientRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Patient Not Found"));
        return patientMapper.toDto(res);
    }

    @Override
    public PatientDto addPatient(PatientDto reqPatientDto) {
        Patient patient = patientMapper.toEntity(reqPatientDto);
        patientRepo.save(patient);
        return patientMapper.toDto(patient);
    }

    @Override
    public PatientDto updatePatient(Integer id, PatientDto updatePatientDto) {
        Patient existing = patientRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + id));

        // MapStruct only copies from DTO to Entity — so we reuse it here
        Patient updated = patientMapper.toEntity(updatePatientDto);

        // Ensure ID stays the same
        updated.setPatientId(existing.getPatientId());

        // Now save the updated entity
        Patient saved = patientRepo.save(updated);

        return patientMapper.toDto(saved);
    }

    @Override
    public void deletePatientById(int id) {
        patientRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + id));
        patientRepo.deleteById(id);
    }

}
