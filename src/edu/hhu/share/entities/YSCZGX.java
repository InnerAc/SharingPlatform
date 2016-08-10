package edu.hhu.share.entities;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

public class YSCZGX extends Model<YSCZGX>{

	private static final long serialVersionUID = 1L;
	public static final YSCZGX dao = new YSCZGX();
	
	public String YSDM;
	public String STCD;
	public String BM;
	
	public YSCZGX turnJAVA(){
		YSDM = getStr("YSDM");
		STCD = getStr("STCD");
		BM = getStr("BM");
		return this;
	}
	
	public YSCZGX turnDB(){
		set("YSDM", YSDM);
		set("STCD", STCD);
		set("BM", BM);
		return this;
	}
	
	public List<YSCZGX> findByYear(String year,String ysdm){
		List<YSCZGX> ysczgxs = null;
		String sql = "select * from YSCZGX where YSDM='"+ysdm+"' and SUBSTR(BM,-4,4)='"+year+"'";
		ysczgxs = find(sql);
		return ysczgxs;
		
	}
}
