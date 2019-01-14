package spider.enumeration;

/**
 * ���з���ö��
 * @author	ws
 *
 */
public enum MusicRankTypeEnum {
	HOT("�ȸ�", 1),
	NEW("�¸�", 2),
	;

	private String name;
	
	private int id;
	
	private MusicRankTypeEnum(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
	
}
