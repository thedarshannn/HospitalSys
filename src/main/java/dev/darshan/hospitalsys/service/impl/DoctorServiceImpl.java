package dev.darshan.hospitalsys.service.impl;

import dev.darshan.hospitalsys.config.DoctorMapper;
import dev.darshan.hospitalsys.model.dto.DoctorDto;
import dev.darshan.hospitalsys.model.entity.Doctor;
import dev.darshan.hospitalsys.model.entity.Patient;
import dev.darshan.hospitalsys.repo.DoctorRepo;
import dev.darshan.hospitalsys.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepo doctorRepo;
    private final DoctorMapper doctorMapper;


    @Override
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> listOfDoctors = doctorRepo.findAll();
        return doctorMapper.toDoctorDtoList(listOfDoctors);
    }

    @Override
    public DoctorDto getDoctorById(int id) {
        Doctor res = doctorRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Doctor Not Found"));
        return doctorMapper.toDoctorDto(res);
    }
}
