package com.example.sea.model.mapper;

import java.util.ArrayList;

import com.example.sea.entity.Brand;
import com.example.sea.entity.Category;
import com.example.sea.entity.Product;
import com.example.sea.model.dto.ProductDto;
import com.example.sea.model.request.CreateProductReq;
import com.github.slugify.Slugify;

public class ProductMapper {


    public static ProductDto toProductDto(Product product){
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setSlug(product.getSlug());
        dto.setDescription(product.getDescription());
        dto.setBrand(product.getBrand());
        dto.setPrice(product.getPrice());
        dto.setTotalSold(product.getTotalSold());
        dto.setProductImage(product.getProductImage());
        dto.setSliderImage(product.getSliderImage());
        return dto;
    }

    

    public static Product toProduct(CreateProductReq req){
        Product product = new Product();
        product.setName(req.getName());
        Slugify slg = new Slugify();
        product.setSlug(slg.slugify(req.getName()));
        product.setDescription(req.getDescription());
        product.setPrice(req.getPrice());
        Brand brand = new Brand();
        brand.setId(req.getBrandId());
        product.setBrand(brand);
        product.setAvailable(true);
        product.setProductImage(req.getProductImage());
        product.setSliderImage(req.getSliderImage());

        ArrayList<Category> categories = new ArrayList<Category>();
        for (Integer id : req.getCategoryId()) {
            Category category = new Category();
            category.setId(id);
            categories.add(category);
        }
        product.setCategories(categories);
        return product;
    }
}
