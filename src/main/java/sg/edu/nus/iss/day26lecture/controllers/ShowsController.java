package sg.edu.nus.iss.day26lecture.controllers;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.day26lecture.services.ShowsServices;

@Controller
@RequestMapping
public class ShowsController {

    @Autowired
    ShowsServices service;

    @GetMapping
    public String indexPage() {
        return "index";
    }

    @GetMapping("/search")
    public String searchForShow(@RequestParam String query, Model model) {
        List<Document> showsList = service.getShowsByName(query);
        if (showsList.size() > 0) {
            model.addAttribute("showsList", showsList);
            return "shows";
        } else {
            return "error";
        }
    }
    
}
