package com.chinasofti.GD.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.GD.beans.Great;
import com.chinasofti.GD.mapper.GreatMapper;
import com.chinasofti.GD.service.IGreatService;

import tk.mybatis.mapper.common.Mapper;

@Service
public class GreatServiceImpl  extends CommonServiceImpl<Great> implements
IGreatService{
	@Autowired
	private GreatMapper greatMapper;

	@Override
	protected Mapper getMapper() {
		return this.greatMapper;
	}
	@Override
	public void addgreat(Great great) {
		 greatMapper.insert(great);
	}
	@Override
	public String getcount(Great great) {
		return greatMapper.getcount(great);
	}
	@Override
	public List<Great> checkReport(Great great) {
		return greatMapper.checkreport(great);
	}
	@Override
	public void cancle(Great great) {
		greatMapper.cancle(great);
	}
	@Override
	public String usercount(Great great) {
		return greatMapper.getusercount(great);
	}

}
