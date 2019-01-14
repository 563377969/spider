package spider.enumeration;

/**
 * 排行分类枚举
 * @author	ws
 *
 */
public enum MusicRankTypeEnum {
	HOT("热歌", 1),
	NEW("新歌", 2),
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
