package com.DiplomskiRad_SK.ZivotopisIN2.interfaces;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.CV;

public interface DaoCVInterface {

	void insertNewCV(CV cv);

	CV selectAllCV();

	CV selectCVByID(Integer id);

	CV deleteCVByID(Integer id);
}
