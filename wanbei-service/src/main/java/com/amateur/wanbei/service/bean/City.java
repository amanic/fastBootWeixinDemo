package com.amateur.wanbei.service.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "City", description = "城市对象")
public class City {

    @ApiModelProperty("城市名")
    String name;

    @ApiModelProperty("城市码")
    String state;

    public City(String name, String state) {
        this.name = name;
        this.state = state;
    }
}
