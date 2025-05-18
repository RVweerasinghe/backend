package lk.hospital.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    public int id;
    public String name;
    public int price;
    public String description;
    public int quantity;
}

