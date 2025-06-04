package com.yybm8.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.io.FileUtil;
import com.yybm8.dto.StudentCommit;
import com.yybm8.feign.LoginFeign;
import com.yybm8.service.CommitService;
import com.yybm8.vo.Result;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/task/commit")
public class CommitController {
    private static final String PATH = System.getProperty("user.dir")+File.separator+"file"+ File.separator;//文件
    @Autowired
    private CommitService commitService;

    @Qualifier("com.yybm8.feign.LoginFeign")
    @Autowired
    private LoginFeign loginFeign;

    //查询进度接口
    @PostMapping("/commit")
    public Result commitName(){
        Result result = loginFeign.loginId();
        if(result.getCode().equals("4005")){
            int id=(int)result.getData();
            return commitService.commitAll(id);
        }
        else{
            return Result.noLogin();
        }
    }

    @PostMapping("/updatatodataafile")
    public Result updatatodataafile(MultipartFile file , @RequestParam int todata_id) throws IOException {
        String FileName = file.getOriginalFilename(); //获取前端传输的文件名
        String FileNameUUID = UUID.randomUUID()+"."+ FileUtil.extName(FileName);//文件名.之前的数据添加UUID
        String workingDir = System.getProperty("user.dir");//获取当前后端地址
        file.transferTo(new File(workingDir+"\\file"+"\\" + FileNameUUID));//将文件放到本地文件夹
        String filePath = "http://localhost:80/api/task/commit/todatafile/" + FileNameUUID;//返回路径
        commitService.updatatodatafile(todata_id,filePath);
        return Result.success(filePath);
    }
    @GetMapping("/todatafile/{fileName}")
    public void down(@PathVariable String fileName, HttpServletResponse response) throws IOException {
        String filePath = PATH + fileName;
        if(!FileUtil.exist(filePath)){
            return;//如果文件路劲不存在关闭
        }
        byte[] bytes=FileUtil.readBytes(filePath);//hutool中读取文件且转换为byte
        ServletOutputStream servletOutputStream = response.getOutputStream();//获取浏览器输出流
        servletOutputStream.write(bytes);//输出到浏览器
        servletOutputStream.flush();//关闭浏览器输出流
        servletOutputStream.close();//关闭文件输出流
    }

}
