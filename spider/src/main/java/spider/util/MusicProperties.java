package spider.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.apache.log4j.Logger;

import com.google.common.collect.Maps;

import spider.enumeration.MusicPlatformEnum;
import spider.enumeration.MusicRankTypeEnum;

/**
 * 音乐爬取属性配置
 * @author	ws
 *
 */
public class MusicProperties {

	private static Logger log = Logger.getLogger(MusicProperties.class);
			
	/*
	 * 音乐地址Map
	 */
	private static Map<MusicPlatformEnum, Map<MusicRankTypeEnum, String>> musicUrlMap = new HashMap<MusicPlatformEnum, Map<MusicRankTypeEnum,String>>();
	/*
	 * 音乐总页数Map
	 */
	private static Map<MusicPlatformEnum, Map<MusicRankTypeEnum, Integer>> musicPageLengthMap = new HashMap<MusicPlatformEnum, Map<MusicRankTypeEnum,Integer>>();
	
	static {
		try {
			init();
		} catch (Exception e) {
			log.error("MusicProperties init error!", e);
		}
	}
	
	/**
	 * 初始化音乐爬取配置
	 */
	private static void init() {
		musicUrlMap.put(MusicPlatformEnum.QQMUSIC, Maps.newHashMap());
		musicUrlMap.put(MusicPlatformEnum.XIAMIMUSIC, Maps.newHashMap());
		musicPageLengthMap.put(MusicPlatformEnum.QQMUSIC, Maps.newHashMap());
		musicPageLengthMap.put(MusicPlatformEnum.XIAMIMUSIC, Maps.newHashMap());
		
		Map<MusicRankTypeEnum, String> qqRankTypeMap = musicUrlMap.get(MusicPlatformEnum.QQMUSIC);
		qqRankTypeMap.put(MusicRankTypeEnum.HOT, "https://y.qq.com/n/yqq/toplist/26.html#stat=y_new.toplist.menu.26");
		qqRankTypeMap.put(MusicRankTypeEnum.NEW, "https://y.qq.com/n/yqq/toplist/27.html#stat=y_new.toplist.menu.27");
		Map<MusicRankTypeEnum, String> xiamiRankTypeMap = musicUrlMap.get(MusicPlatformEnum.XIAMIMUSIC);
		xiamiRankTypeMap.put(MusicRankTypeEnum.HOT, "https://www.xiami.com/billboard/103");
		xiamiRankTypeMap.put(MusicRankTypeEnum.NEW, "https://www.xiami.com/billboard/102");
		
		Map<MusicRankTypeEnum, Integer> qqPageLengthMap = musicPageLengthMap.get(MusicPlatformEnum.QQMUSIC);
		qqPageLengthMap.put(MusicRankTypeEnum.HOT, 10);
		qqPageLengthMap.put(MusicRankTypeEnum.NEW, 4);
		Map<MusicRankTypeEnum, Integer> xiamiPageLengthMap = musicPageLengthMap.get(MusicPlatformEnum.XIAMIMUSIC);
		xiamiPageLengthMap.put(MusicRankTypeEnum.HOT, 1);
		xiamiPageLengthMap.put(MusicRankTypeEnum.NEW, 1);
	}
	
	/**
	 * 获取音乐地址
	 * @param platformEnum 音乐平台
	 * @param rankTypeEnum 排行分类
	 * @return
	 */
	public static String getUrl(MusicPlatformEnum platformEnum, MusicRankTypeEnum rankTypeEnum) {
		Map<MusicRankTypeEnum, String> rankTypeUrlMap = musicUrlMap.get(platformEnum);
		if(MapUtils.isEmpty(rankTypeUrlMap)) {
			return null;
		}
		return rankTypeUrlMap.get(rankTypeEnum);
	}
	
	/**
	 * 获取音乐总页数
	 * @param platformEnum 音乐平台
	 * @param rankTypeEnum 排行分类
	 * @return
	 */
	public static Integer getPagelength(MusicPlatformEnum platformEnum, MusicRankTypeEnum rankTypeEnum) {
		Map<MusicRankTypeEnum, Integer> rankTypePagelengthMap = musicPageLengthMap.get(platformEnum);
		if(MapUtils.isEmpty(rankTypePagelengthMap)) {
			return 1;
		}
		return rankTypePagelengthMap.get(rankTypeEnum);
	}
}
