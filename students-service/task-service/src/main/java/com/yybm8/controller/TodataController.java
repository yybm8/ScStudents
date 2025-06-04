package com.yybm8.controller;


import com.yybm8.feign.LoginFeign;
import com.yybm8.pojo.Teacher;
import com.yybm8.service.TodataService;
import com.yybm8.vo.Result;
import com.yybm8.vo.TeacherVo;
import com.yybm8.vo.TodataOver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/task/todata")
public class TodataController {
    @Autowired
    private TodataService todataService;
    @Qualifier("com.yybm8.feign.LoginFeign")
    @Autowired
    private LoginFeign loginFeign;
    //查询登录学生每日任务
    @PostMapping("/todataAll")
    public Result todataAll(){
        Result result = loginFeign.loginId();
        if(result.getCode().equals("4005")){
            int id=(int)result.getData();
            return todataService.todataAll(id);
        }
        else{
            return Result.noLogin();
        }
    }
    //根据当前登录情况初略展示学习情况
    @PostMapping("/todataCName")
    public Result todataCName(){
        Result result = loginFeign.loginId();
        System.out.println(result);
        if(result.getCode().equals("4005")){
            int id=(int)result.getData();
            return todataService.todataCName(id);
        }
        else{
            return Result.noLogin();
        }
    }
    //根据当前登录情况展示题目情况
    @PostMapping("/todataCAll")
    public Result todataCAll(){
        Result result = loginFeign.loginId();
        if(result.getCode().equals("4005")){
            int id=(int)result.getData();
            return todataService.todataCAll(id);
        }
        else{
            return Result.noLogin();
        }
    }
    //将todata_over写为1
     @PostMapping("/todataId")
     public Result todataId(@RequestBody TodataOver  todata_over){
         int todata_id=todata_over.getTodata_id();
         Result result = loginFeign.loginId();
         if(result.getCode().equals("4005")){
             int id=(int)result.getData();
             return todataService.todataId(todata_id);
         }
         else{
             return Result.noLogin();
         }
     }
     //分页查询全部学生及其题目
    @PostMapping("/selectTodataAll")
    public Result selectTodataAll(@RequestBody TeacherVo teacherVo){
        Integer id=teacherVo.getStudent_id();
        String  username=teacherVo.getUsername();
        String commit_name =teacherVo.getCommit_name();
        Integer todata_zongjie=teacherVo.getTodata_zongjie();
        Integer todata_over=teacherVo.getTodata_over();
        Integer  page=teacherVo.getPage();
         Integer pageSize=teacherVo.getPageSize();
         if(page==null){
             page=1;
         }
          if(pageSize==null){
             pageSize=5;
         }
          System.out.println(id+" "+username+" "+commit_name+" "+todata_zongjie+" "+todata_over+" "+page+" "+pageSize);
        return todataService.selectTodataAll(id,username, commit_name,todata_zongjie,todata_over,page,pageSize);
    }

    //分页查询全部学生和课程
    @PostMapping("/selectAddTeacherAll")
    public Result selectAddTeacherAll(@RequestBody TeacherVo teacherVo){
        return todataService.selectAddTeacherAll();
    }

}
