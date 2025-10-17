package dev.darshan.hospitalsys.config;

import dev.darshan.hospitalsys.model.dto.PatientDto;
import dev.darshan.hospitalsys.model.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {


    @Mapping(source = "patient_id", target = "patientId")
    @Mapping(source = "first_name", target = "firstName")
    @Mapping(source = "last_name", target = "lastName")
    @Mapping(source = "date_of_birth", target = "dateOfBirth")
    @Mapping(source = "phone_number", target = "phoneNumber")
    @Mapping(source = "insurance_id", target = "insuranceId")
    PatientDto toDto(Patient patient);
    Patient toEntity(PatientDto dto);
    List<PatientDto> toDtoList(List<Patient> patients);
}
