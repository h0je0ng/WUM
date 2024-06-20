package com.hnpl.wum.admin.controller;

import com.hnpl.wum.admin.dto.MovieDto;
import com.hnpl.wum.admin.form.MovieForm;
import com.hnpl.wum.admin.service.MovieService;
import com.hnpl.wum.config.PageHandler;
import com.hnpl.wum.admin.dto.MovieSearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/search/searchText")
    public String searchMovies(@RequestParam(value= "page", required = false)Integer page,
                               @ModelAttribute("movieSearchDto") MovieSearchDto movieSearchDto,
                               Model model) {
        //페이지 크기
        int pg = 6;

        if (page==null) page =1;

        Map map = new HashMap();
        map.put("page", page * pg - pg);
        map.put("pageSize", pg);
        map.put("movieSearchDto", movieSearchDto);

        // 검색어가 비어 있으면 빈 문자열로 설정하여 검색 조건에 포함되도록 함
        if (movieSearchDto.getSearchText() == null || movieSearchDto.getSearchText().trim().isEmpty()) {
            movieSearchDto.setSearchText(""); // 빈 문자열로 설정
        }

        //개수계산하기
        int totalCnt = movieService.countAllMovie(map);

        PageHandler pageHandler = new PageHandler(totalCnt, pg, page);

        //검색결과 조회
        List<MovieDto> movie = movieService.searchMovies(movieSearchDto);

        model.addAttribute("pageHandler", pageHandler);
        model.addAttribute("movie", movie);

        return "search/search_searchList";
    }

    @GetMapping("/movie/{movieSeq}")
    public String movieDtl(@PathVariable("movieSeq") Long movieSeq, Model model) {
        MovieForm movieForm = movieService.getMovieDtl(movieSeq);
        model.addAttribute("movieForm", movieForm);

        return "search/search_movieDetail";
    }
}