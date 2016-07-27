package edu.hhu.share.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.jfinal.core.Controller;
import com.jfinal.json.Json;
import com.jfinal.kit.JsonKit;

import edu.hhu.share.entities.SWYS;

public class SWYSController extends Controller{

	public void index(){
		setAttr("swyss", SWYS.dao.findAll());
		render("/view/swys.jsp");
	}
//	public void select(){
//		String testString = "[{\"RQZD2\":\"2016-07-25\",\"RQZD1\":\"2016-07-24\",\"YSNR\":\" (STCD,DT,AVZ)\",\"YSMC\":\"日平均水位\",\"YSDM\":\"0202\",\"BM\":\"HY_DZ_C\",\"LX\":\"1\",\"ZF\":201.0}]";
////		SWYS swys = JsonKit.parse(testString, SWYS.class);
//		List<SWYS> swyss = JSON.parseArray(testString,SWYS.class);
//		for(SWYS swys: swyss){
//			swys.turnDB().update();
//		}
//	}
	/**
	 * 修改单行数据
	 */
	public void commit(){
		String mData=getPara("swys");
		SWYS swys = JSON.parseObject(mData,SWYS.class);
		swys.turnDB().update();
		renderText("success");
	}
	
	/**
	 * 插入一条数据
	 */
	public void add(){
		String mData=getPara("swys");
		SWYS swys = JSON.parseObject(mData,SWYS.class);
		swys.turnDB().save();
		renderText("success");
	}
	
	/**
	 * 删除一条数据
	 */
	public void drop(){
		String ysdm = getPara("swys");
		SWYS.dao.drop(ysdm);
		renderText("success");
	}
	
	/**
	 * 得到说有的数据
	 */
	public void jsonAll(){
		renderJson(SWYS.dao.findAll());
	}
}
