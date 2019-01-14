package spider.core;

import spider.enumeration.MusicPlatformEnum;
import spider.enumeration.MusicRankTypeEnum;

/**
 * “Ù¿÷≈¿»°»Îø⁄
 * @author	ws
 *
 */
public class MusicCrawlerTask {

	public static void main(String[] args) {
		for(MusicPlatformEnum musicPlatformEnum : MusicPlatformEnum.values()) {
			MusicCrawler musicCrawler = MusicCrawlerFactory.getMusicCrawler(musicPlatformEnum);
			for(MusicRankTypeEnum musicRankTypeEnum : MusicRankTypeEnum.values()) {
				musicCrawler.process(musicRankTypeEnum);
			}
		}
	}

}
