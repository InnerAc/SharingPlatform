package edu.hhu.share.controller;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.jfinal.core.Controller;

import edu.hhu.share.entities.HLMC;
import edu.hhu.share.entities.HY_STSC_A;
import edu.hhu.share.entities.SWYS;
import edu.hhu.share.entities.XZQDM;

public class ZLSQController extends Controller{
	public void index(){
		setAttr("swyss", SWYS.dao.findAll());
		setAttr("hlmcs", HLMC.dao.findAll());
		setAttr("xzqdms", XZQDM.dao.findAll());
		render("/view/apply.jsp");
	}
	
	public void jsonST(){
		 String bshncd = getPara("bshncd");
		 String addvcd = getPara("addvcd");
		 List<String> bshncds = JSON.parseArray(bshncd, String.class);
		 List<String> addvcds = JSON.parseArray(addvcd, String.class);
		 renderJson(HY_STSC_A.dao.selectByBSandADD(bshncds,addvcds));
	}
}
