//package com.challenge4.apichallenge4.Repository;
//
//import com.challenge4.apichallenge4.Dto.FilmDetailDto;
////import com.challenge4.apichallenge4.Entity.VwJadwalFilms;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.querydsl.QuerydslPredicateExecutor;
//import org.springframework.data.repository.query.Param;
//
//import java.util.List;
//import java.util.Map;
//
//public interface FilmDetailRepo extends JpaRepository<VwJadwalFilms, Integer>
//{
//    public List<VwJadwalFilms> findByFilmNameContaining( String filmName);
//
//    @Query(value = "select a.tanggal_tayang, a.film_name, a.films_code, a.harga_tiket, a.studio_name, a.seats" +
//            "  from vw_jadwal_film_detail a where a.film_name like %:namaFilm%", nativeQuery = true)
//    public List<Object[]> getFilmDetail(@Param("namaFilm") String namaFilm);
//
//}
