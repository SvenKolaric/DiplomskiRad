package com.DiplomskiRad_SK.ZivotopisIN2.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.DiplomskiRad_SK.ZivotopisIN2.interfaces.DaoCVInterface;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.CV;

@Repository("CV")
public class DaoCVImpl implements DaoCVInterface {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public void createNewCV(CV cv) {
		String sql = "Insert into CV (TIPDOKUMENTA,DATUMSTVARANJA,DATUMAZURIRANJA,IDOSOBA) values ( ?, ?, ?, ?)";
		jdbcTemplate.update(sql, cv.getTipDokumenta(), cv.getDatumStvaranja(), cv.getDatumAzuriranja(), cv.getIdOsoba());
		
	}

	@Override
	public List<CV> selectAllCV() {
		List<CV> result = jdbcTemplate.query(
                "SELECT zivotopisid, tipdokumenta, datumstvaranja, datumazuriranja, idosoba FROM cv",
                (rs, rowNum) -> new CV(rs.getInt("zivotopisid"),
                        rs.getString("tipdokumenta"), rs.getTimestamp("datumstvaranja"), 
                        rs.getTimestamp("datumazuriranja"), rs.getInt("idosoba"))
        );
		return result;
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
