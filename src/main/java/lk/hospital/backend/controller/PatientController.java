package lk.hospital.backend.controller;

import lk.hospital.backend.dto.PatientDTO;
import lk.hospital.backend.service.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/")
public class PatientController {
    @Autowired
    private PatientServices patientServices;

    @GetMapping("/getpatients")
    public List<PatientDTO> getPatients() {
        return patientServices.getAllPatients();
    }

    @PostMapping("/addpatient")
    public PatientDTO savePatient(@RequestBody PatientDTO patientDTO) {
        return patientServices.savePatient(patientDTO);
    }

    @PutMapping("/updatepatient")
    public PatientDTO updatePatient(@RequestBody PatientDTO patientDTO) {
        return patientServices.updatePatient(patientDTO);
    }

    @DeleteMapping("/deletepatient")
    public String deletePatient(@RequestBody PatientDTO patientDTO) {
        return patientServices.deletePatient(patientDTO);
    }
}
