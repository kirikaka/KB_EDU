package org.scoula.dao;

import org.scoula.vo.DiaryVO;

import java.util.List;

public interface DiaryDao {
    void createDiary(DiaryVO diaryVO);
    void deleteDiary(DiaryVO diaryVO);
    void updateDiary(DiaryVO diaryVO);

    List<DiaryVO> readDiary();

}
