package com.css.app.db.business.service.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageSz;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridCol;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPageOrientation;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;
import org.springframework.stereotype.Service;
import com.css.app.db.business.service.ExportService;
/**
 * wps相关操作类
 * 部领导批示指示
 * @author weizy
 *
 */
@Service
public class ExportBLDServiceImpl implements ExportService{
    @Override
	public  FileInputStream exportWPSdoc(List<Map<String, String>> list,String fileName,int banjieNum,int weibanjieNum) throws IOException {
		FileOutputStream fout = null;
        try {						
	        //添加标题
            XWPFDocument document= new XWPFDocument();
            CTDocument1 doc = document.getDocument();
            CTBody body = doc.getBody();
            if(!body.isSetSectPr()) {
            	body.addNewSectPr();            	
            }
            CTSectPr section = body.getSectPr();
            if(!section.isSetPgSz()) {
            	section.addNewPgSz();          	
            }
            CTPageSz pgSz = section.getPgSz();
            
            pgSz.setW(BigInteger.valueOf(15840));
            pgSz.setH(BigInteger.valueOf(11907));
            pgSz.setOrient(STPageOrientation.LANDSCAPE);

	        //X密部分
	        XWPFParagraph xmiParagraph = document.createParagraph();
	        xmiParagraph.setAlignment(ParagraphAlignment.LEFT);	 
	        XWPFRun xmiParagraphRun = xmiParagraph.createRun();
	        xmiParagraphRun.setText("X 密");
	        xmiParagraphRun.setFontSize(13);

			//标题部分
			XWPFParagraph titleParagraph = document.createParagraph();
			titleParagraph.setAlignment(ParagraphAlignment.CENTER);	 
			XWPFRun titleParagraphRun = titleParagraph.createRun();
			titleParagraphRun.setText("装备发展部领导批示指示督办落实情况表");
			titleParagraphRun.setColor("000000");
			titleParagraphRun.setFontSize(20);
			
			//基本信息表格
			XWPFTable infoTable = document.createTable(1,3);
			setTableWith(infoTable,"10000");
			CTTbl infoCtTbl = infoTable.getCTTbl();
			CTTblGrid infoNewTblGrid = infoCtTbl.addNewTblGrid();
			String[] infoColWidths=new String[]{"4000","2000","4000"};
			for(String colWidth:infoColWidths) {
				CTTblGridCol infoNewGridCol = infoNewTblGrid.addNewGridCol();
				infoNewGridCol.setW(new BigInteger(colWidth));
			}
			//去表格边框
			infoTable.getCTTbl().getTblPr().unsetTblBorders();	
			XWPFTableRow infoTableRowOne = infoTable.getRow(0);
			infoTableRowOne.getCell(0).setText("填报单位:中央军委装备发展部");
			infoTableRowOne.getCell(2).setText("填报日期:"+new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));
			
			//加入空行
			XWPFParagraph voidParagraph = document.createParagraph();
			XWPFRun createRun = voidParagraph.createRun();  
			createRun.setFontSize(1);
			createRun.setText("0");
			//工作经历表格
			XWPFTable ComTable = document.createTable();
			setTableWith(ComTable,"12000");
			CTTbl ctTbl = ComTable.getCTTbl();
			CTTblGrid addNewTblGrid = ctTbl.addNewTblGrid();
			String[] colWidths=new String[]{"400","1500","5000","2000","1100","1000"};
			for(String colWidth:colWidths) {
				CTTblGridCol addNewGridCol = addNewTblGrid.addNewGridCol();
				addNewGridCol.setW(new BigInteger(colWidth));
			}
			CTTblBorders borders = ComTable.getCTTbl().getTblPr().getTblBorders();
			CTBorder topBorder = borders.getTop();
			CTBorder leftBorder = borders.getLeft();
			CTBorder rightBorder = borders.getRight();
			CTBorder vborder = borders.getInsideV();
			CTBorder hborder = borders.getInsideH();
			topBorder.setVal(STBorder.Enum.forString("double"));
			leftBorder.setVal(STBorder.Enum.forString("double"));
			rightBorder.setVal(STBorder.Enum.forString("double"));
			vborder.setVal(STBorder.Enum.forString("single"));
			hborder.setVal(STBorder.Enum.forString("double"));
			
			
			//表格第一行
			XWPFTableRow comTableRowOne = ComTable.getRow(0);
			XWPFTableCell headerCell = comTableRowOne.getCell(0);
			cellCentre(headerCell);
			headerCell.setText("序号 ");
			
			headerCell = comTableRowOne.addNewTableCell();
			cellCentre(headerCell);
			headerCell.setText("文件标题");
			headerCell =comTableRowOne.addNewTableCell();
			cellCentre(headerCell);
			headerCell.setText("批示指示内容");
			headerCell =comTableRowOne.addNewTableCell();
			cellCentre(headerCell);
			headerCell.setText("督办落实情况");
			headerCell = comTableRowOne.addNewTableCell();
			cellCentre(headerCell);
			headerCell .setText("办理状态");
			headerCell = comTableRowOne.addNewTableCell();
			cellCentre(headerCell);
			headerCell.setText("督办单位/人员");
					
	        XWPFTableRow comTableRowOther = ComTable.createRow();
	        XWPFTableCell insertCell = comTableRowOther.getCell(0);
	        insertCell.setText("  已办结事项（共"+banjieNum+"项）");//已办结事项
			mergeCell(ComTable,1,0,6);	
		    int banjieIndex =1;
			for(int i=0;i<list.size();i++){
				//表格内容行
				Map<String, String> dataMap = list.get(i);
				XWPFTableRow comTableRowTwo = ComTable.createRow();
				XWPFTableCell bodyCell = comTableRowTwo.getCell(0);
				cellCentre(bodyCell);
				bodyCell.setText(String.valueOf(banjieIndex++));//序号
				bodyCell = comTableRowTwo.getCell(1);
				cellCentre(bodyCell);
				bodyCell.setText(dataMap.get("docTitle"));//文件标题
				bodyCell = comTableRowTwo.getCell(2);
				cellleft(bodyCell);
				bodyCell.setText(dataMap.get("leaderComment"));//批示指示内容
				bodyCell = comTableRowTwo.getCell(3);
				cellleft(bodyCell);
				bodyCell.setText(dataMap.get("replyComment"));//督办落实情况
				bodyCell = comTableRowTwo.getCell(4);
				cellCentre(bodyCell);
				bodyCell.setText(dataMap.get("status"));//办理状态
				bodyCell = comTableRowTwo.getCell(5);
				cellCentre(bodyCell);
				bodyCell.setText(dataMap.get("subInfoComment"));//承办单位 人员
				
			}
			XWPFTableRow comTableRowOther2 = ComTable.createRow();
			XWPFTableCell insertCell2 = comTableRowOther2.getCell(0);
			insertCell2.setText("  未办结事项（共"+weibanjieNum+"项）");//未办结事项
			mergeCell(ComTable,banjieNum+2,0,6);
		    int weibanjieIndex =1;
			for(int i=0;i<list.size();i++){
				//表格内容行
				Map<String, String> dataMap = list.get(i);
				XWPFTableRow comTableRowTwo = ComTable.createRow();
				XWPFTableCell bodyCell = comTableRowTwo.getCell(0);
				cellCentre(bodyCell);
				bodyCell.setText(String.valueOf(weibanjieIndex++));//序号
				bodyCell = comTableRowTwo.getCell(1);
				cellCentre(bodyCell);
				bodyCell.setText(dataMap.get("docTitle"));//文件标题
				bodyCell = comTableRowTwo.getCell(2);
				cellleft(bodyCell);
				bodyCell.setText(dataMap.get("leaderComment"));//批示指示内容
				bodyCell = comTableRowTwo.getCell(3);
				cellleft(bodyCell);
				bodyCell.setText(dataMap.get("replyComment"));//督办落实情况
				bodyCell = comTableRowTwo.getCell(4);
				cellCentre(bodyCell);
				bodyCell.setText(dataMap.get("status"));//办理状态
				bodyCell = comTableRowTwo.getCell(5);
				cellCentre(bodyCell);
				bodyCell.setText(dataMap.get("subInfoComment"));//承办单位 人员				
			}
		
			
			
			
			
			fout = new FileOutputStream(fileName);
			document.write(fout);
			fout.flush();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (fout != null) {
			fout.close();
		}
	}
	return new FileInputStream(fileName);
        
	}

	private void setTableWith(XWPFTable table,String width) {
        CTTbl ttbl = table.getCTTbl();
         CTTblPr tblpr= ttbl.getTblPr()==null? ttbl.addNewTblPr():ttbl.getTblPr();
         CTTblWidth tblWith=tblpr.isSetTblW()?tblpr.getTblW():tblpr.addNewTblW();
         CTJc cTJc = tblpr.addNewJc();
         cTJc.setVal(STJc.Enum.forString("center"));
         tblWith.setW(new BigInteger(width));
         tblWith.setType(STTblWidth.DXA);
	}

	
	private void cellCentre(XWPFTableCell cell) {
		CTTc cttc = cell.getCTTc();
		CTTcPr addNewTcPr = cttc.addNewTcPr();
		addNewTcPr.addNewVAlign().setVal(STVerticalJc.CENTER);
		cttc.getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
	}
	private void cellleft(XWPFTableCell cell) {
		CTTc cttc = cell.getCTTc();
		CTTcPr addNewTcPr = cttc.addNewTcPr();
		addNewTcPr.addNewVAlign().setVal(STVerticalJc.CENTER);
		cttc.getPList().get(0).addNewPPr().addNewJc().setVal(STJc.LEFT);
	}
	
	private void mergeCell(XWPFTable table, int row, int fromCell, int toCell) {
		if (row > 0) {
			for (int cellIndex = fromCell; cellIndex <= toCell; cellIndex++) {
				XWPFTableCell cell = table.getRow(row).getCell(cellIndex);
				if (cellIndex == fromCell) {
					cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.RESTART);
				} else {
					cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.CONTINUE);
				}
			}
		}
	}
}
	


