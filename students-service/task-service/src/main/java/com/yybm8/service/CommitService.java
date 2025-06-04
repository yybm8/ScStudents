package com.yybm8.service;

import com.yybm8.vo.Result;

public interface CommitService {
    Result commitAll(int id);

    Boolean updatatodatafile(int todataId, String filePath);
}
