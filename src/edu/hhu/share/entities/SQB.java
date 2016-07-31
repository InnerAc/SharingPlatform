package edu.hhu.share.entities;

import java.util.Date;

import com.jfinal.plugin.activerecord.Model;

public class SQB extends Model<SQB>{

	private static final long serialVersionUID = 1L;
	public static final SQB dao = new SQB();
	
	public String XH;
	public Date RQ;
	public String DW;
	public String LX;
	public String XM;
	public String DH;
	public String ZLYT;
	public double ZF;
	
	public SQB turnJAVA(){
		XH = getStr("XH");
		RQ = getDate("RQ");
		DW = getStr("DW");
		LX = getStr("LX");
		XM = getStr("XM");
		DH = getStr("DH");
		ZLYT = getStr("ZLYT");
		ZF = getDouble("ZF");
		return this;
	}
	
	public SQB turnDB(){
		set("XH",XH);
		set("RQ",RQ);
		set("DW",DW);
		set("LX",LX);
		set("XM",XM);
		set("DH",DH);
		set("ZLYT",ZLYT);
		set("ZF",ZF);
		return this;
	}
}
