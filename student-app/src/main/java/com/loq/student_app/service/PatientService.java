package com.loq.student_app.service;

import com.loq.student_app.dto.PatientRequestDTO;
import com.loq.student_app.dto.PatientResponseDTO;
import com.loq.student_app.exception.EmailAlreadyExistsException;
import com.loq.student_app.exception.PatientNotFoundException;
import com.loq.student_app.mapper.PatientMapper;
import com.loq.student_app.model.Patient;
import com.loq.student_app.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    public List<PatientResponseDTO> getPatients(){
        List<Patient> patients = patientRepository.findAll();
        List<PatientResponseDTO> patientResponseDTOs =
                patients.stream().map(patient -> PatientMapper.toDTO(patient)).toList();
        return patientResponseDTOs;
    }
    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO){
        if(patientRepository.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException("A patient with this email "+"already exists"+patientRequestDTO.getEmail());
        }
        Patient newPatient = patientRepository.save(
                PatientMapper.toModel(patientRequestDTO));
        return PatientMapper.toDTO(newPatient);
    }
    public PatientResponseDTO updatePatient(UUID id,
                                            PatientRequestDTO patientRequestDTO){
        Patient patient = patientRepository.findById(id).orElseThrow(
                ()->new PatientNotFoundException("Patient not found with ID: "+id));
        if(patientRepository.existsByEmailAndIdNot(patientRequestDTO.getEmail(),id)){
            throw new EmailAlreadyExistsException("A patient with this email already exists"+patientRequestDTO.getEmail());
        }

        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setDataofbirth(LocalDate.parse(patientRequestDTO.getDateofbirth()));
        Patient updatedPatient= patientRepository.save(patient);
        return PatientMapper.toDTO(updatedPatient);
    }
    public void deletePatient(UUID id){
        patientRepository.deleteById(id);
    }
}
