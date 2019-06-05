package com.liyulin.shading.jdbc.demo.task;

import javax.annotation.PostConstruct;

import org.joda.time.DateTime;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.liyulin.shading.jdbc.demo.entity.ApiLogEntity;
import com.liyulin.shading.jdbc.demo.uitl.DbTableUtil;
import com.liyulin.shading.jdbc.demo.uitl.WeekShardingUtil;

/**
 * 创建表定时任务
 * 
 * @author liyulin
 * @date 2019年6月4日 下午7:58:42
 */
@Service
public class CreateProductInfoTableTask {

	@Autowired
	private SqlSessionFactoryBean sqlSessionFactoryBean;

	/**
	 * 创建当前周的表
	 */
	@PostConstruct
	public void creatCurrentWeekTable() {
		createNextWeekTableSchedule(DateTime.now());
	}

	/**
	 * 创建下周的表
	 */
	@Scheduled(cron = "* * * 1/1 * *")
	public void createNextWeekTableSchedule() {
		DateTime nextWeek = DateTime.now().plusWeeks(1);
		createNextWeekTableSchedule(nextWeek);
	}

	/**
	 * 创建表
	 * 
	 * @param dateTime
	 */
	private void createNextWeekTableSchedule(DateTime dateTime) {
		String logicTableName = WeekShardingUtil.getLogicTableName(ApiLogEntity.class);
		String actualTableName = WeekShardingUtil.getActualTableName(dateTime, logicTableName);
		DbTableUtil.createTableIfAbsent(logicTableName, actualTableName, sqlSessionFactoryBean);
	}

}