package modelDB;

public class Dodatak {
	private final Integer ID;
	private final String metadata;
	private final String text;
	private final Integer idCV;
	
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
