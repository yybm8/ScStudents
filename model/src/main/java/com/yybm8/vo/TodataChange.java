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

    private Integer todata_id;
    private String todata_name;
    private Integer commit_id;
    private String todata_gainian;
    private Integer todata_over;
    private String todata_zongjie;
    private String todata_guina;
    private Integer todata_miss;
}
