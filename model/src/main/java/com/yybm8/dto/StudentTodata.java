package com.yybm8.dto;


import com.yybm8.pojo.Students;
import com.yybm8.pojo.Todata;
import lombok.Data;

import java.util.List;

@Data
public class StudentTodata {
    private Integer StudentTodataId;
    private List<Students> students;
    private List<Todata> todata;
}
