package com.amateur.wanbei.service.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

@Component
@Slf4j
public class FileComponent {


    /**
     * 保存文件，直接以multipartFile形式
     * @param multipartFile
     * @param filePath 文件保存绝对路径
     * @return 返回文件名
     * @throws IOException
     */
    public static String saveFile(MultipartFile multipartFile,String filePath,String showPath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        String fileName = UUID.randomUUID() + ".jpg";
        String savePath = filePath + File.separator + fileName;
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(savePath));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return showPath+fileName;
    }

}
