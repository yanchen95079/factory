package com.yc.demo.service;

import com.yc.demo.domain.ex.TbOrderGeneralExcelPojo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Yanchen
 * date 2021/8/12 14:03
 */
public interface ExcelService {
    void materialNumberEnum(MultipartFile multipartFile);

    void orderOutExcel(TbOrderGeneralExcelPojo tbOrderGeneralExcelPojo, HttpServletResponse res) throws Exception;
}
