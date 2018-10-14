package com.liyulin.design.patterns.template.third.impl;

import com.liyulin.design.patterns.template.third.IFileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AliyunFileService implements IFileService {

	@Override
	public boolean upload() {
		log.info("阿里云上次文件");
		return false;
	}

}
