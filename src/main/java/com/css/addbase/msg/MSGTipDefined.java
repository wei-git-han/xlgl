package com.css.addbase.msg;

public class MSGTipDefined {

	
//	MSG_ID			MSG_TITLE	MSG_CONTENT	MSG_REDIRECT	STATUS	STATUS_NAME
//	gwcl_sh			公文审核		您有需要审核的公文，请注意查收！		4		待XXX审核	
//	gwcl_shwc		公文审核		您有公文已被退回，请尽快修改!			5		XXX审核完成	
//	gwcl_sp			公文审批		您有需要审批的公文，请注意查收！		6		送XXX审批	
//	gwcl_spwc		公文审批									7		核文已通过	
//	gwcl_bj			公文办结									10		办结	
//	gwcl_zb			公文转办		您有需要审核的公文，请注意查收！		13		办公厅核文中	
//	gwcl_th			公文退回									14		院办已退回	
//	gwcl_ch			公文撤回									15		XXX已撤回	
//	gwcl_zhms_spwc	公文审批									17		XXX审批完成	
//	qj_withdraw		请销假管理		有请假申请被撤回					NULL	NULL	
//	gwcl_zaiban		公文在办		您收到待办公文，请您尽快办理！		18		在办	
//	gwcl_banjie		公文办结		您有公文已被办结	NULL			19		办结	
//	gwcl_qc			公文起草		NULL						1	拟制	
	public static String GWCL_SH_MSG_TITLE = "gwcl_sh";
	public static String GWCL_SHWC_MSG_TITLE = "gwcl_shwc";
	public static String GWCL_SP_MSG_TITLE = "gwcl_sp";
	public static String GWCL_SPWC_MSG_TITLE = "gwcl_spwc";
	public static String GWCL_BJ_MSG_TITLE = "gwcl_bj";
	public static String GWCL_ZB_MSG_TITLE = "gwcl_zb";
	public static String GWCL_TH_MSG_TITLE = "gwcl_th";
	public static String GWCL_CH_MSG_TITLE = "gwcl_ch";
	public static String GWCL_ZHMS_SPWC_MSG_TITLE = "gwcl_zhms_spwc";
	public static String GWCL_ZAIBAN_MSG_TITLE = "gwcl_zaiban";
	public static String GWCL_CUIBAN_MSG_TITLE = "gwcl_cuiban";
	public static String GWCL_BANJIE_MSG_TITLE = "gwcl_banjie";
	public static String GWCL_QC_MSG_TITLE = "gwcl_qc";
	public static String GWZHMS_MSG_TITLE = "gwcl_zb";
	public static String GWCL_THSH_MSG_TITLE = "gwcl_shth";
	public static String GWCL_GWLZJYBJ_MSG_TITLE = "gwlz_jianyibanjie";
	public static String GWCL_GWZBJYBJ_MSG_TITLE = "gwzb_jianyibanjie";
	public static String DZBMS_JYBJ_MSG_TITLE = "dzbms_bjgl_jianyibanjie";
	public static String GWCL_YZ_MSG_TITLE = "gwcl_csyz";
	//督查催办APP的
	public static String DCCB_BU_ZHUANBAN_MSG_TITLE = "dccb_buzhuanban";//部转办
	public static String DCCB_JU_ZHUANBAN_MSG_TITLE = "dccb_juzhuanban";//局转办
	public static String DCCB_SONGSHEN_MSG_TITLE = "dccb_songshen";//送审
	public static String DCCB_TUIHUI_MSG_TITLE = "dccb_tuihui";//返回修改
	public static String DCCB_CUIBAN_MSG_TITLE = "dccb_cuiban";//催办
}
