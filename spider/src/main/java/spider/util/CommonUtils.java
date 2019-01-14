package spider.util;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * ������
 * @author	ws
 *
 */
public class CommonUtils {

	/**
	 * �ַ���ת����
	 * @param value �ַ���ֵ
	 * @param defaultValue ת��ʧ��Ĭ��ֵ
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
	 * �ַ���ת����
	 * @param value �ַ���ֵ
	 * @return
	 */
	public static Integer  stringToInteger(String value) {
		return stringToInteger(value, 0);
	}
	
	/**
	 * ʱ��ת������
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
