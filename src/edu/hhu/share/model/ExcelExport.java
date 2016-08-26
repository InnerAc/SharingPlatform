package edu.hhu.share.model;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.mysql.jdbc.Field;

import edu.hhu.share.entities.SQB;
import edu.hhu.share.entities.SQNRB;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelExport {

	public static File generalExcelFileInOutputStream(String xhid, SQB sqb,
			List<SQNRB> sqnrbs) throws BiffException, IOException, RowsExceededException, WriteException {  
        File os = new File(xhid+".xls");
        os.createNewFile();
		String tempalteFile = PathUtil.projectPath+"\\tempalte.xls";
        // 获取模板  
        Workbook templatebook = Workbook.getWorkbook(new File(tempalteFile)); 
        WritableWorkbook wwb = Workbook.createWorkbook(os, templatebook);
        WritableSheet sheet = wwb.getSheet(0);
        
        sheet.addCell(new Label(1,1,sqb.DW));
        sheet.addCell(new Label(3,1,sqb.XM));
        sheet.addCell(new Label(1,2,sqb.RQ.toString()));
        sheet.addCell(new Label(3,2,sqb.DH));
        
        int i = 5;
        for(SQNRB sqnrb : sqnrbs){
        	sqnrb.turnExcel();
        	sheet.addCell(new Label(0,i,sqnrb.YSMC));
        	sheet.addCell(new Label(1,i,sqnrb.STINFO));
        	sheet.addCell(new Label(2,i,sqnrb.QSRQ.toString()));
        	sheet.addCell(new Label(3,i,sqnrb.ZZRQ.toString()));
        	i++;
        }
        sheet.addCell(new Label(0,i++,"资料用途"));
        sheet.addCell(new Label(0,i++,sqb.ZLYT));
        sheet.addCell(new Label(0,i,"资料使用部门意见："));
        i += 3;
        sheet.addCell(new Label(2,i,"负责人签字："));
        i++;
        sheet.addCell(new Label(0,i,"信息科领导签字："));
        i += 3;
        sheet.addCell(new Label(0,i,"局领导指示和会办意见："));
        i += 3;
        sheet.addCell(new Label(0,i,"资料提供人签字："));
    	sheet.addCell(new Label(2,i,"资料接受人签字："));
    	
    	
        wwb.write();
        wwb.close();
        return os;  
    }
}
