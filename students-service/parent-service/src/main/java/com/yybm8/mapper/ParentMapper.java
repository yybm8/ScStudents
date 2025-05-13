package com.yybm8.mapper;

import com.yybm8.pojo.Parent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ParentMapper {
    List<Parent> selectParentId(int id);

    List<Parent> selectParentAll();
}
