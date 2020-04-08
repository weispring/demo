package com.liyulin.mocktest;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * 此种方式不推荐（IDE覆盖率统计失效）
 *
 * @author liyulin
 * @date 2019-09-08
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(StringUtils.class)
//@RunWith(PowerMockRunner.class)
//@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
//@PowerMockIgnore({"javax.management.*", "javax.script.*"})
//@SpringBootTest
public class PowermockTest {

	@Test
	public void testStaticMethod() {
		PowerMockito.mockStatic(StringUtils.class);
		PowerMockito.when(StringUtils.isBlank(Mockito.any())).thenReturn(true);
		Assertions.assertThat(StringUtils.isBlank("123456")).isTrue();
	}

	@Test
	public void testStaticMethod2() {
		PowerMockito.mockStatic(StringUtils.class);
		PowerMockito.when(StringUtils.isBlank(Mockito.any())).thenReturn(true);
		Assertions.assertThat(StringUtils.isBlank("123456")).isTrue();
	}
	
}