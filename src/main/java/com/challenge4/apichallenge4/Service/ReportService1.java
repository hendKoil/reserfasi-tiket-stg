package com.challenge4.apichallenge4.Service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Service
public class ReportService1 {
    @Autowired
    ApplicationContext context;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    RestTemplate restTemplate;

    public byte[] generate_pdf(Map<String, Object> parameters, String reportName) {
        try {
//            org.springframework.core.io
            Resource resource = context.getResource("classpath:/reserfasi tiket1.jrxml");
            //Compile to jasperReport
//            java.io
            InputStream inputStream = resource.getInputStream();

//            net.sf.jasperreports.engine
            JasperReport report = JasperCompileManager.compileReport(inputStream);

            // Fill the report
//            net.sf.jasperreports.engine
//            net.sf.jasperreports.engine
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters,jdbcTemplate.getDataSource().getConnection());

            // Export the report to a PDF file
                    //            net.sf.jasperreports.engine
            byte[] result = JasperExportManager.exportReportToPdf(jasperPrint) ;

            System.out.println("Done");
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResponseEntity generate_excel(Map<String, Object> parameters, String reportName) throws SQLException {
        Connection connection = null;
        byte[] data = new byte[0];
        HttpHeaders httpHeaders = new HttpHeaders();
        try {
            connection = dataSource.getConnection();
            httpHeaders.set( HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + reportName + ".xlsx" );

            // Compile the Jasper report from .jrxml to .japser
            Resource resource = context.getResource("classpath:reserfasi tiket1.jrxml");
            InputStream inputStream = resource.getInputStream();
            JasperReport report = JasperCompileManager.compileReport(inputStream);

            // Fill the report
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters,jdbcTemplate.getDataSource().getConnection());

            JRXlsxExporter exporter = new JRXlsxExporter();

            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, byteArrayOutputStream);
            exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
            exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
            exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
            exporter.exportReport();
            data = byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if(connection != null) {
               connection.close();
                connection = null;
            }
        }
        return new ResponseEntity(data, httpHeaders, HttpStatus.OK );
    }

}
