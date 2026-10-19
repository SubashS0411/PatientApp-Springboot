package com.loq.student_app.mapper;
import com.loq.student_app.dto.PatientRequestDTO;
import com.loq.student_app.dto.PatientResponseDTO;
import com.loq.student_app.model.Patient;

import java.time.LocalDate;

public class PatientMapper {
    public static PatientResponseDTO toDTO(Patient patient){
        PatientResponseDTO patientdto = new PatientResponseDTO();
        patientdto.setId(patient.getId() != null ? patient.getId().toString() : null);
        patientdto.setName(patient.getName());
        patientdto.setAddress(patient.getAddress());
        patientdto.setEmail(patient.getEmail());
        patientdto.setDataofBirth(patient.getDataofbirth() != null
            ? patient.getDataofbirth().toString()
            : null);
        patientdto.setRegisterdate(patient.getRegisterdate() != null
            ? patient.getRegisterdate().toString()
            : null);

        return patientdto;
    }
    public static Patient toModel(PatientRequestDTO patientdto){
        Patient patient = new Patient();
        patient.setName(patientdto.getName());
        patient.setAddress(patientdto.getAddress());
        patient.setEmail(patientdto.getEmail());
        patient.setDataofbirth(LocalDate.parse(patientdto.getDateofbirth()));
        patient.setRegisterdate(LocalDate.parse(patientdto.getRegisteredDate()));
        return patient;
    }
}
