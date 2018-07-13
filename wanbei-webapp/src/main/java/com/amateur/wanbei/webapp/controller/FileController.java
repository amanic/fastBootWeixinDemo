package com.amateur.wanbei.webapp.controller;


import com.amateur.wanbei.service.common.ResultApi;
import com.amateur.wanbei.service.component.FileComponent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("file")
@Api(value = "文件统一接口", description = "文件统一接口")
public class FileController {

    @Value("${file.img.savePath}")
    private String savePath;

    @Value("${file.img.showPath}")
    private String showPath;

    @PostMapping("saveIdcard")
    @ApiOperation(value = "保存身份证图片")
    public ResultApi<String> saveIdcard(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        String fileName = FileComponent.saveFile(multipartFile, savePath,showPath);
        return ResultApi.success("成功生成图片", fileName);
    }


}
