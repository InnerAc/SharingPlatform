package edu.hhu.share.controller;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.core.Controller;

import edu.hhu.share.entities.HY_STSC_A;
import edu.hhu.share.entities.SWYS;
import edu.hhu.share.entities.YSCZGX;

public class RecordFilesController extends Controller{
	public void index(){
		List<SWYS> swyss = SWYS.dao.findAll();
		setAttr("swyss", swyss);
		render("/view/reacordFiles.jsp");
	}
	
	public void selects(){
		String year = getPara("year");
		String ysdm = getPara("stid");
		List<YSCZGX> ysczgxs = YSCZGX.dao.findByYear(year, ysdm);
		List<HY_STSC_A> hyList = new ArrayList<HY_STSC_A>();
		for(YSCZGX ysczgx : ysczgxs){
			ysczgx.turnJAVA();
			hyList.add(HY_STSC_A.dao.findById(ysczgx.STCD));
		}
		renderJson(hyList);
	}
	
	public void jsonST(){
		String stcd = getPara("stcd");
		try{
			renderJson(HY_STSC_A.dao.findById(stcd));
		}catch (Exception e){
			renderJson("{\"res\":\"fail\"}");
		}
		
	}
}
