package edu.hhu.share.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.alibaba.fastjson.JSON;
import com.jfinal.core.Controller;
import com.jfinal.ext.render.excel.PoiRender;
import com.jfinal.plugin.ehcache.CacheKit;

import edu.hhu.share.entities.HLMC;
import edu.hhu.share.entities.HY_STSC_A;
import edu.hhu.share.entities.SQB;
import edu.hhu.share.entities.SQBJSTL;
import edu.hhu.share.entities.SQNRB;
import edu.hhu.share.entities.SQNRBJSTL;
import edu.hhu.share.entities.SWYS;
import edu.hhu.share.entities.XZQDM;
import edu.hhu.share.model.ExcelExport;
import edu.hhu.share.model.TempFileRender;

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
	
	public void commit(){
		String sqb = getPara("sqb");
		SQB sqbi = JSON.parseObject(sqb,SQB.class);
		
		String sqnrbsJson = getPara("sqnrbs");
		List<SQNRB> sqnrbs = JSON.parseArray(sqnrbsJson, SQNRB.class);
		
		double zfs = 0.0;
		try{
			for(SQNRB sqnrb : sqnrbs){
				sqnrb.XH = sqbi.XH;
				zfs += sqnrb.getZF();
				sqnrb.turnDB().save();
				sqnrb.turnExcel();
			}
			sqbi.setZF(zfs);
			sqbi.turnDB().save();
			HashMap<String, Object> res = new HashMap<>();
			res.put("sqb", sqbi);
			res.put("sqnrbs", sqnrbs);
			CacheKit.put("SQB", sqbi.XH, res);
			renderJson("{\"sid\":"+sqbi.XH+"}");
		}catch (Exception e){
			System.out.println(e);
			renderJson("{\"res\":\"申请失败\"}");
		}
	}
	
	public void print(){

		String sid = getPara();
		HashMap<String, Object> res = CacheKit.get("SQB", sid);
		if(res == null){
			renderText("请不要直接输入申请单打印");
		}else{
			SQB sqb = (SQB) res.get("sqb");
			@SuppressWarnings("unchecked")
			List<SQNRB> sqnrbs = (List<SQNRB>) res.get("sqnrbs");
			List<SQNRBJSTL> sqq = new ArrayList<SQNRBJSTL>();
			for(SQNRB sqnrb :sqnrbs){
				SQNRBJSTL sq = sqnrb.turnExcel().toJSTL();
				sqq.add(sq);
			}
			SQBJSTL sqbjstl = sqb.toJSTL();
			System.out.println(sqq);
			setAttr("sqb", sqbjstl);
			setAttr("sqnrbs", sqq);
	
			render("/view/print.jsp");
		}
	}
	
	public void download() throws IOException, BiffException, RowsExceededException, WriteException{
		String xhid = getPara();
		SQB sqb = SQB.dao.findById(xhid);
		List<SQNRB> sqnrbs = SQNRB.dao.findByXH(xhid); 
		File file = ExcelExport.generalExcelFileInOutputStream(xhid,sqb.turnJAVA(),sqnrbs);
		render(new TempFileRender(file));
	}
	
	//编辑的action
	
	public void query(){
		if("POST".equals(getRequest().getMethod())){
			String applyId = getPara("XH");
			String applyDW = getPara("DW");
			String applyUser = getPara("XM");
			
			System.out.println("applyId "+applyId);
			
			SQB sqb = SQB.dao.findById(applyId);
			sqb.turnJAVA();
			if(sqb.DW.equals(applyDW) && sqb.XM.equals(applyUser)){
				List<SQNRB> sqnrbs = SQNRB.dao.findByXH(applyId);
				List<SQNRBJSTL> sqq = new ArrayList<SQNRBJSTL>();
				for(SQNRB sqnrb :sqnrbs){
					SQNRBJSTL sq = sqnrb.turnExcel().toJSTL();
					sqq.add(sq);
				}
				SQBJSTL sqbjstl = sqb.toJSTL();
				
				setAttr("sqb", sqbjstl);
				setAttr("sqnrbs", sqq);
				setAttr("swyss", SWYS.dao.findAll());
				setAttr("hlmcs", HLMC.dao.findAll());
				setAttr("xzqdms", XZQDM.dao.findAll());
				render("/view/applyedit.jsp");
			}else{
				renderText("查无此单，请输入正确的信息");
			}
		}else {
			render("/view/query.jsp");
		}
	}
	
	public void update(){
		String sqb = getPara("sqb");
		SQB sqbi = JSON.parseObject(sqb,SQB.class);
		
		String sqnrbsJson = getPara("sqnrbs");
		List<SQNRB> sqnrbs = JSON.parseArray(sqnrbsJson, SQNRB.class);
		
		double zfs = 0.0;
		try{
			for(SQNRB sqnrb : sqnrbs){
				sqnrb.XH = sqbi.XH;
				zfs += sqnrb.getZF();
				sqnrb.turnDB().update();
				sqnrb.turnExcel();
			}
			sqbi.setZF(zfs);
			sqbi.turnDB().update();
			HashMap<String, Object> res = new HashMap<>();
			res.put("sqb", sqbi);
			res.put("sqnrbs", sqnrbs);
			CacheKit.put("SQB", sqbi.XH, res);
			renderJson("{\"sid\":"+sqbi.XH+"}");
		}catch (Exception e){
			System.out.println(e);
			renderJson("{\"res\":\"修改失败\"}");
		}
	}
}
