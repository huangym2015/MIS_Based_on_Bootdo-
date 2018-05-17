/**
 * 
 */
package com.bootdo.common.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @author 1992lcg@163.com
 * @Time 2017年9月6日
 * @description
 * 
 */
@Service
public interface GeneratorService {
	List<Map<String, Object>> list();
//	List<Map<String,Object>> listOracle();
//
//	byte[] generatorCode(String[] tableNames,String dataSource);

	byte[] generatorCode(String[] tableNames);
}
