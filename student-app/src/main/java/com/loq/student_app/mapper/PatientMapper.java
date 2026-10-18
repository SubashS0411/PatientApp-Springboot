package com.loq.student_app.mapper;

import com.loq.student_app.dto.PatientResponseDTO;
import com.loq.student_app.model.Patient;

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

        return patientdto;
    }
}
