package edu.hhu.share.entities;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

public class HY_STSC_A extends Model<HY_STSC_A>{

	private static final long serialVersionUID = 1L;
	public static final HY_STSC_A dao = new HY_STSC_A();
	
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
	
	public List<HY_STSC_A> selectByBSandADD(List<String> bshncds,List<String> addvcds){
		String sql = "select * from HY_STSC_A where ";
		String BSHNCD = "";
		String ADDVCD = "";
		for(String bs : bshncds){
			BSHNCD += (" or BSHNCD='"+bs+"'");
		}
		BSHNCD = (BSHNCD.replaceFirst(" or ", "(") + ")");
		
		for(String add : addvcds){
			ADDVCD += (" or ADDVCD='"+add+"'");
		}
		ADDVCD = (ADDVCD.replaceFirst(" or ", "(") + ")");
		sql = sql+BSHNCD+" and "+ADDVCD;
		try {
			return find(sql);
		} catch (Exception e) {
			return null;
		}
	}
}
