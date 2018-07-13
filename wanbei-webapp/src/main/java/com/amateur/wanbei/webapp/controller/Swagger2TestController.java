package com.amateur.wanbei.webapp.controller;

import com.amateur.wanbei.service.bean.City;
import com.amateur.wanbei.service.common.ResultApi;
import io.swagger.annotations.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/demo")
@EnableSwagger2
@Api(value = "API - DemoController", description = "demo接口")
public class Swagger2TestController {

    @ApiOperation(value = "获取城市接口", notes = "Get city by state", response = City.class)
    @ApiResponses(value = {@ApiResponse(code = 405, message = "Invalid input", response = City.class)})
    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public ResultApi<City> getCityByState(@ApiParam(value = "The id of the city", required = true) @RequestParam String state) {
        City city = new City("杭州", "330");
        return ResultApi.success(city);
    }

    @ApiOperation(value = "save city", notes = "", response = City.class)
    @RequestMapping(value = "/city", method = RequestMethod.POST)
    public ResultApi<String> saveCity(@ApiParam(value = "The id of the city", required = true) @RequestBody City city) {
        return ResultApi.success();
    }

}
