package com.example.sea.controller.admin;

import javax.validation.Valid;

import com.example.sea.entity.Brand;
import com.example.sea.model.request.CreateBrandReq;
import com.example.sea.service.BrandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("/admin/brands")
    public String getListBrand(Model model){
        model.addAttribute("brands", brandService.getListBrand());
        return "home";
    }
    
    @PostMapping("/api/admin/brand")
    public ResponseEntity<?> createBrand(@Valid @RequestBody CreateBrandReq req){
        Brand brand = brandService.createBrand(req);
        return ResponseEntity.ok(brand);
    }

    @PutMapping("/api/admin/brand/{id}")
    public ResponseEntity<?> updateBrand(@Valid @RequestBody CreateBrandReq req,@PathVariable long id){
        brandService.updateBrand(id, req);
        return ResponseEntity.ok("Cập nhật thành công");
    }

    @DeleteMapping("/api/admin/brand/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable long id){
        brandService.deleteBrand(id);
        return ResponseEntity.ok("Xóa thành công");
    }
}
