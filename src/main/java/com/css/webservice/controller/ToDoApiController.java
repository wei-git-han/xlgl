package com.css.webservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.app.db.business.entity.SubDocInfo;
import com.css.app.db.business.service.SubDocInfoService;
import com.css.app.db.config.service.AdminSetService;
import com.css.app.db.util.DbDocStatusDefined;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;

@RestController
@RequestMapping("/api")
public class ToDoApiController {
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
    @RequestMapping("/db/todo")
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
        dbNumSum = grdbNum + jndbNum;
        Response.json("dbNumSum", dbNumSum);
    }


}
