package edu.hhu.share.entities;

public class SQNRBJSTL {
	public String YSDM;
	public String QSRQ;
	public String ZZRQ;
	public String YSMC;
	public String STINFO;
	
	public SQNRBJSTL(String q,String z,String y,String s,String ys){
		QSRQ = q;
		ZZRQ = z;
		YSMC = y;
		STINFO = s;
		YSDM = ys;
	}

	public String getQSRQ() {
		return QSRQ;
	}

	public void setQSRQ(String qSRQ) {
		QSRQ = qSRQ;
	}

	public String getZZRQ() {
		return ZZRQ;
	}

	public void setZZRQ(String zZRQ) {
		ZZRQ = zZRQ;
	}

	public String getYSMC() {
		return YSMC;
	}

	public void setYSMC(String ySMC) {
		YSMC = ySMC;
	}

	public String getSTINFO() {
		return STINFO;
	}

	public void setSTINFO(String sTINFO) {
		STINFO = sTINFO;
	}

	public String getYSDM() {
		return YSDM;
	}

	public void setYSDM(String ySDM) {
		YSDM = ySDM;
	}
	
	
}
