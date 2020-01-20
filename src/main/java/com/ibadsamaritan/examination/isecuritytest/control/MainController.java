package com.ibadsamaritan.examination.isecuritytest.control;

import com.ibadsamaritan.examination.isecuritytest.service.QuestionsService;
import com.ibadsamaritan.examination.isecuritytest.service.TestProcessService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    final QuestionsService questionsService;
    final TestProcessService testProcessService;

    public MainController(QuestionsService questionsService, TestProcessService testProcessService) {
        this.questionsService = questionsService;
        this.testProcessService = testProcessService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("questions", questionsService.getAllQuestions());
        return "test";
    }

    @ResponseBody
    @PostMapping("/test")
    public String processTest(@RequestParam(name = "data") String answers, Model model) {
        return testProcessService.processAnswers(answers);
    }
}
