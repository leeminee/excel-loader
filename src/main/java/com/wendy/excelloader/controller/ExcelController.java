package com.wendy.excelloader.controller;

import com.wendy.excelloader.service.ExcelServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class ExcelController {

    private final ExcelServiceImpl excelServiceImpl;

    public ExcelController(ExcelServiceImpl excelServiceImpl) {
        this.excelServiceImpl = excelServiceImpl;
    }

    @GetMapping("/excel/create")
    public String createExcel() {

        return excelServiceImpl.createExcel();
    }
}
