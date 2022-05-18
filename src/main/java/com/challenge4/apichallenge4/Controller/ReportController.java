package com.challenge4.apichallenge4.Controller;

//import com.challenge4.apichallenge4.Service.ReportService;
import com.challenge4.apichallenge4.Service.ReportService1;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/")
public class ReportController {
//
//    @Autowired
//    ReportService reportService;

    @Autowired
    ReportService1 reportService1;

    RestTemplate restTemplate;

    @GetMapping(value = "/invoice/{format}/{idUser}",produces =  "application/pdf")
    public byte[] getInvoice(@PathVariable("format") String format,@PathVariable("idUser") Integer idUser) throws
            JRException, FileNotFoundException , SQLException {
//        return reportService.exportReport(format,idUser);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("Parameter1", idUser);

            return reportService1.generate_pdf(parameters, "reserfasi tiket");
    }




    @GetMapping(value = "/invoice/excel/{idUser}",produces =  "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    public ResponseEntity getInvoiceExcel(@PathVariable("idUser") Integer idUser) throws JRException, FileNotFoundException , SQLException {
//        return reportService.exportReport(format,idUser);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("Parameter1", idUser);

        return reportService1.generate_excel(parameters, "reserfasi tiket");
    }
}
