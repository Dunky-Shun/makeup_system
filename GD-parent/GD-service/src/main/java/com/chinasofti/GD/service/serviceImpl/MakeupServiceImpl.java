package com.chinasofti.GD.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.common.Mapper;

import com.chinasofti.GD.beans.Makeup;
import com.chinasofti.GD.mapper.MakeupMapper;
import com.chinasofti.GD.service.IMakeupService;
@Service
public class MakeupServiceImpl extends CommonServiceImpl<Makeup> implements IMakeupService{

	@Autowired
	private MakeupMapper makeupMapper;
	


	@Override
	protected Mapper getMapper() {
		return this.makeupMapper;
	}



	@Override
	public List<Makeup> getMakeup(Makeup makeup) {
		return makeupMapper.select(makeup);
	}



	@Override
	public List<Makeup> getyoupi(Makeup makeup) {
		
		return makeupMapper.getyoupi(makeup);
	}







	

	

}
