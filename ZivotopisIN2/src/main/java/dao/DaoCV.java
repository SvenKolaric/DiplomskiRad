package dao;

import org.springframework.stereotype.Repository;

import interfaces.DaoCVInterface;
import modelDB.CV;

@Repository("CV")
public class DaoCV implements DaoCVInterface {

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
