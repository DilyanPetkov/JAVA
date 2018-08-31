package com.theoryx.test.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.theoryx.test.dao.MarkDao;
import com.theoryx.test.model.Mark;

public class MarkServiceImpl implements MarkService{
	@Autowired
	MarkDao markDao;
	@Override
	public void inputMark(Mark mark) {
		markDao.inputMark(mark);
		
	}
	@Override
	public void updateMark(Mark mark) {
		markDao.updateMark(mark);
		
	}
	@Override
	public void deleteMark(Mark mark) {
		markDao.deleteMark(mark);
		
	}

}
