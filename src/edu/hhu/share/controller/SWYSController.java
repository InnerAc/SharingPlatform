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

	public void select(){
		String testString = "[{\"RQZD2\":\"2016-07-25\",\"RQZD1\":\"2016-07-24\",\"YSNR\":\" (STCD,DT,AVZ)\",\"YSMC\":\"日平均水位\",\"YSDM\":\"0202\",\"BM\":\"HY_DZ_C\",\"LX\":\"1\",\"ZF\":201.0}]";
//		SWYS swys = JsonKit.parse(testString, SWYS.class);
		List<SWYS> swyss = JSON.parseArray(testString,SWYS.class);
		for(SWYS swys: swyss){
			swys.turnDB().update();
		}
	}
	public void commit(){
		String mData=getPara();
	    System.out.println("从前台传过来的数据是:"+mData);
	    renderText(mData);
	}
	
	public void jsonAll(){
		renderJson(SWYS.dao.findAll());
	}
}
