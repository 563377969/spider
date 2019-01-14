package spider.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSON;

import spider.entity.MusicEntity;
import spider.enumeration.MusicPlatformEnum;
import spider.enumeration.MusicRankTypeEnum;
import spider.util.CommonUtils;
import spider.util.MusicProperties;

/**
 * œ∫√◊“Ù¿÷≈¿»°∆˜
 * @author	ws
 *
 */
public class XiaMiMusicCrawler extends MusicCrawler {
	
	private static Logger log = Logger.getLogger(XiaMiMusicCrawler.class);

	@Override
	public List<MusicEntity> crawling(MusicRankTypeEnum rankTypeEnum, int page) {
		Document document = crawling(MusicProperties.getUrl(MusicPlatformEnum.XIAMIMUSIC, rankTypeEnum));
		if(document == null) {
			return Collections.emptyList();
		}
		Elements elements = document.select("div.song-table > table > tbody > tr");
		if(CollectionUtils.isEmpty(elements)) {
			return Collections.emptyList();
		}
		
		List<MusicEntity> musicEntities = new ArrayList<MusicEntity>();
		for(Element element : elements) {
			String songNum = element.select("span.index").text();
			String songName = element.select("div.song-name> a").text();
			String singer = element.select("div.singers > a").text();
			String duration = element.select("span.duration").text();
			MusicEntity musicEntity = new MusicEntity();
			musicEntity.setPlatform(MusicPlatformEnum.XIAMIMUSIC);
			musicEntity.setRank(CommonUtils.stringToInteger(songNum));
			musicEntity.setName(songName);
			musicEntity.setSinger(singer);
			musicEntity.setDuration(CommonUtils.durationToSeconds(duration));
			musicEntities.add(musicEntity);
			log.info(JSON.toJSONString(musicEntity));
		}
		return musicEntities;
	}

	@Override
	public int getPageLength(MusicRankTypeEnum rankTypeEnum) {
		
		return MusicProperties.getPagelength(MusicPlatformEnum.XIAMIMUSIC, rankTypeEnum);
	}

}
