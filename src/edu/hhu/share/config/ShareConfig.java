package edu.hhu.share.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;

import edu.hhu.share.controller.CodeController;
import edu.hhu.share.controller.SWYSController;
import edu.hhu.share.controller.ZLSQController;
import edu.hhu.share.entities.HLMC;
import edu.hhu.share.entities.HY_STSC_A;
import edu.hhu.share.entities.SQB;
import edu.hhu.share.entities.SQNRB;
import edu.hhu.share.entities.SWYS;
import edu.hhu.share.entities.XZQDM;
import edu.hhu.share.entities.YSCZGX;

public class ShareConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		me.setDevMode(true);
		me.setViewType(ViewType.JSP);
	}

	@Override
	public void configRoute(Routes me) {
		me.add("/swyswh", SWYSController.class);
		me.add("/codewh", CodeController.class);
		me.add("/apply", ZLSQController.class);
	}

	@Override
	public void configPlugin(Plugins me) {
		C3p0Plugin cp = new C3p0Plugin("jdbc:mysql://192.168.218.128/splatform","root", "anjicun");
		me.add(cp);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
		arp.addMapping("SWYSB", "YSDM", SWYS.class);
		arp.addMapping("HLMC", "BSHNCD", HLMC.class);
		arp.addMapping("XZQDM", "ADDVCD", XZQDM.class);
		arp.addMapping("YSCZGX", "YSDM,STCD",YSCZGX.class );
		arp.addMapping("SQB", "XH", SQB.class);
		arp.addMapping("SQNRB", "XH,YSDM,STCD", SQNRB.class);
		arp.addMapping("HY_STSC_A", "STCD", HY_STSC_A.class);
		me.add(arp);
	}

	@Override
	public void configInterceptor(Interceptors me) {

	}

	@Override
	public void configHandler(Handlers me) {

	}

}
