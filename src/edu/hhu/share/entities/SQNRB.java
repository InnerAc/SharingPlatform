package edu.hhu.share.entities;

import java.util.Date;

import com.jfinal.plugin.activerecord.Model;

public class SQNRB extends Model<SQNRB>{

	private static final long serialVersionUID = 1L;
	public static final SQNRB dao = new SQNRB();
	
	public String XH;
	public String YSDM;
	public String STCD;
	public Date QSRQ;
	public Date ZZRQ;
	
	public SQNRB turnJAVA(){
		XH = getStr("XH");
		YSDM = getStr("YSDM");
		STCD = getStr("STCD");
		QSRQ = getDate("QSRQ");
		ZZRQ = getDate("ZZRQ");
		return this;
	}
	public SQNRB turnDB(){
		set("XH",XH);
		set("YSDM",YSDM);
		set("STCD",STCD);
		set("QSRQ",QSRQ);
		set("ZZRQ",ZZRQ);
		return this;
	}
}
