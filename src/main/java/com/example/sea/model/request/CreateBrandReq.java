package com.example.sea.model.request;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBrandReq {
    @NotNull(message = "Tên nhãn trống")
    private String name;

    @NotNull(message = "Ảnh trống")
    private String thumbail;
}
