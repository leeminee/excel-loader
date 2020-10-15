package com.wendy.excelloader.service;

import org.springframework.stereotype.Service;

@Service
public class ExcelServiceImpl implements ExcelService{

    @Override
    public String createExcel() {
        return "hello";
    }
}
