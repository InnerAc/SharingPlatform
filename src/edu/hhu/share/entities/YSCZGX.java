package edu.hhu.share.entities;

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
}
