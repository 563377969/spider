package spider.core;

import java.util.HashMap;
import java.util.Map;

import spider.enumeration.MusicPlatformEnum;

/**
 * 音乐爬取器工厂
 * @author	ws
 *
 */
public class MusicCrawlerFactory {
	
	/*
	 * 音乐爬取器Map
	 */
	private static Map<MusicPlatformEnum, MusicCrawler> musicCrawlerMap = new HashMap<MusicPlatformEnum, MusicCrawler>();
	
	static {
		musicCrawlerMap.put(MusicPlatformEnum.QQMUSIC, new QQMusicCrawler());
		musicCrawlerMap.put(MusicPlatformEnum.XIAMIMUSIC, new XiaMiMusicCrawler());
	}
	
	/**
	 * 获取音乐爬取器
	 * @param musicPlatformEnum 音乐平台
	 * @return
	 */
	public static MusicCrawler getMusicCrawler(MusicPlatformEnum musicPlatformEnum) {
		return musicCrawlerMap.get(musicPlatformEnum);
	}
}
