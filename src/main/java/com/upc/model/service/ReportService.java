package com.upc.model.service;

import com.google.gson.Gson;
import com.upc.model.config.Config;
import com.upc.model.dao.StuReportDao;
import com.upc.model.dto.ImageUrlsDto;
import com.upc.model.dto.ReportListDto;
import com.upc.model.model.StuReport;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Qloop on 2017/5/21.
 */
@Service
public class ReportService {

    @Autowired
    private StuReportDao stuReportDao;
//    @Autowired
//    private HttpServletRequest httpServletRequest;

    public Map<String, Long> save(String reportJsonContent) {
        Map<String, Long> map = new HashMap<>();
        Gson gson = new Gson();
        StuReport stuReport = gson.fromJson(reportJsonContent, StuReport.class);
        //noinspection Duplicates
        if (stuReport == null) {
            map.put("result", (long) Config.Convert_ERROR_CODE);
            return map;
        } else {
            stuReport.setCreateDate(new Date());
            stuReportDao.save(stuReport);

            map.put("result", (long) Config.SUCCESS_CODE);
            map.put("stuReportId", stuReport.getId());
            return map;
        }
    }

    public ImageUrlsDto saveImgs(MultipartFile[] files, long templateId) {
        ImageUrlsDto imageUrlsDto = new ImageUrlsDto();

        if (files != null && files.length >= 1) {
            for (MultipartFile file : files) {
                BufferedOutputStream bw = null;
                try {
                    String fileName = file.getOriginalFilename();
                    //判断是否有文件且是否为图片文件
                    if (fileName != null && !"".equalsIgnoreCase(fileName.trim()) && isImageFile(fileName)) {

                        //创建输出文件对象
                        File outFile = new File(Config.UPLOAD_PATH + "" + templateId
                                + UUID.randomUUID().toString() + getFileType(fileName));
                        //拷贝文件到输出文件对象
                        FileUtils.copyInputStreamToFile(file.getInputStream(), outFile);

                        if (imageUrlsDto.getUrls() != null) {
                            imageUrlsDto.setUrls(imageUrlsDto.getUrls() + ";"
                                    + Config.BASE_URL + outFile.getAbsolutePath().replace(Config.UPLOAD_PATH, ""));
                        } else {
                            imageUrlsDto.setUrls(Config.BASE_URL + outFile.getAbsolutePath().replace(Config.UPLOAD_PATH, ""));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    imageUrlsDto.setUrls("");
                    imageUrlsDto.setResult("" + Config.FILE_SAVE_FAILED);
                } finally {
                    try {
                        if (bw != null) {
                            bw.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            imageUrlsDto.setResult("" + Config.SUCCESS_CODE);
        } else {
            imageUrlsDto.setResult("" + Config.FILE_NULL);
        }

        return imageUrlsDto;
    }

    /**
     * 判断文件是否为图片文件
     */
    private Boolean isImageFile(String fileName) {
        String[] img_type = new String[]{".jpg", ".jpeg", ".png", ".gif", ".bmp"};
        if (fileName == null) {
            return false;
        }
        fileName = fileName.toLowerCase();
        for (String type : img_type) {
            if (fileName.endsWith(type)) {
                return true;
            }
        }
        return false;
    }


    public ReportListDto getAllReportByTemplateId(long temnplateId) {
        ReportListDto reportListDto = new ReportListDto();
        Iterable<StuReport> reportIterable = stuReportDao.findByTemplateId(temnplateId);
        if (reportIterable != null) {
            reportListDto.setResult(Config.SUCCESS_CODE + "");
            List<ReportListDto.ReportBean> reportBeanList = new ArrayList<>();
            for (StuReport stuReport : reportIterable) {
                ReportListDto.ReportBean reportBean = new ReportListDto.ReportBean();
                reportBean.setStuId(stuReport.getStuId());
                reportBean.setStuName(stuReport.getStuName());
                reportBean.setStuClass(stuReport.getStuClass());
                reportBeanList.add(reportBean);
            }
            reportListDto.setReportBeanList(reportBeanList);
        } else {
            reportListDto.setResult(Config.NOT_FIND + "");
        }
        return reportListDto;
    }

    /**
     * 获取文件后缀名
     */
    private String getFileType(String fileName) {
        if (fileName != null && fileName.contains(".")) {
            return fileName.substring(fileName.lastIndexOf("."), fileName.length());
        }
        return "";
    }
}
