package com.bootdo.function.dao;

import com.bootdo.function.domain.ApplyDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author Ian
 * @email XXX@163.com
 * @date 2018-05-08 22:41:02
 */
@Mapper
public interface ApplyDao {

	ApplyDO get(Long applyId);

	List<ApplyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ApplyDO apply);
	
	int update(ApplyDO apply);
	
	int remove(Long apply_id);
	
	int batchRemove(Long[] applyIds);

}
