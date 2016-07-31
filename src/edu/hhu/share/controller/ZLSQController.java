package edu.hhu.share.controller;

import com.jfinal.core.Controller;

import edu.hhu.share.entities.SWYS;

public class ZLSQController extends Controller{
	public void index(){
		setAttr("swyss", SWYS.dao.findAll());
		render("/view/apply.jsp");
	}
}
