package edu.hhu.share.entities;

import java.util.Date;

public class SQBJSTL {

	public String XH;
	public String RQ;
	public String DW;
	public String LX;
	public String XM;
	public String DH;
	public String ZLYT;
	public double ZF;
	
	public SQBJSTL(String XH, String RQ, String DW, String LX, String XM, String DH, String ZLYT, double ZF){
		this.XH = XH;
		this.RQ = RQ;
		this.DW = DW;
		this.LX = LX;
		this.XM = XM;
		this.DH = DH;
		this.ZLYT = ZLYT;
		this.ZF = ZF;
	}

	public String getXH() {
		return XH;
	}

	public void setXH(String xH) {
		XH = xH;
	}

	public String getRQ() {
		return RQ;
	}

	public void setRQ(String rQ) {
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
	
	
}
