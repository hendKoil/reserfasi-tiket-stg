package com.challenge4.apichallenge4.Repository;

import com.challenge4.apichallenge4.Entity.Films;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmsRepo extends PagingAndSortingRepository<Films, Integer> {
    public List<Films> findAll();
    Page<Films> findAll(Pageable pageable);
    public Films findByFilmCode(Integer filmCode);
    public Optional<Films> findByFilmCode(int film_code);


}
