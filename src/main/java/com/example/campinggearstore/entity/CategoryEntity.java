package com.example.campinggearstore.entity;

import com.example.campinggearstore.entity.category.embedded.SubCategory;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Property;
import dev.morphia.annotations.Reference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CategoryEntity extends BaseEntity implements Serializable {
    private String categoryName;
    @Property
    @Reference
    private List<SubCategory> subCategories;
}
