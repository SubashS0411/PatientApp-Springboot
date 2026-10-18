package com.loq.student_app.mapper;

import com.loq.student_app.dto.PatientResponseDTO;
import com.loq.student_app.model.Patient;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PatientMapperTest {

    @Test
    void mapsPatientFieldsToResponse() {
        Patient patient = new Patient();
        patient.setId(UUID.randomUUID());
        patient.setName("Ada Lovelace");
        patient.setEmail("ada@example.com");
        patient.setAddress("1 Analytical Engine Way");
        patient.setDataofbirth(LocalDate.of(1815, 12, 10));

        PatientResponseDTO response = PatientMapper.toDTO(patient);

        assertEquals(patient.getId().toString(), response.getId());
        assertEquals(patient.getName(), response.getName());
        assertEquals(patient.getEmail(), response.getEmail());
        assertEquals(patient.getAddress(), response.getAddress());
        assertEquals("1815-12-10", response.getDataofBirth());
    }

    @Test
    void mapsMissingBirthDateAsNull() {
        PatientResponseDTO response = PatientMapper.toDTO(new Patient());

        assertNull(response.getDataofBirth());
    }
}