package edu.hhu.share.controller;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.jfinal.core.Controller;

import edu.hhu.share.entities.HLMC;
import edu.hhu.share.entities.XZQDM;

public class CodeController extends Controller{
	public void hlmc() {
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
	
	////行政区代码表操作
	public void xzqdm() {
		List<XZQDM> xzqdms = XZQDM.dao.findAll();
		setAttr("xzqdms", xzqdms);
		render("/view/xzqdm.jsp");
	}
	/**
	 * 修改单行数据
	 */
	public void commitXZQ(){
		String mData=getPara("xzqdm");
		XZQDM xzqdm = JSON.parseObject(mData,XZQDM.class);
		try{
			xzqdm.turnDB().update();
			renderJson("{\"res\":\"修改成功\"}");
		}catch(Exception e){
			renderJson("{\"res\":\"修改失败\"}");
		}
	}
	
	/**
	 * 插入一条数据
	 */
	public void addXZQ(){
		String mData=getPara("xzqdm");
		XZQDM xzqdm = JSON.parseObject(mData,XZQDM.class);
		try{
			xzqdm.turnDB().save();
			renderJson("{\"res\":\"插入成功\"}");
		}catch(Exception e){
			renderJson("{\"res\":\"插入失败\"}");
		}
	}
	
	/**
	 * 删除一条数据
	 */
	public void dropXZQ(){
		String addvcd = getPara("xzqdm");
		try{
			XZQDM.dao.drop(addvcd);
			renderJson("{\"res\":\"删除成功\"}");
		}catch(Exception e){
			renderJson("{\"res\":\"删除失败\"}");
		}
	}
}
