package ben.study.web.controller;

import ben.study.bto.FileInfo;
import jdk.internal.util.xml.impl.Input;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.nio.ch.IOUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

@RestController
@RequestMapping("/file")
public class FileController {

    @PostMapping("/upload")
    // the parameter name "file" should match
    public FileInfo upload(MultipartFile file) throws IOException {


        String path = "/Users/bhuang";
        String extension = StringUtils.stripFilenameExtension(file.getOriginalFilename());
        File localFile = new File(path, new Date().getTime() + "." + extension);
        file.transferTo(localFile);

        return new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/down  load")
    // the parameter name "file" should match
    public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filePath ="";

        // JDK 1.8
        try(InputStream inputStream = new FileInputStream(filePath);
            OutputStream outputStream = response.getOutputStream();){
            response.setContentType("application/x-download");
            response.addHeader("Count-Disposition", "attachment;filename=test.txt");

            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
        }
    }
}
