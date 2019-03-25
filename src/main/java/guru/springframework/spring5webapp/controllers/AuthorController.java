package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorRepostiory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private AuthorRepostiory authorRepostiory;

    public AuthorController(AuthorRepostiory authorRepostiory) {
        this.authorRepostiory = authorRepostiory;
    }
    @RequestMapping(path = "/authors")
    private String getAuthors(Model model){

        model.addAttribute("authors",authorRepostiory.findAll());
        return "authors";
    }
}
