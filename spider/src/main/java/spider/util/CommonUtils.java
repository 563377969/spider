package spider.util;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 工具类
 * @author	ws
 *
 */
public class CommonUtils {

	/**
	 * 字符串转整型
	 * @param value 字符串值
	 * @param defaultValue 转换失败默认值
	 * @return
	 */
	public static Integer stringToInteger(String value, Integer defaultValue) {
		if(StringUtils.isBlank(value)) {
			return defaultValue;
		}
		try {
			return Integer.valueOf(value);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}
	
	/**
	 * 字符串转整型
	 * @param value 字符串值
	 * @return
	 */
	public static Integer  stringToInteger(String value) {
		return stringToInteger(value, 0);
	}
	
	/**
	 * 时长转换成秒
	 * @param duration
	 * @return
	 */
	public static Integer durationToSeconds(String duration) {
		if(StringUtils.isBlank(duration)) {
			return 0;
		}
		String[] times = duration.split(":");
		if(ArrayUtils.isEmpty(times)) {
			return 0;
		}
		
		int seconds = 0;
		int length = times.length;
		for(int i = 0; i < length; i++) {
			seconds += CommonUtils.stringToInteger(times[i]) * Math.pow(60, length-i-1);
		}
		
		return seconds;
	}
}
