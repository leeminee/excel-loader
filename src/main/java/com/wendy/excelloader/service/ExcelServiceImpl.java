package com.wendy.excelloader.service;

import com.wendy.excelloader.model.Alarm;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ExcelServiceImpl implements ExcelService {

    @Override
    public void createExcel(Workbook workbook, CellStyle headStyle, CellStyle bodyStyle, HttpServletResponse response) {

        Sheet sheet = workbook.createSheet("엑셀샘플양식");
        alarmStatus(sheet, headStyle, bodyStyle, response);

        try {
            workbook.write(response.getOutputStream());
            workbook.close();
        } catch (IOException e) {
            log.error("excel write fail");
            log.error("error message : " + e.getMessage());
        }

    }

    @Override
    public void alarmStatus(Sheet sheet, CellStyle headStyle, CellStyle bodyStyle, HttpServletResponse response) {

        String[] alarmMessage = {"PROVISION SERVER DISCONNECTED", "SWITCH PORT DOWN"};
        String[] alarmHost = {"host1","2","0"};
        List<Alarm> alarmList = new ArrayList<>();
        Alarm alarm = new Alarm();

        alarmList.add(new Alarm("ITEM", alarmMessage, alarm.getAlarmCount()));
        Map<String, String[]> map = new HashMap<>();


        Cell cell = null;
        int lastCell;
        int rowNumber = 0;

        Row row = sheet.createRow(++rowNumber);

        cell = row.createCell(1);
        cell.setCellStyle(headStyle);
        cell.setCellValue("ITEM");

        System.out.println("alarmMessage length : "+alarmMessage.length);

        for (int i = 0; i < alarmMessage.length; i++) {
            cell = row.createCell(i+2);
            cell.setCellStyle(headStyle);
            cell.setCellValue(alarmMessage[i]);
        }
        lastCell = alarmMessage.length+2;
        System.out.println("lastCell : "+lastCell);

        cell = row.createCell(lastCell);
        cell.setCellStyle(headStyle);
        cell.setCellValue("총합계");
        
        // --------------------------------

        String firstCellFormula = "C3";
        String lastCellFormula = "D3";

        for (rowNumber = 0; rowNumber < alarmHost.length; rowNumber++) {
            row = sheet.createRow(rowNumber+2);
            for (int i = 0; i < lastCell; i++) {
                if(i==lastCell-1){
                    cell = row.createCell(lastCell);
                    cell.setCellStyle(bodyStyle);
                    cell.setCellFormula(String.format("SUM(%s:%s)", firstCellFormula, lastCellFormula));
                } else {
                    cell = row.createCell(i + 1);
                    cell.setCellStyle(bodyStyle);
                    cell.setCellValue(alarmHost[i]);
                    if(i==1){
//                        cell.setCellType(CellType.NUMERIC);
                        System.out.println(">>> "+cell.getCellFormula());
//                        firstCellFormula = cell.getCellFormula();
                    } else if(i==lastCell-2){
//                        cell.setCellType(CellType.NUMERIC);
                        System.out.println(">>> "+cell.getCellFormula());
//                        lastCellFormula = cell.getCellFormula();
                    }
                }
            }
        }

//        row = sheet.createRow(++rowNumber);
//        cell = row.createCell(1);
//        cell.setCellStyle(bodyStyle);
//        cell.setCellValue("host1");
//
//        cell = row.createCell(2);
//        cell.setCellStyle(bodyStyle);
//        cell.setCellValue(2);
//
//        cell = row.createCell(3);
//        cell.setCellStyle(bodyStyle);
//        cell.setCellValue(0);

//        cell = row.createCell(4);
//        cell.setCellStyle(bodyStyle);
//        cell.setCellFormula("SUM(C3:D3)");


    }

    @Override
    public void faultStatus(Sheet sheet, CellStyle headStyle, CellStyle bodyStyle) {

    }


}
