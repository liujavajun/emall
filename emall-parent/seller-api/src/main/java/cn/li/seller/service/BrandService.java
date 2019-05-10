package cn.li.seller.service;

import java.util.List;

import cn.li.emall.entity.TbBrand;
import cn.li.ultil.ShopResult;

/**
 * 品牌接口
 *
 */
public interface BrandService {
	
	public List<TbBrand> findAll();
	
	public ShopResult querypager(TbBrand tbbrand,int page,int size);
	
	public void add(TbBrand tbbrand);
	
	public TbBrand queryid(long id);
	
	public void update(TbBrand tbbrand);
	
	public void delete(long[] ids);
}
