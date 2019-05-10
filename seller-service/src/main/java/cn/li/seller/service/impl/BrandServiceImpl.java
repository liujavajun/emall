package cn.li.seller.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.li.emall.dao.TbBrandMapper;
import cn.li.emall.entity.TbBrand;
import cn.li.emall.entity.TbBrandExample;
import cn.li.emall.entity.TbBrandExample.Criteria;
import cn.li.seller.service.BrandService;
import cn.li.ultil.ShopResult;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper tbrandmapper;
	
	@Override
	public List<TbBrand> findAll() {
		
		return tbrandmapper.selectByExample(null);
	}

	@Override
	public ShopResult querypager(TbBrand brand, int page, int size) {
		TbBrandExample example= new TbBrandExample();
		Criteria c=example.createCriteria();
		if(brand!=null) {
			if(brand.getName()!=null&&!"".equals(brand.getName())) {
				c.andNameLike("%"+brand.getName()+"%");
			}
			
			if(brand.getFirstChar()!=null&&!"".equals(brand.getFirstChar())&&brand.getFirstChar().length()==1) {
				c.andFirstCharEqualTo(brand.getFirstChar());
			}	
		}
		
		PageHelper.startPage(page, size);
		Page<TbBrand> pages=(Page<TbBrand>) tbrandmapper.selectByExample(example);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", pages.getTotal());
		map.put("rows", pages.getResult());
		
		return ShopResult.ok(map);
	}

	@Override
	public void add(TbBrand tbbrand) {
		
		tbrandmapper.insert(tbbrand);
	}

	@Override
	public TbBrand queryid(long id) {
		
		return tbrandmapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(TbBrand tbbrand) {
		
		tbrandmapper.updateByPrimaryKey(tbbrand);
		
	}

	@Override
	public void delete(long[] ids) {
		for(Long id:ids) {
			tbrandmapper.deleteByPrimaryKey(id);
		}
		
	}

}
