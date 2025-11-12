package dev.darshan.hospitalsys.controller;

import dev.darshan.hospitalsys.model.dto.DoctorDto;
import dev.darshan.hospitalsys.service.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("/all")
    public ResponseEntity<List<DoctorDto>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable String id) {
        return ResponseEntity.ok(doctorService.getDoctorById(Integer.parseInt(id)));
    }

    @PostMapping()
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody @Valid DoctorDto reqDoctorDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.addDoctor(reqDoctorDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DoctorDto> updateDoctor(@PathVariable String id, @RequestBody @Valid DoctorDto updatedDoctorDto) {
        return ResponseEntity.ok(doctorService.updateDoctor(Integer.parseInt(id), updatedDoctorDto));
    }
}
