package com.yc.demo.service;


import com.yc.demo.domain.TbPdfInfo;

import java.util.List;

/**
 * @author Yanchen
 * @ClassName CeshiService
 * @Date 2020/7/7 18:16
 * @Description：
 */
public interface TbPdfInfoService {

    void insert(TbPdfInfo tbPdfInfo);

    void update(TbPdfInfo tbPdfInfo);

    void pdfOut(Long id);

    TbPdfInfo  selectById(Long id);

    List<TbPdfInfo>  select(TbPdfInfo tbPdfInfo);

}
