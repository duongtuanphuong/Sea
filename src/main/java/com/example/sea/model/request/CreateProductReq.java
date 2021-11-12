package com.example.sea.model.request;

import java.util.ArrayList;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductReq {
    @NotNull(message = "Tên sản phẩm trống")
    @NotEmpty(message = "Tên sản phẩm trống")
    @Size(min = 1,max = 300,message = "Độ dài tên sản phẩm từ 1-300 kí tự")
    private String name;

    @NotNull(message = "Mô tả trống")
    @NotEmpty(message = "Mô tả trống")
    private String description;

    @NotNull(message = "Nhãn hiệu trống")
    private Integer brandId;

    @NotNull(message = "Category trống")
    @JsonProperty("category_ids")
    private ArrayList<Integer> categoryId;


    // @JsonProperty("is_available")
    // private boolean isAvailable;

    @NotNull(message = "Giá tiền trống")
    @Min(1000)
    private Integer price;

    @NotNull(message = "Ảnh sản phẩm trống")
    private String productImage;

    @NotNull(message = "Thanh ảnh trống")
    @NotEmpty(message = "Thanh ảnh trống")
    private ArrayList<String> sliderImage;

}
