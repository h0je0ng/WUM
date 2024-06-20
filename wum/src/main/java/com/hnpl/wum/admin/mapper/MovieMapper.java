package com.hnpl.wum.admin.mapper;

import com.hnpl.wum.admin.dto.MovieDto;
import com.hnpl.wum.admin.dto.MovieMainDto;
import com.hnpl.wum.admin.dto.MovieSearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MovieMapper {
    int insertMovie(MovieDto movieDto);

    List<MovieDto> listAllMovie();

    List<MovieDto> movieListPage(Map map);

    List<MovieDto> mainSearchQuery(MovieSearchDto movieSearchDto);

    int countAllMovie(Map map);

    List<MovieMainDto> mainSelect(Map map);

    MovieDto movieDetail(Long movieSeq);

    List<MovieDto> moviePoster(Long movieSeq);

    int updateMovie(MovieDto movieDto);

    void deleteMovie(Long movieSeq);
}
