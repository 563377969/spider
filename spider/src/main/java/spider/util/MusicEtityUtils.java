package spider.util;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.alibaba.fastjson.JSON;

import spider.entity.MusicEntity;

/**
 * ����ʵ�幤����
 * @author	ws
 *
 */
public class MusicEtityUtils {

	/**
	 * ��������ʵ��
	 * @param musicEntity ����ʵ��
	 */
	public static void procrssMusicEntity(MusicEntity musicEntity) {
		if(musicEntity == null) {
			return;
		}
		System.out.println(JSON.toJSONString(musicEntity));
	}
	
	/**
	 * ��������ʵ�弯��
	 * @param musicEntities ����ʵ�弯��
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
