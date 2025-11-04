package dev.darshan.hospitalsys.config;

import dev.darshan.hospitalsys.model.dto.PatientDto;
import dev.darshan.hospitalsys.model.entity.Patient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientDto toDto(Patient patient);
    Patient toEntity(PatientDto dto);
    List<PatientDto> toDtoList(List<Patient> patients);
}
