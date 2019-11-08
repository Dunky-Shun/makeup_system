package com.chinasofti.GD.service.serviceImpl;

import java.util.List;

import com.chinasofti.GD.service.ICommonService;

import tk.mybatis.mapper.common.Mapper;


public abstract class CommonServiceImpl<T> implements ICommonService<T> {
	

	// 获取Mapper对象
	protected abstract Mapper getMapper();
	
		
	@Override
	public List<T> findAll() {
		return getMapper().selectAll();
	}

	@Override
	public T findById(String uuid) {
		return (T) getMapper().selectByPrimaryKey(uuid);
	}

	@Override
	public void add(T t) {
		getMapper().insert(t);
	}

	@Override
	public void update(T t) {
		getMapper().updateByPrimaryKeySelective(t);
	}

	@Override
	public void delete(String uuid) {
		getMapper().deleteByPrimaryKey(uuid);
	}


	@Override
	public List<T> find(T t) {
		return getMapper().select(t);
	}


	@Override
	public int getTotal() {
		return getMapper().selectCount(null);
	}
	
	@Override
	public int getTotal(T t) {
		return getMapper().selectCount(t);
	}
	
}
