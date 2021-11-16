package com.example.sea.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.sea.entity.Brand;
import com.example.sea.exception.BadRequestException;
import com.example.sea.exception.InternalServerException;
import com.example.sea.exception.NotFoundException;
import com.example.sea.model.request.CreateBrandReq;
import com.example.sea.repository.BrandRepository;
import com.example.sea.repository.ProductRepository;
import com.example.sea.service.BrandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.bytecode.stackmap.BasicBlock.Catch;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Brand> getListBrand() {
        // TODO Auto-generated method stub
        return brandRepository.findAll();
    }

    @Override
    public Brand createBrand(CreateBrandReq req) {
        // TODO Auto-generated method stub
        Brand brand = new Brand();
        brand.setName(req.getName());
        brand.setThumbnail(req.getThumbnail());

        brandRepository.save(brand);

        return brand;
    }

    @Override
    public void updateBrand(long id, CreateBrandReq req) {
        // TODO Auto-generated method stub
        Optional<Brand> rs = brandRepository.findById(id);
        if(rs.isEmpty()){
            throw new NotFoundException("Nhãn hiệu không tồn tại!!");
        }
        Brand brand = rs.get();
        brand.setName(req.getName());
        brand.setThumbnail(req.getThumbnail());
        try{
            brandRepository.save(brand);
        }catch(Exception e){
            throw new InternalServerException("Lỗi khi cập nhật nhãn hiệu");
        }

    }

    @Override
    public void deleteBrand(long id) {
        // TODO Auto-generated method stub
        Optional<Brand> rs = brandRepository.findById(id);
        if(rs.isEmpty()){
            throw new NotFoundException("Không tìm thấy nhãn hiệu");
        }
        int count =  productRepository.countByBrandId(id);
        if(count > 0){
            throw new BadRequestException("Nhãn hiệu còn sản phẩm không thể xóa");
        }

        Brand brand = rs.get();
        try{
            brandRepository.delete(brand);
        }catch(Exception e){
            throw new InternalServerException("Lỗi khi xóa nhãn hiệu");
        }
        
    }
    
}
