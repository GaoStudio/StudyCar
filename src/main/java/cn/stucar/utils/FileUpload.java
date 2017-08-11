package cn.stucar.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2017/8/10.
 */
public class FileUpload {
    //文件上传
    public static String uploadImage(MultipartFile file, String fileName,String savePath) throws IOException {
        //获得文件类型（可以判断如果不是图片，禁止上传）
        String contentType = file.getContentType();
        //获得文件后缀名称
        String imageName = contentType.substring(contentType.indexOf("/") + 1);
        fileName = fileName+"."+imageName;
        File tempFile = new File(savePath, fileName);
        if (!tempFile.getParentFile().exists()) {
            tempFile.getParentFile().mkdir();
        }
        if (!tempFile.exists()) {
            tempFile.createNewFile();
        }
        file.transferTo(tempFile);
        return tempFile.getName();
    }
    public static String uploadImage(MultipartFile file, String savePath) throws IOException {
        File tempFile = new File(savePath);

        if (!tempFile.getParentFile().exists()) {
            tempFile.getParentFile().mkdir();
        }
        if (!tempFile.exists()) {
            tempFile.createNewFile();
        }
        file.transferTo(tempFile);
        return tempFile.getName();
    }
}
