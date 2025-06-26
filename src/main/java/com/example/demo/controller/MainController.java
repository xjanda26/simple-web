package com.example.demo.controller;

import com.example.demo.model.TextEntry;
import com.example.demo.repository.TextEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class MainController {

    @Autowired
    private TextEntryRepository textEntryRepository;

    @GetMapping("/")
    public String showIndex(Model model) {
        // This is missing in your current code
        model.addAttribute("newEntry", new TextEntry());
        model.addAttribute("entries", textEntryRepository.findAll());
        return "index";
    }

    @PostMapping("/submit")
    public String submitEntry(@RequestParam("text") String text) {
        TextEntry newEntry = new TextEntry();
        newEntry.setText(text);
        newEntry.setCreatedAt(LocalDateTime.now());
        textEntryRepository.save(newEntry);
        return "redirect:/";
    }

    @GetMapping("/refresh")
    public String refreshEntries() {
        return "redirect:/";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Controller is working";
    }
}
