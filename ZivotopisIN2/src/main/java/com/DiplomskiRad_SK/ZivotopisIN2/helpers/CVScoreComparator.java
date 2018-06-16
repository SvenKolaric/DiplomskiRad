package com.DiplomskiRad_SK.ZivotopisIN2.helpers;

import java.util.Comparator;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.CV;

public class CVScoreComparator implements Comparator<CV> {
	
	public int compare(CV cv1, CV cv2) {
		return cv1.getScore().compareTo(cv2.getScore());
	}

}
