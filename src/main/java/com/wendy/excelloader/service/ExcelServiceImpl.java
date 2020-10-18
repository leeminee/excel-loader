package com.wendy.excelloader.service;

import com.wendy.excelloader.ExcelLoaderApplication;
import com.wendy.excelloader.model.Alarm;
import lombok.extern.slf4j.Slf4j;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jxls.common.Context;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class ExcelServiceImpl implements ExcelService{

    @Override
    public void createExcel(HttpServletRequest request, HttpServletResponse re) {

        HashMap<String, Object> map = new HashMap<>();
        String excelPath = ExcelLoaderApplication.class.getClassLoader().getResource("excel/excel-sample.xlsx").getPath();
        log.info("excelPath = "+excelPath);

        XLSTransformer xlsTransformer = new XLSTransformer();

        List<Alarm> alarmHostList = new ArrayList<>();

        alarmHostList.add(new Alarm("host", "message", 1));



//        Context context = new Context();
//        context.putVar("alarmHostList", alarmHostList);




        try {
            xlsTransformer.transformXLS(excelPath, map, "/C:/Users/Minee/test/excel-loader.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

    }
}
