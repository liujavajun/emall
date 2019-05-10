package cn.li.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import cn.li.emall.entity.TbBrand;
import cn.li.seller.service.BrandService;
import cn.li.ultil.ShopResult;

@RestController
@RequestMapping("/brand")
public class BrandController{
	
	@Reference
	private BrandService brandService;
	
	@RequestMapping("queryall")
	public List<TbBrand> findall(){
		
		return brandService.findAll();
	}
	
	@RequestMapping("querypager")
	public ShopResult querypager(@RequestBody TbBrand brand, int page, int size){
		
		return brandService.querypager(brand,page,size);
	}
	
	@RequestMapping("add")
	public ShopResult add(@RequestBody TbBrand brand){
		try {
			 brandService.add(brand);
			 return ShopResult.build(200, "增加成功");
		} catch (Exception e) {
			 return ShopResult.build(500, "增加失败");
		}
	}
	
	
	
	@RequestMapping("queryid")
	public TbBrand queryid(Long id){

		return brandService.queryid(id);
		
	}
	
	
	@RequestMapping("update")
	public ShopResult update(@RequestBody TbBrand brand){
		try {
			 brandService.update(brand);
			 return ShopResult.build(200, "修改成功");
		} catch (Exception e) {
			 return ShopResult.build(500, "修改失败");
		}
	 
	}
	
	
	@RequestMapping("delete")
	public ShopResult delete(long[] ids){
		try {
			 brandService.delete(ids);
			 return ShopResult.build(200, "删除成功");
		} catch (Exception e) {
			 return ShopResult.build(500, "删除失败");
		}
	}
	
}
