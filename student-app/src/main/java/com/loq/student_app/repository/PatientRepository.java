package com.loq.student_app.repository;

import com.loq.student_app.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository  extends JpaRepository<Patient, UUID> {
}
