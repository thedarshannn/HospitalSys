package dev.darshan.hospitalsys.service;

import dev.darshan.hospitalsys.model.dto.DoctorDto;

import java.util.List;

public interface DoctorService {
    List<DoctorDto> getAllDoctors();
}
