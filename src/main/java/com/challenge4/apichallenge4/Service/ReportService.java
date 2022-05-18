//package com.challenge4.apichallenge4.Service;
//
//
//import com.challenge4.apichallenge4.Entity.Vw_tiket_order;
//import com.challenge4.apichallenge4.Repository.VwReportTiket;
//import com.fasterxml.jackson.databind.util.JSONPObject;
//import net.sf.jasperreports.engine.*;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import net.sf.jasperreports.engine.design.JasperDesign;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.ResourceUtils;
//
//import javax.management.JMRuntimeException;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class ReportService {
//
//    @Autowired
//    private VwReportTiket vwReportTiket;
//
//
//    public String exportReport(String reportFormat,Integer idUser) throws FileNotFoundException, JMRuntimeException, JRException {
//        String path = "C:\\Users\\user\\Desktop\\Report";
//        List<Vw_tiket_order> tiketOrder = vwReportTiket.findByIdUsers(idUser);
//        //load file and compile it
//        File file = ResourceUtils.getFile("D:\\test pull\\chap4 challenge\\challenge-km\\src\\main\\resources\\reserfasi tiket.jrxml");
//            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(tiketOrder, false);
//        Map<String, Object> parameters = new HashMap<>();
////        parameters.put("Parameter1", idUser);
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
//        if (reportFormat.equalsIgnoreCase("html")) {
//            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\reserfasi tiket.html");
//        }
//        if (reportFormat.equalsIgnoreCase("pdf")) {
//            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\reserfasi tiket.pdf");
//        }
//
//        return "report generated in path : " + path;
//    }
//}