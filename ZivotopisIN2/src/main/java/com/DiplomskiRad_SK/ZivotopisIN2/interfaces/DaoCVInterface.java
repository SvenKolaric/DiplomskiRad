package com.DiplomskiRad_SK.ZivotopisIN2.interfaces;

import java.util.List;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.CV;

public interface DaoCVInterface {

	void createNewCV(CV cv);

	List<CV> selectAllCV();

	CV selectCVByID(Integer id);

	CV deleteCVByID(Integer id);
}
