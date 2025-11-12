package dev.darshan.hospitalsys.config;

import dev.darshan.hospitalsys.model.dto.DoctorDto;
import dev.darshan.hospitalsys.model.entity.Doctor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    DoctorDto toDoctorDto(Doctor doctor);
    Doctor toDoctor(DoctorDto doctorDto);
    List<DoctorDto> toDoctorDtoList(List<Doctor> doctors);

}
