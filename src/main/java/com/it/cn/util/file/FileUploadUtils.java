package com.it.cn.util.file;

import com.alibaba.fastjson.JSONArray;
import com.it.cn.config.UploadProperties;
import com.it.cn.entity.Upload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/upload")
public class FileUploadUtils {

    @Resource
    private UploadProperties uploadProperties;

    /**
     * 文档的上传
     */
    @RequestMapping(value = "/file", method = RequestMethod.POST)
    @ResponseBody
    public Object file(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException{
        Upload upload = new Upload();
        if (!file.isEmpty()){
            //得到文件的名称
            String fileName = file.getOriginalFilename();
            //文件的路径
            String pathname = "";
            //获得文件的类型  根据文件类型创建文件夹
            String fileType = file.getContentType().split("/")[0];
            fileType = "image,audio,video".contains(fileType) ? fileType : "file";
            String rootPath = uploadProperties.getFileUploadPath();
            //获得完整的文件夹
            Date dt = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
            String descDirNames = "/"+"userfiles" + "/" + fileType + "/" + df.format(dt);

            //在项目中存放文件
            File directory = new File("");// 参数为空
            String courseFile = directory.getCanonicalPath();
            String path= courseFile +"/src/main/webapp/static/uploadFile/";
            //新建 uploadFile 文件夹
            FileUtil.createDirectory(path);
            this.FileInputStream(file.getInputStream(),path+"/"+fileName);

            //创建目录
            FileUtil.createDirectory(rootPath + descDirNames);
            //文件存在的地址
            pathname = rootPath + descDirNames + "/" + fileName;
            //保存文件
            this.FileInputStream(file.getInputStream(), pathname);
            upload.setFileType(fileType);
            upload.setFileName(fileName);
            upload.setCode(0);
            upload.setMsg("文件上传成功了");
            upload.setFilePath("/uploadFile/"+ fileName);
            upload.setSize(file.getSize());
            return JSONArray.toJSON(upload);
        }else {
            upload.setCode(1);
            upload.setMsg("文件出现问题，请检查文件后发送");
            return JSONArray.toJSON(upload);
        }
    }

    /**
     * 文件保存
     *
     * @param stream
     * @param filePath
     *
     */
    public void FileInputStream(InputStream stream, String filePath){
        //判断路径是否存在
        File file=new File(filePath);
        if (file.exists()) {
            FileUtil.deleteFile(filePath);
        }
        FileOutputStream fs = null;
        try{
            fs = new FileOutputStream(filePath);
            byte[] buffer = new byte[8192];
            int byteRead;
            while ((byteRead = stream.read(buffer)) != -1) {
                fs.write(buffer, 0, byteRead);
            }
        }catch (IOException e){
            throw new RuntimeException("创建文件失败");
        }finally {
            try {
                if (fs != null) {
                    fs.flush();
                    fs.close();
                }
            }catch (IOException e){
                throw new RuntimeException("关闭失败");
            }
            try {
                if (stream != null) {
                    stream.close();
                }
            }catch (IOException e){
                throw new RuntimeException("关闭失败");
            }
        }
    }
}
