package edu.hhu.share.entities;

import java.util.Date;
import java.util.List;

import com.jfinal.kit.JsonKit;
import com.jfinal.plugin.activerecord.Model;
import com.sun.org.apache.bcel.internal.generic.LXOR;

public class SWYS extends Model<SWYS>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final SWYS dao = new SWYS();
	
	public String YSDM;
	public String YSMC;
	public String BM;
	public String YSNR;
	public Date RQZD1;
	public Date RQZD2;
	public String LX;
	public double ZF;

	public SWYS turnJAVA() {
		YSDM = getStr("YSDM");
		YSMC = getStr("YSMC");
		BM = getStr("BM");
		YSNR = getStr("YSNR");
		RQZD1 = getDate("RQZD1");
		RQZD2 = getDate("RQZD2");
		LX = getStr("LX");
		ZF = getDouble("ZF");
		return this;
	}
	public SWYS turnDB(){
		set("YSDM",YSDM);
		set("YSMC",YSMC);
		set("BM",BM);
		set("YSNR",YSNR);
		set("RQZD1",RQZD1);
		set("RQZD2",RQZD2);
		set("LX",LX);
		set("ZF",ZF);
		return this;
	}
	
	public boolean drop(String ysdm){
		SWYS swys = SWYS.dao.findById(ysdm);
		return swys.delete();
	}
	
	public double returnZF(String ysdm){
		SWYS swys = SWYS.dao.findById(ysdm);
		double x = swys.getDouble("ZF");
		return x;
	}
	
	public List<SWYS> findAll(){
		List<SWYS> sysyss = null;
		try {
			sysyss = find("select * from SWYSB");
		} catch (Exception e) {
			sysyss = null;
		}
		return sysyss;
	}
}
