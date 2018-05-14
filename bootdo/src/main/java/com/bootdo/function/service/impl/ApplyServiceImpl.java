package com.bootdo.function.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.function.dao.ApplyDao;
import com.bootdo.function.domain.ApplyDO;
import com.bootdo.function.service.ApplyService;



@Service
public class ApplyServiceImpl implements ApplyService {
	@Autowired
	private ApplyDao applyDao;
	
	@Override
	public ApplyDO get(Long applyId){
		return applyDao.get(applyId);
	}
	
	@Override
	public List<ApplyDO> list(Map<String, Object> map){
		return applyDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return applyDao.count(map);
	}
	
	@Override
	public int save(ApplyDO apply){
		return applyDao.save(apply);
	}
	
	@Override
	public int update(ApplyDO apply){
		return applyDao.update(apply);
	}
	
	@Override
	public int remove(Long applyId){
		return applyDao.remove(applyId);
	}
	
	@Override
	public int batchRemove(Long[] applyIds){
		return applyDao.batchRemove(applyIds);
	}
	
}
