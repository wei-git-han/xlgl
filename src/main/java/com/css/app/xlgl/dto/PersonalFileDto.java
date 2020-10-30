package com.css.app.xlgl.dto;

import java.io.Serializable;
import java.util.List;

import com.css.app.xlgl.entity.PersonalFile;
import com.css.app.xlgl.entity.XlglMineStudy;
import com.css.app.xlgl.entity.XlglPhysical;

public class PersonalFileDto implements Serializable {

    //科目id
    private String examineSubjectId;
    //科目名称
    private String examineSubjectName;
    //
    private List<PersonalFile> list;

    private List<XlglPhysical> xlglPhysicalList;

    private List<XlglMineStudy> xlglMineStudyList;

    private String score;

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public List<XlglMineStudy> getXlglMineStudyList() {
        return xlglMineStudyList;
    }

    public void setXlglMineStudyList(List<XlglMineStudy> xlglMineStudyList) {
        this.xlglMineStudyList = xlglMineStudyList;
    }

    public List<XlglPhysical> getXlglPhysicalList() {
        return xlglPhysicalList;
    }

    public void setXlglPhysicalList(List<XlglPhysical> xlglPhysicalList) {
        this.xlglPhysicalList = xlglPhysicalList;
    }

    public String getExamineSubjectId() {
        return examineSubjectId;
    }

    public void setExamineSubjectId(String examineSubjectId) {
        this.examineSubjectId = examineSubjectId;
    }

    public String getExamineSubjectName() {
        return examineSubjectName;
    }

    public void setExamineSubjectName(String examineSubjectName) {
        this.examineSubjectName = examineSubjectName;
    }

    public List<PersonalFile> getList() {
        return list;
    }

    public void setList(List<PersonalFile> list) {
        this.list = list;
    }


}
