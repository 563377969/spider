package spider.core;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import spider.entity.MusicEntity;
import spider.enumeration.MusicRankTypeEnum;
import spider.util.MusicEtityUtils;

/**
 * 音乐爬取器
 * @author	ws
 *
 */
public abstract class MusicCrawler {
	
	private static Logger log = Logger.getLogger(MusicCrawler.class);

	/**
	 * 获取页数
	 * @param rankTypeEnum 排行分类
	 * @return
	 */
	public abstract int getPageLength(MusicRankTypeEnum rankTypeEnum);
	
	/**
	 * 下载音乐实体
	 * @param rankTypeEnum 排行分类
	 * @param page 当前页
	 * @return
	 */
	public abstract List<MusicEntity> crawling(MusicRankTypeEnum rankTypeEnum, int page);
	
	/**
	 * 通用下载页面
	 * @param url
	 * @return
	 */
	public Document crawling(String url) {
		Document document = null;  
        try {  
        	document = Jsoup.connect(url).timeout(4000).userAgent("Mozilla").get();  
        } catch (IOException e) {  
        	log.error("Jsoup.connect error!", e);
        }  
        return document;
	}
	
	/**
	 * 处理爬取内容
	 * @param rankTypeEnum
	 */
	public void process(MusicRankTypeEnum rankTypeEnum) {
		int pageLength = getPageLength(rankTypeEnum);
		for(int i = 1; i <= pageLength; i++) {
			MusicEtityUtils.procrssMusicEntity(crawling(rankTypeEnum, i));
		}
	}
	
}
