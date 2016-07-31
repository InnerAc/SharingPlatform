package edu.hhu.share.entities;

import com.jfinal.plugin.activerecord.Model;

public class HY_STSC_A extends Model<HY_STSC_A>{

	private static final long serialVersionUID = 1L;
	
	public String STCD;
	public String STNM;
	public String BSHNCD;
	public String HNNM;
	public String RVNM;
	public String ADDVCD;
	
	public HY_STSC_A turnJAVA(){
		STCD = getStr("STCD");
		STNM = getStr("STNM");
		BSHNCD = getStr("BSHNCD");
		HNNM = getStr("HNNM");
		RVNM = getStr("RVNM");
		ADDVCD = getStr("ADDVCD");
		return this;
	}
	
	public HY_STSC_A turnDB(){
		set("STCD",STCD);
		set("STNM",STNM);
		set("BSHNCD",BSHNCD);
		set("HNNM",HNNM);
		set("RVNM",RVNM);
		set("ADDVCD",ADDVCD);
		return this;
	}
}
