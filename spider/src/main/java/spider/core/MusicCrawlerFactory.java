package spider.core;

import java.util.HashMap;
import java.util.Map;

import spider.enumeration.MusicPlatformEnum;

/**
 * ������ȡ������
 * @author	ws
 *
 */
public class MusicCrawlerFactory {
	
	/*
	 * ������ȡ��Map
	 */
	private static Map<MusicPlatformEnum, MusicCrawler> musicCrawlerMap = new HashMap<MusicPlatformEnum, MusicCrawler>();
	
	static {
		musicCrawlerMap.put(MusicPlatformEnum.QQMUSIC, new QQMusicCrawler());
		musicCrawlerMap.put(MusicPlatformEnum.XIAMIMUSIC, new XiaMiMusicCrawler());
	}
	
	/**
	 * ��ȡ������ȡ��
	 * @param musicPlatformEnum ����ƽ̨
	 * @return
	 */
	public static MusicCrawler getMusicCrawler(MusicPlatformEnum musicPlatformEnum) {
		return musicCrawlerMap.get(musicPlatformEnum);
	}
}
