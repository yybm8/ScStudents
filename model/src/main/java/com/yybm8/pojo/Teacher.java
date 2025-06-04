package com.yybm8.pojo;

import lombok.Data;

@Data
public class Teacher {
    private Integer commit_id;
    private Integer todata_id;
    private Integer student_id;
    private String student_username;
    private String commit_name;
    private String todata_name;
    private String todata_gainian;
    private Integer todata_over;
    private Integer todata_zongjie;
    private String todata_guina;
    private String todata_miss;
}
