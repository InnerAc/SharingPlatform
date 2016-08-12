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
	
	/**
	 * 将去年已有的站点需要今年归档的更新日期数据
	 * @param year
	 * @return
	 */
	public boolean record(String year){
		turnJAVA();
		String bm = this.BM;
		int n = bm.length();
		System.out.println("befor = "+n);
		if(n > 4 && bm.charAt(n-5) == '-'){
			this.BM = bm.substring(0, n-4) + year;
		}else{
			this.BM = bm + '-'+year;
		}
		turnDB();
		return update();
	}
	
	/**
	 * 创建新的归档记录或者将已有的记录更新日期
	 * @param ysdm
	 * @param stid
	 * @param year
	 * @return
	 */
	public boolean newOrEdit(String ysdm,String stid,String year){
		try {
			YSCZGX ysczgx = findById(ysdm,stid);
			ysczgx.turnJAVA();
			ysczgx.BM = ysczgx.BM + "," + year;
			ysczgx.turnDB();
			return ysczgx.update();
		} catch (Exception e) {
			YSCZGX ysczgx = new YSCZGX();
			ysczgx.BM = year;
			ysczgx.YSDM = ysdm;
			ysczgx.STCD = stid;
			ysczgx.turnDB();
			return ysczgx.save();
		}
	}
}
