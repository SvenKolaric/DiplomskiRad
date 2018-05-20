package interfaces;

import modelDB.CV;

public interface DaoCVInterface {

	void insertNewCV(CV cv);

	CV selectAllCV();

	CV selectCVByID(Integer id);

	CV deleteCVByID(Integer id);
}
