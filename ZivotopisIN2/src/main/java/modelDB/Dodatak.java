package modelDB;

public class Dodatak {
	private Integer ID;
	private String metadata;
	private String text;
	private Integer idCV;
	
	public Dodatak() {
	}

	public Dodatak(Integer iD, String metadata, String text, Integer idCV) {
		ID = iD;
		this.metadata = metadata;
		this.text = text;
		this.idCV = idCV;
	}
	
	public Integer getID() {
		return ID;
	}
	public String getMetadata() {
		return metadata;
	}
	public String getText() {
		return text;
	}
	public Integer getIdCV() {
		return idCV;
	}
	
}
