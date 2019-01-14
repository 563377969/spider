package spider.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import spider.entity.MusicEntity;
import spider.enumeration.MusicPlatformEnum;
import spider.enumeration.MusicRankTypeEnum;
import spider.util.CommonUtils;
import spider.util.MusicProperties;

/**
 * QQ音乐爬取器
 * @author	ws
 *
 */
public class QQMusicCrawler extends MusicCrawler {
	
	private static Logger log = Logger.getLogger(QQMusicCrawler.class);
	
	/**
	 * 使用htmlunit下载、加载qq音乐网页内容
	 * @param url
	 * @param page
	 * @return
	 */
	public Document crawling(String url, int page) {
		@SuppressWarnings("resource")
		WebClient webClient = new WebClient(BrowserVersion.CHROME);
		webClient.getOptions().setJavaScriptEnabled(true);
		webClient.getOptions().setCssEnabled(true);
		webClient.getOptions().setRedirectEnabled(true);
		webClient.setAjaxController(new NicelyResynchronizingAjaxController());
		webClient.getOptions().setTimeout(10000);
		webClient.waitForBackgroundJavaScript(3000);
		Document document = null;
		HtmlPage  htmlPage = null;
        try {  
        	htmlPage = webClient.getPage(url);
        	try {
        		//sleep等待js内容加载
				Thread.sleep(10000);
			} catch (InterruptedException e) {
			}
        	if(page > 1) {
        		List<HtmlAnchor> pages = htmlPage.getByXPath("//div[@class='mod_page_nav js_pager']/a");
        		if(!CollectionUtils.isEmpty(pages) && pages.size() >= page-1) {
        			//模拟click事件获取下一页音乐列表
        			HtmlAnchor htmlAnchor = pages.get(page-2);
        			htmlPage = htmlAnchor.click();
        			try {
        				Thread.sleep(5000);
        			} catch (InterruptedException e) {
        			}
        		}
        	}
        	if(htmlPage == null) {
        		return document;
        	}
        	String html = htmlPage.asXml();
        	document = Jsoup.parse(html);
        } catch (IOException e) {  
        	log.error("crawling error!", e);
        }  
        return document;
	}

	@Override
	public List<MusicEntity> crawling(MusicRankTypeEnum rankTypeEnum, int page) {
		Document document = crawling(MusicProperties.getUrl(MusicPlatformEnum.QQMUSIC, rankTypeEnum), page);
		if(document == null) {
			return Collections.emptyList();
		}
		Elements elements = document.select("div.mod_songlist > ul.songlist__list > li");
		if(CollectionUtils.isEmpty(elements)) {
			return Collections.emptyList();
		}
		
		List<MusicEntity> musicEntities = new ArrayList<MusicEntity>();
		for(Element element : elements) {
			String songNum = element.select("div.songlist__number").text();
			String songName = element.select("div.songlist__item > div.songlist__songname > span.songlist__songname_txt > a.js_song").attr("title");
			String singer = element.select("div.songlist__artist").attr("title");
			String duration = element.select("div.songlist__time").text();
			MusicEntity musicEntity = new MusicEntity();
			musicEntity.setPlatform(MusicPlatformEnum.QQMUSIC);
			musicEntity.setRankType(rankTypeEnum);
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
		
		return MusicProperties.getPagelength(MusicPlatformEnum.QQMUSIC, rankTypeEnum);
	}

}
