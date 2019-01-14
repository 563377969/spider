package spider.entity;

import spider.enumeration.MusicPlatformEnum;
import spider.enumeration.MusicRankTypeEnum;

/**
 * ����ʵ��
 * @author	ws
 *
 */
public class MusicEntity {
	
	/*
	 * ��������
	 */
	private String name;
	/*
	 * ����
	 */
	private String singer;
	/*
	 * ʱ��
	 */
	private int duration;
	/*
	 * ����
	 */
	private int rank;
	
	/*
	 * ����ƽ̨
	 */
	private MusicPlatformEnum platform;
	
	/*
	 * ���з���
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
