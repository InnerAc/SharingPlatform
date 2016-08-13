package edu.hhu.share.controller;

import java.util.List;

import com.jfinal.core.Controller;

import edu.hhu.share.entities.SQB;

public class StatisticsController extends Controller{

	public void index(){
		String year = getPara("year");
		if(year == null || year.equals("")){
			render("/view/stati.jsp");
		}else{
			List<SQB> sqbs = SQB.dao.findByYear(year);
			int inner = 0;
			double innerZF = 0.0;
			int outer = 0;
			double outerZF = 0.0;
			for(SQB sqb : sqbs){
				sqb.turnJAVA();
				if(sqb.LX.equals("1")){
					inner += 1;
					innerZF += sqb.ZF;
				}else{
					outer += 1;
					outerZF += sqb.ZF;
				}
			}
			int all = inner + outer;
			double allZF = innerZF + outerZF;
			setAttr("inner", inner);
			setAttr("outer", outer);
			setAttr("innerZF", innerZF);
			setAttr("outerZF", outerZF);
			setAttr("all", all);
			setAttr("allZF", allZF);
			render("/view/stati.jsp");
		}
		
	}
}
