package lk.hospital.backend.controller;

import lk.hospital.backend.dto.ProductDTO;
import lk.hospital.backend.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/")
public class ProducntController {
    @Autowired
    private ProductServices patientServices;

    @GetMapping("/getproduct")
    public List<ProductDTO> getPatients() {
        return patientServices.getAllPatients();
    }

    @PostMapping("/addproduct")
    public ProductDTO savePatient(@RequestBody ProductDTO patientDTO) {
        return patientServices.savePatient(patientDTO);
    }

    @PutMapping("/updateproduct")
    public ProductDTO updatePatient(@RequestBody ProductDTO patientDTO) {
        return patientServices.updatePatient(patientDTO);
    }

    @DeleteMapping("/deleteproduct")
    public String deletePatient(@RequestBody ProductDTO patientDTO) {
        return patientServices.deletePatient(patientDTO);
    }
}
