package com.yybm8.dto;

import com.yybm8.pojo.Commit;
import com.yybm8.pojo.Students;
import lombok.Data;

import java.util.List;

@Data
public class StudentCommit {
    private List<Students> students;
    private List<Commit> commit;


}
