package com.bootdo.function.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.common.controller.BaseController;
import com.bootdo.function.service.ITestOracleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.function.domain.ApplyDO;
import com.bootdo.function.service.ApplyService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author Ian
 * @email XXX@163.com
 * @date 2018-05-08 22:41:02
 */
 
@Controller
@RequestMapping("/function/apply")
public class ApplyController extends BaseController{
	@Autowired
	private ApplyService applyService;

	@Autowired
	private ITestOracleService iTestOracleService;
	
	@GetMapping()
	@RequiresPermissions("function:apply:apply")
	String Apply(){
	    return "function/apply/apply";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("function:apply:apply")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		query.put("userId", getUserId());//在参数表里过滤用户id，只返回当前用户的record
		List<ApplyDO> applyList = applyService.list(query);
		int total = applyService.count(query);
		PageUtils pageUtils = new PageUtils(applyList, total);
		//往oracle插入一条记录，测试多数据源
		iTestOracleService.insert();
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("function:apply:add")
	String add(){
	    return "function/apply/add";
	}

	@GetMapping("/edit/{applyId}")
	@RequiresPermissions("function:apply:edit")
	String edit(@PathVariable("applyId") Long applyId,Model model){
		ApplyDO apply = applyService.get(applyId);
		model.addAttribute("apply", apply);
	    return "function/apply/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("function:apply:add")
	public R save( ApplyDO apply){
		apply.setUserId(getUserId());
		apply.setUsername(getUsername());
		apply.setDeptId(getUser().getDeptId());
		apply.setGmtCreate(new Date());
		apply.setGmtModified(new Date());
		if(applyService.save(apply)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("function:apply:edit")
	public R update( ApplyDO apply){
		apply.setGmtModified(new Date());
		applyService.update(apply);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("function:apply:remove")
	public R remove( Long applyId){
		if(applyService.remove(applyId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("function:apply:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] applyIds){
		applyService.batchRemove(applyIds);
		return R.ok();
	}
	
}
