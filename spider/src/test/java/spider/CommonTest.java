package spider;

import junit.framework.TestCase;
import spider.util.CommonUtils;

public class CommonTest extends TestCase {

	public void durationToSecondsTest() {
		String duratioString = "03:14";
		Integer duration = CommonUtils.durationToSeconds(duratioString);
		System.out.println(duration);
	}
}
