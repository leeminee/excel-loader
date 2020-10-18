package com.wendy.excelloader.controller;

import com.wendy.excelloader.service.ExcelServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController // @Contorller + @ResponseBody
public class ExcelController {

    private final ExcelServiceImpl excelServiceImpl;

    public ExcelController(ExcelServiceImpl excelServiceImpl) {
        this.excelServiceImpl = excelServiceImpl;
    }

    @GetMapping("/excel/create")
    public void createExcel(HttpServletRequest request, HttpServletResponse response) {

        excelServiceImpl.createExcel(request, response);
    }
}
