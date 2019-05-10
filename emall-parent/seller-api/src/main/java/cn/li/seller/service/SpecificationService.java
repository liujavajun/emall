package cn.li.seller.service;

import java.util.List;

import cn.li.emall.entity.TbBrand;
import cn.li.emall.entity.TbSpecification;
import cn.li.ultil.ShopResult;

/**
 * 規格管理
 *
 */
public interface SpecificationService {

	public List<TbSpecification> findAll();

	public ShopResult querypager(TbSpecification specification, int page, int size);

	public void add(TbSpecification specification);

	public TbSpecification queryid(long id);

	public void update(TbSpecification specification);

	public void delete(long[] ids);
}
