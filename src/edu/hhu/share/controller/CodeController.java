package edu.hhu.share.controller;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.jfinal.core.Controller;

import edu.hhu.share.entities.HLMC;

public class CodeController extends Controller{
	public void index() {
		List<HLMC> hlmcs = HLMC.dao.findAll();
		setAttr("hlmcs", hlmcs);
		render("/view/hlmc.jsp");
	}
	/**
	 * 修改单行数据
	 */
	public void commitHL(){
		String mData=getPara("hlmc");
		HLMC hlmc = JSON.parseObject(mData,HLMC.class);
		hlmc.turnDB().update();
		renderJson("{\"res\":\"修改成功\"}");
	}
	
	/**
	 * 插入一条数据
	 */
	public void addHL(){
		String mData=getPara("hlmc");
		HLMC hlmc = JSON.parseObject(mData,HLMC.class);
		hlmc.turnDB().save();
		renderJson("{\"res\":\"插入成功\"}");
	}
	
	/**
	 * 删除一条数据
	 */
	public void dropHL(){
		String bshncd = getPara("hlmc");
		HLMC.dao.drop(bshncd);
		renderJson("{\"res\":\"删除成功\"}");
	}
}
