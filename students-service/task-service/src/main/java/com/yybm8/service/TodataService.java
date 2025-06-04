package com.yybm8.service;

import com.yybm8.vo.Result;

public interface TodataService {
    Result todataAll(int id);

    Result todataCName(int id);

    Result todataCAll(int id);

    Result todataId( int todataId);

    Result selectTodataAll(Integer id,String username,String commit_name,Integer todata_zongjie,Integer todata_over,Integer page,Integer pageSize);

    Result selectAddTeacherAll();
}
