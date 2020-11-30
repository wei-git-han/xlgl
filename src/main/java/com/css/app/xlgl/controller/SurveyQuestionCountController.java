package com.css.app.xlgl.controller;

import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.app.xlgl.service.SurveyQuestionAnswerService;
import com.css.app.xlgl.service.SurveyQuestionCountService;
import com.css.base.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app/surverycount")
public class SurveyQuestionCountController {
    @Autowired
    private SurveyQuestionCountService surveyQuestionCountService;

    @Autowired
    private SurveyQuestionAnswerService surveyQuestionAnswerService;

    @Autowired
    private BaseAppUserService baseAppUserService;
    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping("/countList")
    public void countList(String serveyQuestionId,String sex,String olds,String area){
        JSONObject surveyQuestionList = surveyQuestionCountService.querySurveyQuestionCountList(serveyQuestionId,sex,olds,area);
        Response.json("surveyQuestionList",surveyQuestionList);
    }
}
