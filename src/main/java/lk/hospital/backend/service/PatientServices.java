package lk.hospital.backend.service;

import jakarta.transaction.Transactional;
import lk.hospital.backend.dto.PatientDTO;
import lk.hospital.backend.model.Patient;
import lk.hospital.backend.repo.PatientRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PatientServices {
    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<PatientDTO> getAllPatients() {
        List<Patient> patientList = patientRepo.findAll();
        return modelMapper.map(patientList, new TypeToken<List<PatientDTO>>(){}.getType());
    }

    public PatientDTO savePatient(PatientDTO patientDTO) {
        patientRepo.save(modelMapper.map(patientDTO, Patient.class));
        return patientDTO;
    }

    public PatientDTO updatePatient(PatientDTO patientDTO) {
        patientRepo.save(modelMapper.map(patientDTO, Patient.class));
        return patientDTO;
    }

    public String deletePatient(PatientDTO patientDTO) {
        patientRepo.delete(modelMapper.map(patientDTO, Patient.class));
        return "Patient Deleted Successfully";
    }
}