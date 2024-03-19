package com.example.IOS_Module_CW_Backend.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;

    private String name;

    private String description;

    private String size;

    private String price;

    private String color;

    public List<ImageDTO> imageDTO;
}
