package bl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import interfaces.DaoCVInterface;
import modelDB.CV;
import modelDB.EdukacijaITrening;

@Service("BLCV")
public class BLCV {
	private final DaoCVInterface daoCV;
	
	@Autowired
	public BLCV(@Qualifier("CV") DaoCVInterface daoCVInterface) {
		this.daoCV = daoCVInterface;
	}

	public void insertNewCV(CV cv) {
		daoCV.insertNewCV(cv);
		
		/*CV cv1 = new CV();
		Iterable<EdukacijaITrening> a = cv1.getEdukacijaITreningList();
		ArrayList<CV> b = new ArrayList<CV>();
		EdukacijaITrening[] c = (EdukacijaITrening[]) ((Collection<CV>) a).toArray(new EdukacijaITrening[a.size()])*/
	}

	public CV getAllCV() {
		return null;

	}

	public CV getCVByID(Integer id) {
		return null;

	}

	public CV deleteCVByID(Integer id) {
		return null;

	}

}
