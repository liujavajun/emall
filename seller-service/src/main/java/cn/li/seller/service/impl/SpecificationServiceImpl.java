package cn.li.seller.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.li.emall.dao.TbSpecificationMapper;

import cn.li.emall.entity.TbSpecification;
import cn.li.emall.entity.TbSpecificationExample;
import cn.li.emall.entity.TbSpecificationExample.Criteria;
import cn.li.seller.service.SpecificationService;
import cn.li.ultil.ShopResult;

/**
 * 規格管理
 *
 */ 
@Service
public class SpecificationServiceImpl implements SpecificationService{

	@Autowired
	private TbSpecificationMapper tbSpecificationMapper;
	
	@Override
	public List<TbSpecification> findAll() {
		// TODO Auto-generated method stub
		return tbSpecificationMapper.selectByExample(null);
	}

	@Override
	public ShopResult querypager(TbSpecification specification, int page, int size) {
		TbSpecificationExample example= new TbSpecificationExample();
		Criteria c=example.createCriteria();
		if(specification!=null) {
			if(specification.getSpecName()!=null&&!"".equals(specification.getSpecName())) {
				c.andSpecNameLike("%"+specification.getSpecName()+"%");
			}
		}
		
		PageHelper.startPage(page, size);
		Page<TbSpecification> pages=(Page<TbSpecification>) tbSpecificationMapper.selectByExample(example);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", pages.getTotal());
		map.put("rows", pages.getResult());
		
		return ShopResult.ok(map);
	}

	@Override
	public void add(TbSpecification specification) {
		// TODO Auto-generated method stub
		tbSpecificationMapper.insert(specification);
	}

	@Override
	public TbSpecification queryid(long id) {
		// TODO Auto-generated method stub
		return tbSpecificationMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(TbSpecification specification) {
		// TODO Auto-generated method stub
		tbSpecificationMapper.updateByPrimaryKey(specification);
	}

	@Override
	public void delete(long[] ids) {
		for(Long id:ids) {
			tbSpecificationMapper.deleteByPrimaryKey(id);
		}
		
	}

}
