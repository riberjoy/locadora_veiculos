package com.locadora.locacaoapi.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeignResponse {

    @SerializedName("timestamp")
    private String timestamp;

    @SerializedName("status")
    private Integer status;

    @SerializedName("error")
    private String error;

    @SerializedName("message")
    private String message;

    @SerializedName("path")
    private String path;
}
