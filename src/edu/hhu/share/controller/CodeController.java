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
		try{
			hlmc.turnDB().update();
			renderJson("{\"res\":\"修改成功\"}");
		}catch(Exception e){
			renderJson("{\"res\":\"修改失败\"}");
		}
	}
	
	/**
	 * 插入一条数据
	 */
	public void addHL(){
		String mData=getPara("hlmc");
		HLMC hlmc = JSON.parseObject(mData,HLMC.class);
		try{
			hlmc.turnDB().save();
			renderJson("{\"res\":\"插入成功\"}");
		}catch(Exception e){
			renderJson("{\"res\":\"插入失败\"}");
		}
	}
	
	/**
	 * 删除一条数据
	 */
	public void dropHL(){
		String bshncd = getPara("hlmc");
		try{
			HLMC.dao.drop(bshncd);
			renderJson("{\"res\":\"删除成功\"}");
		}catch(Exception e){
			renderJson("{\"res\":\"删除失败\"}");
		}
	}
}
