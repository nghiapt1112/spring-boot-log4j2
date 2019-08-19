package com.nghia.ivector.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
@RequestMapping("/ivector")
public class IVectorController {

//    @Autowired
//    private MovieRepository movieRepository;

    @GetMapping("/home")
    public String defaultPage2() {
        return "html/home";
    }

    @GetMapping("/left")
    public String left() {
        return "left";
    }

    @RequestMapping("/")
    public String index(final Model model) {
        System.out.println("Controller calling...");
        // loads 1 and display 1, stream data, data driven mode.
//        IReactiveDataDriverContextVariable reactiveDataDrivenMode = new ReactiveDataDriverContextVariable(movieRepository.findAll(), 1);
//
//        model.addAttribute("movies", reactiveDataDrivenMode);
        model.addAttribute("movies", Collections.emptyList());

        // classic, wait repository loaded all and display it.
        //model.addAttribute("movies", movieRepository.findAll());

        return "index";

    }
//
//    @ResponseBody
//    @RequestMapping(value = "/rest", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public Flux<Movie> getRestData() {
//        return movieRepository.findAll();
//    }
//

}
