package spider.entity;

import spider.enumeration.MusicPlatformEnum;
import spider.enumeration.MusicRankTypeEnum;

/**
 * 音乐实体
 * @author	ws
 *
 */
public class MusicEntity {
	
	/*
	 * 音乐名称
	 */
	private String name;
	/*
	 * 歌手
	 */
	private String singer;
	/*
	 * 时长
	 */
	private int duration;
	/*
	 * 排名
	 */
	private int rank;
	
	/*
	 * 音乐平台
	 */
	private MusicPlatformEnum platform;
	
	/*
	 * 排行分类
	 */
	private MusicRankTypeEnum rankType;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public MusicPlatformEnum getPlatform() {
		return platform;
	}

	public void setPlatform(MusicPlatformEnum platform) {
		this.platform = platform;
	}

	public MusicRankTypeEnum getRankType() {
		return rankType;
	}

	public void setRankType(MusicRankTypeEnum rankType) {
		this.rankType = rankType;
	}
		
}
