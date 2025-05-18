package lk.hospital.backend.service;

import jakarta.transaction.Transactional;
import lk.hospital.backend.dto.ProductDTO;
import lk.hospital.backend.model.Product;
import lk.hospital.backend.repo.ProductRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductServices {
    @Autowired
    private ProductRepo patientRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProductDTO> getAllPatients() {
        List<Product> patientList = patientRepo.findAll();
        return modelMapper.map(patientList, new TypeToken<List<ProductDTO>>(){}.getType());
    }

    public ProductDTO savePatient(ProductDTO patientDTO) {
        patientRepo.save(modelMapper.map(patientDTO, Product.class));
        return patientDTO;
    }

    public ProductDTO updatePatient(ProductDTO patientDTO) {
        patientRepo.save(modelMapper.map(patientDTO, Product.class));
        return patientDTO;
    }

    public String deletePatient(ProductDTO patientDTO) {
        patientRepo.delete(modelMapper.map(patientDTO, Product.class));
        return "Patient Deleted Successfully";
    }
}