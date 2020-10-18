package com.wendy.excelloader.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ExcelService {

    void createExcel(HttpServletRequest request, HttpServletResponse response);
}
