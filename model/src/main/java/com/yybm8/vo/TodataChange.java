package com.yybm8.vo;

import lombok.Data;

@Data
public class TodataChange {
    private Integer student_id;
    private Integer  class_id;
    private Integer student_out;
    private Integer student_mani;
    private String student_username;
    private String student_password;
     private Integer student_mode;

    private Integer todata_id;
    private String todata_name;
    private Integer commit_id;
    private String todata_gainian;
    private Integer todata_over;
    private Integer todata_zongjie;
    private String todata_guina;
    private String todata_miss;
}
