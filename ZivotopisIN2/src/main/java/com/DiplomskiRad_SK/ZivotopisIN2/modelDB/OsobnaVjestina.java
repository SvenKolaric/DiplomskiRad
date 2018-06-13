package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "OSOBNA_VJESTINA")
public class OsobnaVjestina {
	@Id
	@GeneratedValue(generator = "OVSeq")
	@SequenceGenerator(name = "OVSeq", sequenceName = "OSOBNA_VJESTINA_SEQ", allocationSize = 1)
	private Integer vjestinaID;
	@Column(name = "OBRADAINFORMACIJA")
	private String obradaInfo;
	@Column(name = "KOMUNIKACIJA")
	private String komunikacija;
	@Column(name = "STVARANJESADRZAJA")
	private String stvaranjeSadrzaja;
	@Column(name = "SIGURNOST")
	private String sigurnost;
	@Column(name = "RJESAVANJEPROBLEMA")
	private String rjesavanjeProblema;
	@Column(name = "MATERINJIJEZIK")
	private String materinjiJezik;
	@Column(name = "KOMUNIKACIJSKEVJ")
	private String komunikacijskeVj;
	@Column(name = "ORGANIZACIJSKEVJ")
	private String organizacijskeVj;
	@Column(name = "POSLOVNEVJ")
	private String poslovneVj;
	@Column(name = "OSTALEVJ")
	private String ostaleVj;
	@Column(name = "RACUNALNEVJ")
	private String racunalneVJ;
	
	@OneToMany(mappedBy = "osobnaVJ", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Zna> znaList = new ArrayList<>();
	@OneToMany(mappedBy = "osobnaVJ", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<VozackaOsobnaVJ> vozackaDozvolaOsVJList = new ArrayList<>();
	//@OneToMany(mappedBy = "osobnaVJ", cascade = CascadeType.ALL, orphanRemoval = true)
	//private ArrayList<CertifikatDiploma> certifikatDiplomaList;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "IDCV", nullable = false)
	private CV zivotopis;
	
	public OsobnaVjestina() {
	}

	public OsobnaVjestina(Integer vjestinaID, String obradaInfo, String komunikacija, String stvaranjeSadrzaja,
			String sigurnost, String rjesavanjeProblema, String materinjiJezik, String komunikacijskeVj,
			String organizacijskeVj, String poslovneVj, String ostaleVj, String racunalneVJ) {
		this.vjestinaID = vjestinaID;
		this.obradaInfo = obradaInfo;
		this.komunikacija = komunikacija;
		this.stvaranjeSadrzaja = stvaranjeSadrzaja;
		this.sigurnost = sigurnost;
		this.rjesavanjeProblema = rjesavanjeProblema;
		this.materinjiJezik = materinjiJezik;
		this.komunikacijskeVj = komunikacijskeVj;
		this.organizacijskeVj = organizacijskeVj;
		this.poslovneVj = poslovneVj;
		this.ostaleVj = ostaleVj;
		this.racunalneVJ = racunalneVJ;
	}

	/*synchronize both sides of the bidirectional association*/
	public void addZna(Zna obj) {
		znaList.add(obj);
        obj.setOsobnaVJ(this);
    }
 
    public void removeZna(Zna obj) {
    	znaList.remove(obj);
        obj.setOsobnaVJ(null);
    }
    
	public void addVozackaOsobnaVJ(VozackaOsobnaVJ obj) {
		vozackaDozvolaOsVJList.add(obj);
        obj.setOsobnaVJ(this);
    }
 
    public void removeVozackaOsobnaVJ(VozackaOsobnaVJ obj) {
    	vozackaDozvolaOsVJList.remove(obj);
        obj.setOsobnaVJ(null);
    }
    
	public List<Zna> getZnaList() {
		return znaList;
	}

	public List<VozackaOsobnaVJ> getVozackaDozvolaOsVJList() {
		return vozackaDozvolaOsVJList;
	}

	public Integer getVjestinaID() {
		return vjestinaID;
	}

	public String getObradaInfo() {
		return obradaInfo;
	}

	public String getKomunikacija() {
		return komunikacija;
	}

	public String getStvaranjeSadrzaja() {
		return stvaranjeSadrzaja;
	}

	public String getSigurnost() {
		return sigurnost;
	}

	public String getRjesavanjeProblema() {
		return rjesavanjeProblema;
	}

	public String getMaterinjiJezik() {
		return materinjiJezik;
	}

	public String getKomunikacijskeVj() {
		return komunikacijskeVj;
	}

	public String getOrganizacijskeVj() {
		return organizacijskeVj;
	}

	public String getPoslovneVj() {
		return poslovneVj;
	}

	public String getOstaleVj() {
		return ostaleVj;
	}

	public void setVjestinaID(Integer vjestinaID) {
		this.vjestinaID = vjestinaID;
	}

	public void setObradaInfo(String obradaInfo) {
		this.obradaInfo = obradaInfo;
	}

	public void setKomunikacija(String komunikacija) {
		this.komunikacija = komunikacija;
	}

	public void setStvaranjeSadrzaja(String stvaranjeSadrzaja) {
		this.stvaranjeSadrzaja = stvaranjeSadrzaja;
	}

	public void setSigurnost(String sigurnost) {
		this.sigurnost = sigurnost;
	}

	public void setRjesavanjeProblema(String rjesavanjeProblema) {
		this.rjesavanjeProblema = rjesavanjeProblema;
	}

	public void setMaterinjiJezik(String materinjiJezik) {
		this.materinjiJezik = materinjiJezik;
	}

	public void setKomunikacijskeVj(String komunikacijskeVj) {
		this.komunikacijskeVj = komunikacijskeVj;
	}

	public void setOrganizacijskeVj(String organizacijskeVj) {
		this.organizacijskeVj = organizacijskeVj;
	}

	public void setPoslovneVj(String poslovneVj) {
		this.poslovneVj = poslovneVj;
	}

	public void setOstaleVj(String ostaleVj) {
		this.ostaleVj = ostaleVj;
	}

	public CV getZivotopis() {
		return zivotopis;
	}

	public void setZivotopis(CV zivotopis) {
		this.zivotopis = zivotopis;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
                .append(organizacijskeVj)
                .append(ostaleVj)
                .append(poslovneVj)
                .append(materinjiJezik)
                .append(komunikacijskeVj)
                .toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OsobnaVjestina other = (OsobnaVjestina) obj;
		return new EqualsBuilder()
                .append(organizacijskeVj, other.organizacijskeVj)
                .append(ostaleVj, other.ostaleVj)
                .append(poslovneVj, other.poslovneVj)
                .append(materinjiJezik, other.materinjiJezik)
                .append(komunikacijskeVj, other.komunikacijskeVj)
                .isEquals();
	}

	public String getRacunalneVJ() {
		return racunalneVJ;
	}

	public void setRacunalneVJ(String racunalneVJ) {
		this.racunalneVJ = racunalneVJ;
	}

	public void setZnaList(List<Zna> znaList) {
		for (int count = 0; count < znaList.size(); count++) {
			znaList.get(count).setOsobnaVJ(this);
			this.znaList.add(znaList.get(count));
		}
	}

	public void setVozackaDozvolaOsVJList(List<VozackaOsobnaVJ> vozackaDozvolaOsVJList) {
		for (int count = 0; count < vozackaDozvolaOsVJList.size(); count++) {
			vozackaDozvolaOsVJList.get(count).setOsobnaVJ(this);
			this.vozackaDozvolaOsVJList.add(vozackaDozvolaOsVJList.get(count));
		}
	}

}
