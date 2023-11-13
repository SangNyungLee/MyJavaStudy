package controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FileController {
    @GetMapping("/")
    public String index(Model model){
        return "index";
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file")MultipartFile file, Model model){
        if(!file.isEmpty()){
            try {
                byte[] bytes = file.getBytes();

                model.addAttribute("message", "파일업로드 성공");
            } catch (IOException e){
                e.printStackTrace();
                model.addAttribute("message", "파일 업로드 실패");
            }
        }else{
            model.addAttribute("message", "파일업로드를 해주세요");
        }
        return "index";
    }

    @GetMapping("/download")
    public void handleFileDownload(Model model){
        System.out.println("모델?" + model);
    }
}
