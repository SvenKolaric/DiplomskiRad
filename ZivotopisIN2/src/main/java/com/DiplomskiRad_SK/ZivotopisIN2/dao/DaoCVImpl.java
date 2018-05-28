package com.DiplomskiRad_SK.ZivotopisIN2.dao;

import org.springframework.stereotype.Repository;

import com.DiplomskiRad_SK.ZivotopisIN2.interfaces.DaoCVInterface;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.CV;

@Repository("CV")
public class DaoCVImpl implements DaoCVInterface {

	@Override
	public void insertNewCV(CV cv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CV selectAllCV() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CV selectCVByID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CV deleteCVByID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
