package com.css.app.db.business.controller;

import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.app.db.business.entity.SubDocInfo;
import com.css.app.db.business.service.SubDocInfoService;
import com.css.app.db.config.service.AdminSetService;
import com.css.app.db.util.DbDocStatusDefined;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/app/db/app")
public class DbappController {
    private final Logger logger = LoggerFactory.getLogger(DbappController.class);
    @Autowired
    private AdminSetService adminSetService;
    @Autowired
    private SubDocInfoService subDocInfoService;
    @Autowired
    private BaseAppUserService baseAppUserService;

    /**
     * 督办待办app
     */

    @ResponseBody
    @RequestMapping("/dbNumSum")
    public void dbNumSum() {
        int dbNumSum = 0;
        // 个人待办
        int grdbNum = 0;
        Map<String, Object> personalMap = new HashMap<>();
        String loginUserId = CurrentUser.getUserId();
        if (StringUtils.isNotBlank(loginUserId)) {
            personalMap.put("loginUserId", loginUserId);
        }
        personalMap.put("receiver", "receiver");
        List<SubDocInfo> subDocInfoPersonalList = subDocInfoService.queryPersonList1(personalMap);
        if (subDocInfoPersonalList != null && subDocInfoPersonalList.size() > 0) {
            grdbNum = subDocInfoPersonalList.size();
        }
        // 局内待办
        int jndbNum = 0;
        Map<String, Object> jumap = new HashMap<>();
        String orgId = baseAppUserService.getBareauByUserId(loginUserId);
        if (StringUtils.isNotBlank(orgId)) {
            jumap.put("orgId", orgId);
        }
        jumap.put("docStatus", DbDocStatusDefined.DAI_ZHUAN_BAN);
        // 查询列表数据
        List<SubDocInfo> subDocInfoList = subDocInfoService.queryList(jumap);
        if (subDocInfoList != null && subDocInfoList.size() > 0) {
            jndbNum = subDocInfoList.size();
        }
        // adminType（0:超级管理员 ;1：部管理员；2：局管理员；3：即是部管理员又是局管理员）
        String adminType = adminSetService.getAdminTypeByUserId(CurrentUser.getUserId());
        if (StringUtils.equals("1", adminType)) {
            dbNumSum = grdbNum;
        } else if (StringUtils.equals("2", adminType)) {
            dbNumSum = grdbNum + jndbNum;
        }
        Response.json("dbNumSum", dbNumSum);
    }

}
