package edu.hhu.share.controller;

import java.util.List;

import com.jfinal.core.Controller;

import edu.hhu.share.entities.SWYS;

public class RecordFilesController extends Controller{
	public void index(){
		List<SWYS> swyss = SWYS.dao.findAll();
		setAttr("swyss", swyss);
		render("/view/reacordFiles.jsp");
	}
}
