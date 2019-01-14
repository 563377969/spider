package spider.enumeration;

/**
 * “Ù¿÷∆ΩÃ®√∂æŸ
 * @author	ws
 *
 */
public enum MusicPlatformEnum {
	
	XIAMIMUSIC("œ∫√◊“Ù¿÷", 1),
	QQMUSIC("qq“Ù¿÷", 2),
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
