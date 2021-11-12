package com.example.sea.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryReq {
    @NotNull(message = "Tên danh mục trống")
    @NotEmpty(message = "Tên danh mục trống")
    private String name;
}
