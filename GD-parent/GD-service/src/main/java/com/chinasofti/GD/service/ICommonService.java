package com.chinasofti.GD.service;

import java.util.List;

public interface ICommonService<T> {
	/**
	 * 查询所有
	 * @return
	 */
	List<T> findAll();
	
	/**
	 * 条件查询
	 * @ t 封装查询条件
	 * @return
	 */
	List<T> find(T t);

	/**
	 * 根据ID查询
	 * @param uuid
	 * @return
	 */
	T findById(String uuid);
	
	/**
	 * 统计结果数
	 * @return
	 */
	int getTotal();
	
	/**
	 * 统计结果数
	 * @return
	 */
	int getTotal(T t);
	
	/**
	 * 添加
	 * @param t
	 */
	void add(T t);
	
	/**
	 * 修改
	 * @param t
	 */
	void update(T t);
	
	/**
	 * 删除
	 * @param t
	 */
	void delete(String uuid);
}
