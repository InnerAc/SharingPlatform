package edu.hhu.share.entities;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

public class XZQDM extends Model<XZQDM>{

	private static final long serialVersionUID = 1L;
	public static final XZQDM dao = new XZQDM();
	
	public String ADDVCD;
	public String XZQMC;
	
	public XZQDM turnJAVA(){
		ADDVCD = getStr("ADDVCD");
		XZQMC = getStr("XZQMC");
		return this;
	}
	
	public XZQDM turnDB(){
		set("ADDVCD", ADDVCD);
		set("XZQMC", XZQMC);
		return this;
	}
	
	public boolean drop(String addvcd){
		XZQDM xzqmc = findById(addvcd);
		return xzqmc.delete();
	}
	
	public List<XZQDM> findAll(){
		List<XZQDM> xzqdms = null;
		try {
			xzqdms = find("select * from XZQDM");
		} catch (Exception e) {
			
		}
		return xzqdms;
	}
}
