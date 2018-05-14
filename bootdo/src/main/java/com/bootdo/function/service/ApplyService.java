package com.bootdo.function.service;

import com.bootdo.function.domain.ApplyDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author Ian
 * @email XXX@163.com
 * @date 2018-05-08 22:41:02
 */
public interface ApplyService {
	
	ApplyDO get(Long applyId);
	
	List<ApplyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ApplyDO apply);
	
	int update(ApplyDO apply);
	
	int remove(Long applyId);
	
	int batchRemove(Long[] applyIds);
}
