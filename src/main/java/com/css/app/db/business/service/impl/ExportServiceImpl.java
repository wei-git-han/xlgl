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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPageOrientation;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;
import org.springframework.stereotype.Service;

import com.css.app.db.business.service.ExportService;
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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPageOrientation;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;
import org.springframework.stereotype.Service;
import com.css.app.db.business.service.ExportService;
import com.css.app.db.business.service.ExportService2;
/**
 * wps相关操作类
 * @author weizy
 *
 */
@Service("exportServiceImpl")
public class ExportServiceImpl implements ExportService2{
    @Override
	public  FileInputStream exportWPSdoc(List<Map<String, String>> list,String fileName,String docTypeId) throws IOException {
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
			if (docTypeId != null && "1".equals(docTypeId)) {// 军委主席重要批示指示
				packJWZXData(list, document);
			} else if (docTypeId != null && "2".equals(docTypeId)) {// 军委首长重要批示指示
				packJWSZData(list, document);
			} else if (docTypeId != null && "3".equals(docTypeId)) {// 重要决策部署分工
				packBNData(list, document);
			} else if (docTypeId != null && "4".equals(docTypeId)) {// 部领导批示指示
				packBLDData(list, document);
			} else if (docTypeId != null && "5".equals(docTypeId)) {// 部内重要工作分工
				packZYJCData(list, document);
			} else if (docTypeId != null && "6".equals(docTypeId)) {// 其他重要工作
				packQTData(list, document);
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

    //JW主席批示指示督办落实情况表 -1
	private void packJWZXData(List<Map<String, String>> list, XWPFDocument document) {
		//标题部分
		XWPFParagraph titleParagraph = document.createParagraph();
		titleParagraph.setAlignment(ParagraphAlignment.CENTER);	 
		XWPFRun titleParagraphRun = titleParagraph.createRun();
		titleParagraphRun.setText("军委主席批示指示督办落实情况表");
		titleParagraphRun.setColor("000000");
		titleParagraphRun.setFontSize(20);
						
		//基本信息表格
		XWPFTable infoTable = document.createTable(1,3);
		setTableWith(infoTable,"11000");
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
		setTableWith(ComTable,"10000");
		CTTbl ctTbl = ComTable.getCTTbl();
		CTTblGrid addNewTblGrid = ctTbl.addNewTblGrid();
      String[] colWidths=new String[]{"400","800","1500","4200","2000","1100","1000"};
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

		headerCell =comTableRowOne.addNewTableCell();
		cellCentre(headerCell);
		headerCell.setText("军委办件号");
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
		headerCell.setText("承办单位人员");

		for(int i=0;i<list.size();i++){
		        //表格内容行
			    Map<String, String> dataMap = list.get(i);
		        XWPFTableRow comTableRowTwo = ComTable.createRow();
		        XWPFTableCell bodyCell = comTableRowTwo.getCell(0);
		        cellCentre(bodyCell);
		        bodyCell.setText(String.valueOf(i+1));//序号
		        bodyCell = comTableRowTwo.getCell(1);
		        cellCentre(bodyCell);
		        bodyCell.setText(dataMap.get("banjianNumber"));//办件号
		        bodyCell = comTableRowTwo.getCell(2);
		        cellCentre(bodyCell);
		        bodyCell.setText(dataMap.get("docTitle"));//文件标题
		        bodyCell = comTableRowTwo.getCell(3);
		        cellleft(bodyCell);
		        bodyCell.setText(dataMap.get("leaderComment"));//批示指示内容
		        bodyCell = comTableRowTwo.getCell(4);
		        cellleft(bodyCell);
		        bodyCell.setText(dataMap.get("replyComment"));//督办落实情况
		        bodyCell = comTableRowTwo.getCell(5);
		        cellCentre(bodyCell);
		        bodyCell.setText(dataMap.get("status"));//办理状态
		        bodyCell = comTableRowTwo.getCell(6);
		        cellCentre(bodyCell);
		        bodyCell.setText(dataMap.get("subInfoComment"));//承办单位 人员

		}
	}
	//JW首长批示指示督办落实情况表-2
	private void packJWSZData(List<Map<String, String>> list, XWPFDocument document) {
		//标题部分
		XWPFParagraph titleParagraph = document.createParagraph();
		titleParagraph.setAlignment(ParagraphAlignment.CENTER);	 
		XWPFRun titleParagraphRun = titleParagraph.createRun();
		titleParagraphRun.setText("军委首长批示指示督办落实情况表");
		titleParagraphRun.setColor("000000");
		titleParagraphRun.setFontSize(20);
		
		//基本信息表格
		XWPFTable infoTable = document.createTable(1,3);
		setTableWith(infoTable,"11000");
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
		setTableWith(ComTable,"10000");
		CTTbl ctTbl = ComTable.getCTTbl();
		CTTblGrid addNewTblGrid = ctTbl.addNewTblGrid();
		String[] colWidths=new String[]{"400","800","1500","4200","2000","1100","1000"};
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
		
		headerCell =comTableRowOne.addNewTableCell();
		cellCentre(headerCell);
		headerCell.setText("军委办件号");
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
		headerCell.setText("承办单位人员");
		
		for(int i=0;i<list.size();i++){
			//表格内容行
			Map<String, String> dataMap = list.get(i);
			XWPFTableRow comTableRowTwo = ComTable.createRow();
			XWPFTableCell bodyCell = comTableRowTwo.getCell(0);
			cellCentre(bodyCell);
			bodyCell.setText(String.valueOf(i+1));//序号
			bodyCell = comTableRowTwo.getCell(1);
			cellCentre(bodyCell);
			bodyCell.setText(dataMap.get("banjianNumber"));//办件号
			bodyCell = comTableRowTwo.getCell(2);
			cellCentre(bodyCell);
			bodyCell.setText(dataMap.get("docTitle"));//文件标题
			bodyCell = comTableRowTwo.getCell(3);
			cellleft(bodyCell);
			bodyCell.setText(dataMap.get("leaderComment"));//批示指示内容
			bodyCell = comTableRowTwo.getCell(4);
			cellleft(bodyCell);
			bodyCell.setText(dataMap.get("replyComment"));//督办落实情况
			bodyCell = comTableRowTwo.getCell(5);
			cellCentre(bodyCell);
			bodyCell.setText(dataMap.get("status"));//办理状态
			bodyCell = comTableRowTwo.getCell(6);
			cellCentre(bodyCell);
			bodyCell.setText(dataMap.get("subInfoComment"));//承办单位 人员
			
		}
	}
	//ZBFZB重要工作分工落实情况表-3
	private void packZYJCData(List<Map<String, String>> list, XWPFDocument document) {
		//标题部分
		XWPFParagraph titleParagraph = document.createParagraph();
		titleParagraph.setAlignment(ParagraphAlignment.CENTER);	 
		XWPFRun titleParagraphRun = titleParagraph.createRun();
		titleParagraphRun.setText("装备发展部重要工作分工落实情况表");
		titleParagraphRun.setColor("000000");
		titleParagraphRun.setFontSize(20);
		
		//基本信息表格
		XWPFTable infoTable = document.createTable(1,3);
		setTableWith(infoTable,"11000");
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
		setTableWith(ComTable,"1100");
		CTTbl ctTbl = ComTable.getCTTbl();
		CTTblGrid addNewTblGrid = ctTbl.addNewTblGrid();
		String[] colWidths=new String[]{"400","1100","1000","1500","3900","2000","1100","1000"};
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
		
		headerCell =comTableRowOne.addNewTableCell();
		cellCentre(headerCell);
		headerCell.setText("印发时间");
		headerCell =comTableRowOne.addNewTableCell();
		cellCentre(headerCell);
		headerCell.setText("文件号");
		headerCell = comTableRowOne.addNewTableCell();
		cellCentre(headerCell);
		headerCell.setText("文件标题");
		headerCell =comTableRowOne.addNewTableCell();
		cellCentre(headerCell);
		headerCell.setText("工作分工内容");
		headerCell =comTableRowOne.addNewTableCell();
		cellCentre(headerCell);
		headerCell.setText("督办落实情况");
		headerCell = comTableRowOne.addNewTableCell();
		cellCentre(headerCell);
		headerCell .setText("办理状态");
		headerCell = comTableRowOne.addNewTableCell();
		cellCentre(headerCell);
		headerCell.setText("承办单位人员");
		
		for(int i=0;i<list.size();i++){
			//表格内容行
			Map<String, String> dataMap = list.get(i);
			XWPFTableRow comTableRowTwo = ComTable.createRow();
			XWPFTableCell bodyCell = comTableRowTwo.getCell(0);
			cellCentre(bodyCell);
			bodyCell.setText(String.valueOf(i+1));//序号
			bodyCell = comTableRowTwo.getCell(1);
			cellCentre(bodyCell);
			bodyCell.setText(dataMap.get("printDate"));//印发时间
			bodyCell = comTableRowTwo.getCell(2);
			cellCentre(bodyCell);
			bodyCell.setText(dataMap.get("banjianNumber"));//办件号
			bodyCell = comTableRowTwo.getCell(3);
			cellCentre(bodyCell);
			bodyCell.setText(dataMap.get("docTitle"));//文件标题
			bodyCell = comTableRowTwo.getCell(4);
			cellleft(bodyCell);
			bodyCell.setText(dataMap.get("jobContent"));//内容
			bodyCell = comTableRowTwo.getCell(5);
			cellleft(bodyCell);
			bodyCell.setText(dataMap.get("replyComment"));//督办落实情况
			bodyCell = comTableRowTwo.getCell(6);
			cellCentre(bodyCell);
			bodyCell.setText(dataMap.get("status"));//办理状态
			bodyCell = comTableRowTwo.getCell(7);
			cellCentre(bodyCell);
			bodyCell.setText(dataMap.get("subInfoComment"));//承办单位 人员
			
		}
	}
	//ZBFZB领导批示指示督办落实情况表-4
	private void packBLDData(List<Map<String, String>> list, XWPFDocument document) {
		//标题部分
		XWPFParagraph titleParagraph = document.createParagraph();
		titleParagraph.setAlignment(ParagraphAlignment.CENTER);	 
		XWPFRun titleParagraphRun = titleParagraph.createRun();
		titleParagraphRun.setText("装备发展部领导批示指示督办落实情况表");
		titleParagraphRun.setColor("000000");
		titleParagraphRun.setFontSize(20);
		
		//基本信息表格
		XWPFTable infoTable = document.createTable(1,3);
		setTableWith(infoTable,"11000");
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
		setTableWith(ComTable,"10000");
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
		
//		headerCell =comTableRowOne.addNewTableCell();
//		cellCentre(headerCell);
//		headerCell.setText("军委办件号");
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
		headerCell.setText("承办单位人员");
		
		for(int i=0;i<list.size();i++){
			//表格内容行
			Map<String, String> dataMap = list.get(i);
			XWPFTableRow comTableRowTwo = ComTable.createRow();
			XWPFTableCell bodyCell = comTableRowTwo.getCell(0);
			cellCentre(bodyCell);
			bodyCell.setText(String.valueOf(i+1));//序号
//			bodyCell = comTableRowTwo.getCell(1);
//			cellCentre(bodyCell);
//			bodyCell.setText(dataMap.get("banjianNumber"));//办件号
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
	}
	//党中央、中央军委、国务院重要决策部署分工落实情况表-3
	private void packBNData(List<Map<String, String>> list, XWPFDocument document) {
		//标题部分
		XWPFParagraph titleParagraph = document.createParagraph();
		titleParagraph.setAlignment(ParagraphAlignment.CENTER);	 
		XWPFRun titleParagraphRun = titleParagraph.createRun();
		titleParagraphRun.setText("党中央、中央军委、国务院重要决策部署分工落实情况表");
		titleParagraphRun.setColor("000000");
		titleParagraphRun.setFontSize(20);
		
		//基本信息表格
		XWPFTable infoTable = document.createTable(1,3);
		setTableWith(infoTable,"11000");
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
		setTableWith(ComTable,"1100");
		CTTbl ctTbl = ComTable.getCTTbl();
		CTTblGrid addNewTblGrid = ctTbl.addNewTblGrid();
		String[] colWidths=new String[]{"400","1100","1000","1500","3900","2000","1100","1000"};
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
		
		headerCell =comTableRowOne.addNewTableCell();
		cellCentre(headerCell);
		headerCell.setText("印发时间");
		headerCell =comTableRowOne.addNewTableCell();
		cellCentre(headerCell);
		headerCell.setText("文件号");
		headerCell = comTableRowOne.addNewTableCell();
		cellCentre(headerCell);
		headerCell.setText("文件标题");
		headerCell =comTableRowOne.addNewTableCell();
		cellCentre(headerCell);
		headerCell.setText("工作分工内容");
		headerCell =comTableRowOne.addNewTableCell();
		cellCentre(headerCell);
		headerCell.setText("督办落实情况");
		headerCell = comTableRowOne.addNewTableCell();
		cellCentre(headerCell);
		headerCell .setText("办理状态");
		headerCell = comTableRowOne.addNewTableCell();
		cellCentre(headerCell);
		headerCell.setText("承办单位人员");
		
		for(int i=0;i<list.size();i++){
			//表格内容行
			Map<String, String> dataMap = list.get(i);
			XWPFTableRow comTableRowTwo = ComTable.createRow();
			XWPFTableCell bodyCell = comTableRowTwo.getCell(0);
			cellCentre(bodyCell);
			bodyCell.setText(String.valueOf(i+1));//序号
			bodyCell = comTableRowTwo.getCell(1);
			cellCentre(bodyCell);
			bodyCell.setText(dataMap.get("printDate"));//印发时间
			bodyCell = comTableRowTwo.getCell(2);
			cellCentre(bodyCell);
			bodyCell.setText(dataMap.get("banjianNumber"));//办件号
			bodyCell = comTableRowTwo.getCell(3);
			cellCentre(bodyCell);
			bodyCell.setText(dataMap.get("docTitle"));//文件标题
			bodyCell = comTableRowTwo.getCell(4);
			cellleft(bodyCell);
			bodyCell.setText(dataMap.get("jobContent"));//内容
			bodyCell = comTableRowTwo.getCell(5);
			cellleft(bodyCell);
			bodyCell.setText(dataMap.get("replyComment"));//督办落实情况
			bodyCell = comTableRowTwo.getCell(6);
			cellCentre(bodyCell);
			bodyCell.setText(dataMap.get("status"));//办理状态
			bodyCell = comTableRowTwo.getCell(7);
			cellCentre(bodyCell);
			bodyCell.setText(dataMap.get("subInfoComment"));//承办单位 人员
			
		}
	}
	//其他重要工作落实情况表-6
	private void packQTData(List<Map<String, String>> list, XWPFDocument document) {
		//标题部分
		XWPFParagraph titleParagraph = document.createParagraph();
		titleParagraph.setAlignment(ParagraphAlignment.CENTER);	 
		XWPFRun titleParagraphRun = titleParagraph.createRun();
		titleParagraphRun.setText("其他重要工作落实情况表");
		titleParagraphRun.setColor("000000");
		titleParagraphRun.setFontSize(20);
		
		//基本信息表格
		XWPFTable infoTable = document.createTable(1,3);
		setTableWith(infoTable,"11000");
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
		setTableWith(ComTable,"1100");
		CTTbl ctTbl = ComTable.getCTTbl();
		CTTblGrid addNewTblGrid = ctTbl.addNewTblGrid();
		String[] colWidths=new String[]{"400","1100","1000","1500","3800","2100","1100","1000"};
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
		
		headerCell =comTableRowOne.addNewTableCell();
		cellCentre(headerCell);
		headerCell.setText("印发时间");
		headerCell =comTableRowOne.addNewTableCell();
		cellCentre(headerCell);
		headerCell.setText("文件号");
		headerCell = comTableRowOne.addNewTableCell();
		cellCentre(headerCell);
		headerCell.setText("文件标题");
		headerCell =comTableRowOne.addNewTableCell();
		cellCentre(headerCell);
		headerCell.setText("工作分工内容");
		headerCell =comTableRowOne.addNewTableCell();
		cellCentre(headerCell);
		headerCell.setText("督办落实情况");
		headerCell = comTableRowOne.addNewTableCell();
		cellCentre(headerCell);
		headerCell .setText("办理状态");
		headerCell = comTableRowOne.addNewTableCell();
		cellCentre(headerCell);
		headerCell.setText("承办单位人员");
		
		for(int i=0;i<list.size();i++){
			//表格内容行
			Map<String, String> dataMap = list.get(i);
			XWPFTableRow comTableRowTwo = ComTable.createRow();
			XWPFTableCell bodyCell = comTableRowTwo.getCell(0);
			cellCentre(bodyCell);
			bodyCell.setText(String.valueOf(i+1));//序号
			bodyCell = comTableRowTwo.getCell(1);
			cellCentre(bodyCell);
			bodyCell.setText(dataMap.get("printDate"));//印发时间
			bodyCell = comTableRowTwo.getCell(2);
			cellCentre(bodyCell);
			bodyCell.setText(dataMap.get("banjianNumber"));//办件号
			bodyCell = comTableRowTwo.getCell(3);
			cellCentre(bodyCell);
			bodyCell.setText(dataMap.get("docTitle"));//文件标题
			bodyCell = comTableRowTwo.getCell(4);
			cellleft(bodyCell);
			bodyCell.setText(dataMap.get("jobContent"));//批示指示内容
			bodyCell = comTableRowTwo.getCell(5);
			cellleft(bodyCell);
			bodyCell.setText(dataMap.get("replyComment"));//督办落实情况
			bodyCell = comTableRowTwo.getCell(6);
			cellCentre(bodyCell);
			bodyCell.setText(dataMap.get("status"));//办理状态
			bodyCell = comTableRowTwo.getCell(7);
			cellCentre(bodyCell);
			bodyCell.setText(dataMap.get("subInfoComment"));//承办单位 人员
			
		}
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
	

}
	


