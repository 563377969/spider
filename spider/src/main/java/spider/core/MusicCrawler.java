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
 * ������ȡ��
 * @author	ws
 *
 */
public abstract class MusicCrawler {
	
	private static Logger log = Logger.getLogger(MusicCrawler.class);

	/**
	 * ��ȡҳ��
	 * @param rankTypeEnum ���з���
	 * @return
	 */
	public abstract int getPageLength(MusicRankTypeEnum rankTypeEnum);
	
	/**
	 * ��������ʵ��
	 * @param rankTypeEnum ���з���
	 * @param page ��ǰҳ
	 * @return
	 */
	public abstract List<MusicEntity> crawling(MusicRankTypeEnum rankTypeEnum, int page);
	
	/**
	 * ͨ������ҳ��
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
	 * ������ȡ����
	 * @param rankTypeEnum
	 */
	public void process(MusicRankTypeEnum rankTypeEnum) {
		int pageLength = getPageLength(rankTypeEnum);
		for(int i = 1; i <= pageLength; i++) {
			MusicEtityUtils.procrssMusicEntity(crawling(rankTypeEnum, i));
		}
	}
	
}
