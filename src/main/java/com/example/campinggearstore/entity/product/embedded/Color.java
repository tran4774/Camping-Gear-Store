package com.example.campinggearstore.entity.product.embedded;

import dev.morphia.annotations.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Color {
    private int quantity;
    private String colorName;
    private List<String> imageUrl;
}
