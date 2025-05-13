package com.yybm8.vo;

import lombok.Data;

@Data
public class CommitChange {
    private Integer student_id;
    private Integer  class_id;
    private Integer student_out;
    private Integer student_mani;
    private String student_username;
    private String student_password;

    private Integer commit_id;
    private String commit_name;
    private String commit_over;
}
