package cn.li.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import cn.li.emall.entity.TbSpecification;
import cn.li.seller.service.SpecificationService;
import cn.li.ultil.ShopResult;

@RestController
@RequestMapping("/specification")
public class SpecificationController{
	
	@Reference
	private SpecificationService specificationService;
	
	@RequestMapping("queryall")
	public List<TbSpecification> findall(){
		
		return specificationService.findAll();
	}
	
	@RequestMapping("querypager")
	public ShopResult querypager(@RequestBody TbSpecification tbSpecification, int page, int size){
		
		return specificationService.querypager(tbSpecification,page,size);
	}
	
	@RequestMapping("add")
	public ShopResult add(@RequestBody TbSpecification tbSpecification){
		try {
			specificationService.add(tbSpecification);
			 return ShopResult.build(200, "增加成功");
		} catch (Exception e) {
			 return ShopResult.build(500, "增加失败");
		}
	}
	
	
	
	@RequestMapping("queryid")
	public TbSpecification queryid(Long id){

		return specificationService.queryid(id);
		
	}
	
	
	@RequestMapping("update")
	public ShopResult update(@RequestBody TbSpecification brand){
		try {
			specificationService.update(brand);
			 return ShopResult.build(200, "修改成功");
		} catch (Exception e) {
			 return ShopResult.build(500, "修改失败");
		}
	 
	}
	
	
	@RequestMapping("delete")
	public ShopResult delete(long[] ids){
		try {
			specificationService.delete(ids);
			 return ShopResult.build(200, "删除成功");
		} catch (Exception e) {
			 return ShopResult.build(500, "删除失败");
		}
	}
	
}
