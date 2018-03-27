package com.example.demo.ExcelModel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

/**
 * Created by huqifeng on 2017/12/12 11:39.
 */
@ExcelTarget("teacherEntity")
public class TeacherEntity implements java.io.Serializable {
    /** name */
    @Excel(name = "主讲老师_teacherEntity,代课老师_absent", orderNum = "1", mergeVertical = true,needMerge=true,isImportField = "true_major,true_absent")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
