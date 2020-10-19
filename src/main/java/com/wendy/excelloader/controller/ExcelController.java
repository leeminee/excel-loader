package com.wendy.excelloader.controller;

import com.wendy.excelloader.service.ExcelServiceImpl;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController // @Contorller + @ResponseBody
public class ExcelController {

    private final ExcelServiceImpl excelServiceImpl;

    public ExcelController(ExcelServiceImpl excelServiceImpl) {
        this.excelServiceImpl = excelServiceImpl;
    }

    @GetMapping("/excel/create")
    public void createExcel(HttpServletResponse response) {

        XSSFWorkbook workbook = new XSSFWorkbook();

//        workbook.createSheet("엑셀양식 샘플");

        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition","attachment; filename= sample.xlsx");

        CellStyle headStyle = workbook.createCellStyle();

        headStyle.setBorderTop(BorderStyle.THIN);
        headStyle.setBorderBottom(BorderStyle.THIN);
        headStyle.setBorderLeft(BorderStyle.THIN);
        headStyle.setBorderRight(BorderStyle.THIN);

        headStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.LEMON_CHIFFON.getIndex());
        headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//        headStyle.setFillForegroundColor(new XSSFColor(new byte[]{(byte)255, (byte)255, (byte)0}));

        headStyle.setAlignment(HorizontalAlignment.CENTER);

        CellStyle bodyStyle = workbook.createCellStyle();
        bodyStyle.setBorderTop(BorderStyle.THIN);
        bodyStyle.setBorderBottom(BorderStyle.THIN);
        bodyStyle.setBorderLeft(BorderStyle.THIN);
        bodyStyle.setBorderRight(BorderStyle.THIN);


        excelServiceImpl.createExcel(workbook, headStyle, bodyStyle, response);
    }
}
