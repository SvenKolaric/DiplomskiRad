package com.DiplomskiRad_SK.ZivotopisIN2.bl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.DiplomskiRad_SK.ZivotopisIN2.interfaces.DaoCVInterface;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.CV;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.EdukacijaITrening;

@Service("BLCV")
@ComponentScan("interfaces")
public class BLCV {
	private final DaoCVInterface daoCV;
	
	@Autowired
	public BLCV(@Qualifier("CV") DaoCVInterface daoCVInterface) {
		this.daoCV = daoCVInterface;
	}

	public void SaveCV(CV cv) {
		daoCV.createNewCV(cv);
		
		/*CV cv1 = new CV();
		Iterable<EdukacijaITrening> a = cv1.getEdukacijaITreningList();
		ArrayList<CV> b = new ArrayList<CV>();
		EdukacijaITrening[] c = (EdukacijaITrening[]) ((Collection<CV>) a).toArray(new EdukacijaITrening[a.size()])*/
	}

	public List<CV> getAllCV() {
		return daoCV.selectAllCV();

	}

	public CV getCVByID(Integer id) {
		return null;

	}

	public CV deleteCVByID(Integer id) {
		return null;

	}

}
