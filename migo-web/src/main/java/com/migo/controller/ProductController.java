package com.migo.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.migo.entity.SysUserEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.migo.entity.ProductEntity;
import com.migo.service.ProductService;
import com.migo.utils.PageUtils;
import com.migo.utils.Query;
import com.migo.utils.R;


/**
 * 商品信息
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2018-07-14 15:10:58
 */
@RestController
@RequestMapping("product")
public class ProductController  extends AbstractController{
	@Autowired
	private ProductService productService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("product:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		SysUserEntity sysUserEntity=getUser();
		params.put("createUserId",sysUserEntity.getUserId());
        Query query = new Query(params);

		List<ProductEntity> productList = productService.queryList(query);
		int total = productService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(productList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("product:info")
	public R info(@PathVariable("id") Long id){
		ProductEntity product = productService.queryObject(id);
		
		return R.ok().put("product", product);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("product:save")
	public R save(@RequestBody ProductEntity product){
		product.setCreateData(new Date());
		SysUserEntity sysUserEntity=getUser();
		product.setCreateUserId(sysUserEntity.getUserId()+"");
		product.setCreateUserName(sysUserEntity.getUsername());
		productService.save(product);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("product:update")
	public R update(@RequestBody ProductEntity product){
		product.setCreateData(new Date());
		SysUserEntity sysUserEntity=getUser();
		product.setCreateUserId(sysUserEntity.getUserId()+"");
		product.setCreateUserName(sysUserEntity.getUsername());
		productService.update(product);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("product:delete")
	public R delete(@RequestBody Long[] ids){
		productService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
