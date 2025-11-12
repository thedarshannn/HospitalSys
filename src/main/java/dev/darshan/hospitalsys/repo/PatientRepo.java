package dev.darshan.hospitalsys.repo;

import dev.darshan.hospitalsys.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {

    List<Patient> findByFirstName(String firstName);
}
