package dev.darshan.hospitalsys.controller;

import dev.darshan.hospitalsys.model.dto.PatientDto;
import dev.darshan.hospitalsys.service.PatientService;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/all")
    public ResponseEntity<List<PatientDto>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable String id) {
        return ResponseEntity.ok(patientService.getPatientById(Integer.parseInt(id)));
    }

    @PostMapping
    public ResponseEntity<PatientDto> createPatient(@RequestBody @Valid PatientDto reqPatientDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.addPatient(reqPatientDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PatientDto> updatePatient(@PathVariable String id,@RequestBody @Valid PatientDto updatePatientDto) {
        return ResponseEntity.ok(patientService.updatePatient(Integer.parseInt(id), updatePatientDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatientById(@PathVariable String id) {
        patientService.deletePatientById(Integer.parseInt(id));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
