package spider.util;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.alibaba.fastjson.JSON;

import spider.entity.MusicEntity;

/**
 * 音乐实体工具类
 * @author	ws
 *
 */
public class MusicEtityUtils {

	/**
	 * 处理音乐实体
	 * @param musicEntity 音乐实体
	 */
	public static void procrssMusicEntity(MusicEntity musicEntity) {
		if(musicEntity == null) {
			return;
		}
		System.out.println(JSON.toJSONString(musicEntity));
	}
	
	/**
	 * 处理音乐实体集合
	 * @param musicEntities 音乐实体集合
	 */
	public static void procrssMusicEntity(List<MusicEntity> musicEntities) {
		if(CollectionUtils.isEmpty(musicEntities)) {
			return;
		}
		for(MusicEntity entity : musicEntities) {
			procrssMusicEntity(entity);
		}
	}
	
}
