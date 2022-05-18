//package com.challenge4.apichallenge4.Service.ServiceImpl;
//
//
//import com.challenge4.apichallenge4.Dto.CustomizeResponse;
//import com.challenge4.apichallenge4.Dto.FilmDetailDto;
//import com.challenge4.apichallenge4.Entity.VwJadwalFilms;
////import com.challenge4.apichallenge4.Repository.FilmDetailDslRepo;
//import com.challenge4.apichallenge4.Service.FilmDetailService;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.math.BigDecimal;
//import java.util.*;
//
//@Service
//public class ServiceFilmdetailImpl {
//
//    @Autowired
//    FilmDetailService filmDetailService;
//
////    @Autowired
////    FilmDetailDslRepo filmDetailDslRepo;
//
////    public void getFilmDetailSvc3(String filmName){
////
////    }
//
//
//    public  List<FilmDetailDto> getFilmDetailSvc(String filmName){
//        List<Object[]> lsFilmDetail =  filmDetailService.getFilmDetail(filmName);
//        List<FilmDetailDto> lsDto = new ArrayList<>();
//
//        for(Object[] obj: lsFilmDetail){
//            FilmDetailDto dtoFilmDetail = new FilmDetailDto();
//            dtoFilmDetail.setTanggalTayang((Date) obj[0]);
//            dtoFilmDetail.setFilmName((String) obj[1]);
//            dtoFilmDetail.setFilmCode((int) obj[2]);
//            dtoFilmDetail.setHargaTiket((BigDecimal) obj[3]);
//            dtoFilmDetail.setStudiName((String) obj[4]);
//            dtoFilmDetail.setSeats((int) obj[5]);
//
//            lsDto.add(dtoFilmDetail);
//        }
//        return  lsDto;
//    }
//
//    public Map<String, List<VwJadwalFilms>> getFilmDetai1lSvc(String filmName){
//        List<VwJadwalFilms> lsFilm = filmDetailService.findByFilmNameContaining(filmName);
//            ModelMapper mapper = new ModelMapper();
////        List<FilmDetailDto> lsDto = mapper.map(lsFilm, new List<FilmDetailDto>);
//        Map<String, List<VwJadwalFilms>> map = new HashMap<>();
//        map.put("film Detail", lsFilm);
//        return map;
//    }
//
//}
