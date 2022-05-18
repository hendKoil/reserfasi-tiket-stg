//package com.challenge4.apichallenge4.Controller;
//
//
//import com.challenge4.apichallenge4.Dto.FilmDetailDto;
//import com.challenge4.apichallenge4.Entity.VwJadwalFilms;
//import com.challenge4.apichallenge4.Service.ServiceImpl.ServiceFilmdetailImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.xml.ws.Response;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//public class FilmDetailController {
//    @Autowired
//    ServiceFilmdetailImpl serviceFilmdetail;
//
//    @PostMapping("api/film/filmDetail/{filmName}")
//    public ResponseEntity<?> filmDetailCtrl(@PathVariable("filmName") String filmName){
//        List<FilmDetailDto> lsFilmDetail = serviceFilmdetail.getFilmDetailSvc(filmName);
//        Map<String,  List<FilmDetailDto>> map = new HashMap<>();
//        map.put("film_detail", lsFilmDetail);
//
//        return new ResponseEntity(map, HttpStatus.ACCEPTED);
//    }
//
//    @PostMapping("api/film/v1/filmDetail/")
//    public ResponseEntity<?> filmDetailCtrl1(@RequestBody String filmName){
//        Map<String, List<VwJadwalFilms>> lsFilmDetail = serviceFilmdetail.getFilmDetai1lSvc("%he%");
//
//        return new ResponseEntity(lsFilmDetail, HttpStatus.ACCEPTED);
//    }
//}
