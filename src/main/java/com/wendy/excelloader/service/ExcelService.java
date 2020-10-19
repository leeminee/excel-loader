package com.wendy.excelloader.service;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;

public interface ExcelService {

    void createExcel(Workbook workbook, CellStyle headStyle, CellStyle bodyStyle, HttpServletResponse response);
    void alarmStatus(Sheet sheet, CellStyle headStyle, CellStyle bodyStyle, HttpServletResponse response);
    void faultStatus(Sheet sheet, CellStyle headStyle, CellStyle bodyStyle);
}
