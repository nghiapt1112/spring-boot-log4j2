package com.nghia.ivector.controller;

import com.nghia.ivector.domain.Movie;
import com.nghia.ivector.domain.chart.CanvasjsChartData;
import com.nghia.ivector.domain.repository.MovieRepository;
import com.nghia.ivector.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;

@Controller
@RequestMapping("/ivector")
public class IVectorController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/home")
    public String defaultPage2() {
        return "html/home";
    }

    @GetMapping("/left")
    public String left(Model model) {
        model.addAttribute("dataPointsList", CanvasjsChartData.getCanvasjsDataList());
        return "left";
    }

    @RequestMapping("/")
    public String index(final Model model) {
        System.out.println("Controller calling...");
        // loads 1 and display 1, stream data, data driven mode.
        IReactiveDataDriverContextVariable reactiveDataDrivenMode = new ReactiveDataDriverContextVariable(movieRepository.findAll(), 1);

        model.addAttribute("movies", reactiveDataDrivenMode);

        // classic, wait repository loaded all and display it.
        //model.addAttribute("movies", movieRepository.findAll());

        return "index";

    }

    @ResponseBody
    @RequestMapping(value = "/rest", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Movie> getRestData() {
        return movieRepository.findAll();
    }

    @GetMapping("/profile")
    public String userProfile(Model model) {
        model.addAttribute("requestUser", new User());
        return "user/profile";
    }
}
