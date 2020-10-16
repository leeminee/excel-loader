package com.wendy.excelloader.service;

import com.wendy.excelloader.ExcelLoaderApplication;
import com.wendy.excelloader.model.Alarm;
import net.sf.jxls.transformer.XLSTransformer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService{

    @Override
    public String createExcel() {

        HashMap<String, Object> map = new HashMap<>();
        String excelPath = ExcelLoaderApplication.class.getClassLoader().getResource("excel/excel-sample.xlsx").toString();
        System.out.println("excelPath = " + excelPath);

        XLSTransformer xlsTransformer = new XLSTransformer();

        List<Alarm> alarmHostList = new ArrayList<>();

        alarmHostList.add(new Alarm("message",1));


        return "hello";
    }
}
