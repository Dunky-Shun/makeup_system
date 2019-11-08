package com.chinasofti.GD.service;

import java.util.List;

import com.chinasofti.GD.beans.Makeup;

public interface IMakeupService extends ICommonService<Makeup> {

	//获取化妆品
	List<Makeup>getMakeup(Makeup makeup);

	List<Makeup> getyoupi(Makeup makeup);
}
