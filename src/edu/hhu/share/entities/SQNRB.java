package edu.hhu.share.entities;

import java.util.Date;
import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.sun.org.apache.bcel.internal.generic.Select;

import edu.hhu.share.model.DateFormat;

public class SQNRB extends Model<SQNRB>{

	private static final long serialVersionUID = 1L;
	public static final SQNRB dao = new SQNRB();
	
	public String XH;
	public String YSDM;
	public String STCD;
	public Date QSRQ;
	public Date ZZRQ;
	
	public String YSMC;
	public String STINFO;
	
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
	
	public SQNRB turnExcel(){
		turnJAVA();
		this.YSMC = SWYS.dao.findById(this.YSDM).getStr("YSMC");
		this.STINFO = this.STCD+","+HY_STSC_A.dao.findById(this.STCD).getStr("STNM");
		
		return this;
	}
	
	public SQNRBJSTL toJSTL(){
		SQNRBJSTL sq = new SQNRBJSTL(DateFormat.format(QSRQ), DateFormat.format(ZZRQ), YSMC	, STINFO,YSDM);
		return sq;
	}
	
	public double getZF(){
		double zf = SWYS.dao.returnZF(YSDM);
//		double foot = ZZRQ.get - QSRQ;
		long foot = ZZRQ.getTime() - QSRQ.getTime();
		double deta = (double)foot/(24*3600*1000);
		return deta * zf;
	}
	
	public List<SQNRB> findByXH(String xh){
		return find("select * from SQNRB where XH='"+xh+"'");
	}
	public String getXH() {
		return XH;
	}
	public void setXH(String xH) {
		XH = xH;
	}
	public String getYSDM() {
		return YSDM;
	}
	public void setYSDM(String ySDM) {
		YSDM = ySDM;
	}
	public String getSTCD() {
		return STCD;
	}
	public void setSTCD(String sTCD) {
		STCD = sTCD;
	}
	public Date getQSRQ() {
		return QSRQ;
	}
	public void setQSRQ(Date qSRQ) {
		QSRQ = qSRQ;
	}
	public Date getZZRQ() {
		return ZZRQ;
	}
	public void setZZRQ(Date zZRQ) {
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
	
	@Override
	public String toString() {
		return "SQNRB [XH=" + XH + ", YSDM=" + YSDM + ", STCD=" + STCD
				+ ", QSRQ=" + QSRQ + ", ZZRQ=" + ZZRQ + ", YSMC=" + YSMC
				+ ", STINFO=" + STINFO + "]";
	}
	
}
