package com.example.sea.service;

import java.util.List;

import com.example.sea.entity.Brand;
import com.example.sea.model.request.CreateBrandReq;

public interface BrandService {
    public List<Brand> getListBrand();

    public Brand createBrand(CreateBrandReq req);

    public void updateBrand(long id,CreateBrandReq req);

    public void deleteBrand(long id);
}
