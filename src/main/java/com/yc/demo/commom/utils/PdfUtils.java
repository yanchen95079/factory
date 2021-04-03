package com.yc.demo.commom.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.yc.demo.commom.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yanchen
 * @ClassName PdfUtils
 * @Date 2021/2/10 12:27
 * @Description：
 */
public class PdfUtils {
    private final static Logger log = LoggerFactory.getLogger(PdfUtils.class);
    private static long size=1024;
    private static long mb=2;
    // 利用模板生成pdf
    public static void pdfout(Map<String, Object> dateMap,String orderNo,String modelName) {
        //检测剩余空间
        File fileFree = new File("D:");
        long freeSpace = fileFree.getFreeSpace();
        log.info("剩余空间大小 : " + freeSpace / 1024 / 1024 / 1024 + "G");
        if(freeSpace / size / size<mb){
            throw new MyException(500,"磁盘空间小于2mb,请及时处理");
        }
        // 模板路径
        String templatePath = PdfUtils.class.getClassLoader().getSystemClassLoader().getResource("models/"+modelName+".pdf").getPath();
        //新文件文件夹
        String pdfPath="D:/"+DateUtil.date2String(new Date(),DateUtil.DatePattern.YYYYMMDD.getValue());
        // 生成的新文件路径
        String newPDFPath = pdfPath+"/"+orderNo+".pdf";
        String filePath = PdfUtils.class.getClassLoader().getSystemClassLoader().getResource("fonts/simsun.ttc").getPath();
        PdfReader reader;
        FileOutputStream out;
        ByteArrayOutputStream bos;
        PdfStamper stamper;
        try {
            File pdfPathFile = new File(pdfPath);
            if (!pdfPathFile.exists()) {
                pdfPathFile.mkdirs();
            }
            File file = new File(newPDFPath);
            if(file.exists()) {
                file.delete();
                System.out.println("删除成功");
            }
            BaseFont bf = BaseFont.createFont(filePath+",1" , BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            out = new FileOutputStream(newPDFPath);// 输出流
            reader = new PdfReader(templatePath);// 读取pdf模板
            bos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, bos);
            AcroFields form = stamper.getAcroFields();

            form.addSubstitutionFont(bf);

            for(String key : dateMap.keySet()){
                String value = String.valueOf(dateMap.get(key));
               // form.setFieldProperty(key,"textsize",7f,null);
                form.setField(key,value);
            }
            // 如果为false，生成的PDF文件可以编辑，如果为true，生成的PDF文件不可以编辑
            stamper.setFormFlattening(true);
            stamper.close();
            Document doc = new Document();
            PdfCopy copy = new PdfCopy(doc, out);
            doc.open();
            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
            copy.addPage(importPage);
            doc.close();

        } catch (IOException | DocumentException e) {
            System.out.println(e);
        }

    }


}