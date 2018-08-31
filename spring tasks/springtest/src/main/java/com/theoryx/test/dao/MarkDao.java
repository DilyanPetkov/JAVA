package com.theoryx.test.dao;

import com.theoryx.test.model.Mark;

public interface MarkDao {
	void inputMark(Mark mark);
	void updateMark(Mark mark);
	void deleteMark(Mark mark);
}
