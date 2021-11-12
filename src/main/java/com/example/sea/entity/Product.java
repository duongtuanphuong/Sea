package com.example.sea.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.vladmihalcea.hibernate.type.json.JsonStringType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name ="product")
@Table(name = "product")
@TypeDef(
    name = "json",
    typeClass = JsonStringType.class
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name",nullable = false,length = 300)
    private String name;

    @Column(name = "slug",nullable = false,length = 300)
    private String slug;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(name = "price",nullable = false)
    private long price;

    @Column(name = "total_sold")
    private int totalSold;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "is_available",columnDefinition = "TINYINT(1)")
    private boolean isAvailable;

    @ManyToMany(fetch =  FetchType.LAZY)
    @JoinTable(
        name = "product_category",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    @Column(name = "product_image")
    private String productImage;

    @Type(type = "json")
    @Column(name = "silder_image",columnDefinition = "json")
    private ArrayList<String> sliderImage;
    


}
