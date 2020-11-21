package com.css.app.xlgl.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.app.xlgl.entity.SurveyCountQuestion;
import com.css.app.xlgl.entity.SurveyQuestion;
import com.css.app.xlgl.entity.SurveyQuestionAnswer;
import com.css.app.xlgl.entity.SurveyQuestionTopicOption;
import com.css.app.xlgl.service.SurveyQuestionAnswerService;
import com.css.app.xlgl.service.SurveyQuestionCountService;
import com.css.app.xlgl.service.SurveyQuestionService;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.github.pagehelper.PageHelper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void countList(String serveyQuestionId,String ids){
        JSONObject surveyQuestionList = surveyQuestionCountService.querySurveyQuestionCountList(serveyQuestionId,ids);
        Response.json("surveyQuestionList",surveyQuestionList);
//        Map<String, Object> map = new HashMap<>();
//        JSONObject result = new JSONObject();
//        JSONArray jsons = new JSONArray();
//        JSONObject json = new JSONObject();
//
        //top
//        List<SurveyCountQuestion> surveyCountQuestion = surveyQuestionCountService.queryTopList();
//        int count = baseAppUserService.queryTotal(map);
//
//        if(surveyCountQuestion != null && surveyCountQuestion.size()>0){
//            int shouji = Integer.valueOf(surveyCountQuestion.get(0).getCount());
//            json.put("shouji", shouji);
//            json.put("weixie", count - shouji);
//            json.put("startTime", surveyCountQuestion.get(0).getStartTime());
//            json.put("endTime", surveyCountQuestion.get(0).getEndTime());
//            jsons.add(json);
//            result.put("top", jsons);
//            //题目
//            List<SurveyQuestionAnswer> surveyQuestionList = surveyQuestionAnswerService.queryCountAnswerList(map);
//
//            for(SurveyQuestionAnswer anser : surveyQuestionList){
//                json = new JSONObject();
//                json.put("timu",anser.getQuestionContent());
//                //选项内容
//                List<SurveyQuestionAnswer> surveyOptionList = surveyQuestionAnswerService.queryCountOptionList(map);
//                for(SurveyQuestionAnswer option : surveyOptionList){
//                    JSONArray xuxiang = new JSONArray();
//                    JSONObject xu = new JSONObject();
//                    xu.put("","");
//                    json.put("chirld",xuxiang);
//                }
//            }
//        }


//        Response.json(result);
    }
}
