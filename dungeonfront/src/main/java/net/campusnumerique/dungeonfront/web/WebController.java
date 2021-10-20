package net.campusnumerique.dungeonfront.web;

import net.campusnumerique.dungeonfront.service.RestService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import net.campusnumerique.dungeonfront.entity.Character;
import net.campusnumerique.dungeonfront.type.CharacterType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;

@Controller
public class WebController {
    private ArrayList<Character> characters;
    private HashMap<CharacterType, String> avatars;

    private RestService restService;

    public WebController() {
        restService = new RestService(new RestTemplateBuilder());
        Character[] characters = restService.getCharactersAsObject();
        this.characters = new ArrayList<Character>();
        Collections.addAll(this.characters, characters);
        avatars = new HashMap<CharacterType, String>();
        avatars.put(CharacterType.CAT, "https://ukmadcat.com/wp-content/uploads/2019/04/sleepy-cat.jpg");
        avatars.put(CharacterType.WARRIOR, "https://www.opinion-internationale.com/wp-content/uploads/2014/02/DUPOND_MORETTIcopy.jpg");
        avatars.put(CharacterType.MAGICIAN, "https://www.leseclaireuses.com/ec_content/couv/20200403_harry-potter-theatrical-46448309_pro35_10-1100x715.jpg");
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("characters", characters);
        model.addAttribute("avatars", avatars);
        return "index";
    }

    @PostMapping("/post")
    public String save(@ModelAttribute Character character) {
        Character savedCharacter = restService.createCharacter(character);
        characters.add(savedCharacter);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        restService.deleteCharacter(id);
        characters = characters.stream().filter(c -> c.getId() != id).collect(Collectors.toCollection(ArrayList<Character>::new));
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable long id) {
        Character updatableCharacter = characters.stream()
                .filter(c -> (c.getId()) == id)
                .findFirst()
                .orElse(null);
        model.addAttribute("character", updatableCharacter);
        return "form";
    }

    @PutMapping("/upgrade/{characterId}")
    public String upgrade(@ModelAttribute Character character, @PathVariable long characterId) {
        restService.upgradeCharacter(character, characterId);
        characters = characters.stream().map(c -> {
            if (c.getId() != characterId) return c;
            return character;
        }).collect(Collectors.toCollection(ArrayList<Character>::new));
        return "redirect:/";
    }
}
