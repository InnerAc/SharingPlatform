package edu.hhu.share.entities;

import java.util.Date;
import java.util.List;

import com.jfinal.plugin.activerecord.Model;

import edu.hhu.share.model.DateFormat;

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
	
	public List<SQB> findAll(){
		return find("select * from SQB");
	}
	
	public List<SQB> findByYear(String year){
		String sql ="SELECT * from SQB where RQ like'"+year+"%'";
		try {
			return find(sql);
		} catch (Exception e) {
			return null;
		}
		
	}
	
	public SQBJSTL toJSTL(){
		return new SQBJSTL(XH, DateFormat.format(RQ, 1), DW, LX, XM, DH, ZLYT, ZF);
	}

	public String getXH() {
		return XH;
	}

	public void setXH(String xH) {
		XH = xH;
	}

	public Date getRQ() {
		return RQ;
	}

	public void setRQ(Date rQ) {
		RQ = rQ;
	}

	public String getDW() {
		return DW;
	}

	public void setDW(String dW) {
		DW = dW;
	}

	public String getLX() {
		return LX;
	}

	public void setLX(String lX) {
		LX = lX;
	}

	public String getXM() {
		return XM;
	}

	public void setXM(String xM) {
		XM = xM;
	}

	public String getDH() {
		return DH;
	}

	public void setDH(String dH) {
		DH = dH;
	}

	public String getZLYT() {
		return ZLYT;
	}

	public void setZLYT(String zLYT) {
		ZLYT = zLYT;
	}

	public double getZF() {
		return ZF;
	}

	public void setZF(double zF) {
		ZF = zF;
	}

	@Override
	public String toString() {
		return "SQB [XH=" + XH + ", RQ=" + RQ + ", DW=" + DW + ", LX=" + LX
				+ ", XM=" + XM + ", DH=" + DH + ", ZLYT=" + ZLYT + ", ZF=" + ZF
				+ "]";
	}
	
}
