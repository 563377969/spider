package spider.enumeration;

/**
 * ����ƽ̨ö��
 * @author	ws
 *
 */
public enum MusicPlatformEnum {
	
	XIAMIMUSIC("Ϻ������", 1),
	QQMUSIC("qq����", 2),
	;

	private String name;
	
	private int id;
	
	private MusicPlatformEnum(String name, int id) {
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
