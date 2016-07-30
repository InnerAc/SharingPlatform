package edu.hhu.share.entities;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;

public class HLMC extends Model<HLMC>{

	private static final long serialVersionUID = 1L;
	public static final HLMC dao = new HLMC();
	
	public String BSHNCD;
	public String HNNM;
	public String RVNM;
	
	public HLMC turnJAVA(){
		BSHNCD = getStr("BSHNCD");
		HNNM = getStr("HNNM");
		RVNM = getStr("RVNM");
		return this;
	}
	
	public HLMC turnDB(){
		set("BSHNCD", BSHNCD);
		set("HNNM", HNNM);
		set("RVNM", RVNM);
		return this;
	}
	
	public boolean drop(String bshncd){
		HLMC hlmc = findById(bshncd);
		return hlmc.delete();
	}
	
	public List<HLMC> findAll() {
		List<HLMC> hlmcs = null;
		try {
			hlmcs = find("select * from HLMC");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return hlmcs;
	}
}
