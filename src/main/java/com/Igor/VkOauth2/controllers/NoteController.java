package com.Igor.VkOauth2.controllers;


import com.Igor.VkOauth2.entities.Note;
import com.Igor.VkOauth2.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class NoteController
{
    @Autowired
    private NoteRepository noteRepository;

    @GetMapping("/notes")
    public String notes(Model model)
    {
        List<Note> notes = noteRepository.findAll();
        model.addAttribute("notes", notes);

        return "notes";
    }

    @PostMapping("/addnote")
    public String addNote(String title, String note)
    {
        Note newNote = new Note();
        newNote.setTitle(title);
        newNote.setNote(note);

        noteRepository.save(newNote);

        return "redirect:/notes";
    }
}
