package com.example.demo.controller;

import com.example.demo.model.TextEntry;
import com.example.demo.repository.TextEntryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    private final TextEntryRepository repo;

    public MainController(TextEntryRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("entries", repo.findAll());
        model.addAttribute("newEntry", new TextEntry());
        return "index";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute TextEntry newEntry) {
        repo.save(newEntry);
        return "redirect:/";
    }

    @GetMapping("/refresh")
    public String refresh(Model model) {
        model.addAttribute("entries", repo.findAll());
        model.addAttribute("newEntry", new TextEntry());
        return "index";
    }
}
