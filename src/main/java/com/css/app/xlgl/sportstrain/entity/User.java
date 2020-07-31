package com.css.app.xlgl.sportstrain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class User implements Serializable{

	private String KEYID;
	
	private String USERID;
	
	private String USERPWD;
	
	private String USERNAME;
	
	private int IS_EDITING;
	
	private String ORGID;
	
	private String ORGNAME;
	
	private String ADDRESS;
	
	private String POSTCODE;
	
	private String MOBILE;
	
	private String TELEPHONE;
	
	private String EMAIL;
	
	private String IDNUMBER;
	
	private String REMARK;
	
	private String INSERTUSERID;
	
	private String INSERTTIME;
	
	private String UPDATEUSERID;
	
	private String UPDATETIME;
	
	private String ISORNOT;
	
	private String ERRORLOCK;
	
	private BigDecimal SORTID;
	
	private String LOGINIP;
	
	private String USERTYPE;
	
	private String SECRETLEVEL;
	
	private String EXT1;
	private String EXT2;
	private String EXT3;
	private int EXT4;
	private BigDecimal EXT5;
	
	private String JKSECLEVEL;
	
	private String JKDUTY;
	
	private String JKRANK;
	
	private String STATUS;
	
	public String getKEYID() {
		return KEYID;
	}
	public void setKEYID(String kEYID) {
		KEYID = kEYID;
	}
	public String getUSERID() {
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	public String getUSERPWD() {
		return USERPWD;
	}
	public void setUSERPWD(String uSERPWD) {
		USERPWD = uSERPWD;
	}
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public int getIS_EDITING() {
		return IS_EDITING;
	}
	public void setIS_EDITING(int iS_EDITING) {
		IS_EDITING = iS_EDITING;
	}
	public String getORGID() {
		return ORGID;
	}
	public void setORGID(String oRGID) {
		ORGID = oRGID;
	}
	public String getORGNAME() {
		return ORGNAME;
	}
	public void setORGNAME(String oRGNAME) {
		ORGNAME = oRGNAME;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public String getPOSTCODE() {
		return POSTCODE;
	}
	public void setPOSTCODE(String pOSTCODE) {
		POSTCODE = pOSTCODE;
	}
	public String getMOBILE() {
		return MOBILE;
	}
	public void setMOBILE(String mOBILE) {
		MOBILE = mOBILE;
	}
	public String getTELEPHONE() {
		return TELEPHONE;
	}
	public void setTELEPHONE(String tELEPHONE) {
		TELEPHONE = tELEPHONE;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getIDNUMBER() {
		return IDNUMBER;
	}
	public void setIDNUMBER(String iDNUMBER) {
		IDNUMBER = iDNUMBER;
	}
	public String getREMARK() {
		return REMARK;
	}
	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}
	public String getINSERTUSERID() {
		return INSERTUSERID;
	}
	public void setINSERTUSERID(String iNSERTUSERID) {
		INSERTUSERID = iNSERTUSERID;
	}
	public String getINSERTTIME() {
		return INSERTTIME;
	}
	public void setINSERTTIME(String iNSERTTIME) {
		INSERTTIME = iNSERTTIME;
	}
	public String getUPDATEUSERID() {
		return UPDATEUSERID;
	}
	public void setUPDATEUSERID(String uPDATEUSERID) {
		UPDATEUSERID = uPDATEUSERID;
	}
	public String getUPDATETIME() {
		return UPDATETIME;
	}
	public void setUPDATETIME(String uPDATETIME) {
		UPDATETIME = uPDATETIME;
	}
	public String getISORNOT() {
		return ISORNOT;
	}
	public void setISORNOT(String iSORNOT) {
		ISORNOT = iSORNOT;
	}
	public String getERRORLOCK() {
		return ERRORLOCK;
	}
	public void setERRORLOCK(String eRRORLOCK) {
		ERRORLOCK = eRRORLOCK;
	}
	public BigDecimal getSORTID() {
		return SORTID;
	}
	public void setSORTID(BigDecimal sORTID) {
		SORTID = sORTID;
	}
	public String getLOGINIP() {
		return LOGINIP;
	}
	public void setLOGINIP(String lOGINIP) {
		LOGINIP = lOGINIP;
	}
	public String getUSERTYPE() {
		return USERTYPE;
	}
	public void setUSERTYPE(String uSERTYPE) {
		USERTYPE = uSERTYPE;
	}
	public String getSECRETLEVEL() {
		return SECRETLEVEL;
	}
	public void setSECRETLEVEL(String sECRETLEVEL) {
		SECRETLEVEL = sECRETLEVEL;
	}
	public String getEXT1() {
		return EXT1;
	}
	public void setEXT1(String eXT1) {
		EXT1 = eXT1;
	}
	public String getEXT2() {
		return EXT2;
	}
	public void setEXT2(String eXT2) {
		EXT2 = eXT2;
	}
	public String getEXT3() {
		return EXT3;
	}
	public void setEXT3(String eXT3) {
		EXT3 = eXT3;
	}
	public int getEXT4() {
		return EXT4;
	}
	public void setEXT4(int eXT4) {
		EXT4 = eXT4;
	}
	public BigDecimal getEXT5() {
		return EXT5;
	}
	public void setEXT5(BigDecimal eXT5) {
		EXT5 = eXT5;
	}
	public String getJKSECLEVEL() {
		return JKSECLEVEL;
	}
	public void setJKSECLEVEL(String jKSECLEVEL) {
		JKSECLEVEL = jKSECLEVEL;
	}
	public String getJKDUTY() {
		return JKDUTY;
	}
	public void setJKDUTY(String jKDUTY) {
		JKDUTY = jKDUTY;
	}
	public String getJKRANK() {
		return JKRANK;
	}
	public void setJKRANK(String jKRANK) {
		JKRANK = jKRANK;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

}
