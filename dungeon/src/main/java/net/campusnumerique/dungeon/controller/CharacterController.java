package net.campusnumerique.dungeon.controller;

import io.swagger.annotations.ApiOperation;
import net.campusnumerique.dungeon.exceptions.ResourceNotFoundException;
import net.campusnumerique.dungeon.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.campusnumerique.dungeon.entity.Character;;import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/public")
public class CharacterController {
    @Autowired
    private CharacterRepository characterRepository;

    @ApiOperation(value = "Get all characters")
    @GetMapping("/characters")
    public Iterable<Character> getCharacters() {
        return characterRepository.findAll();
    }

    @ApiOperation(value = "Get a single character by id")
    @GetMapping("/character/{id}")
    public ResponseEntity<Character> getCharacter(@PathVariable long id) throws ResourceNotFoundException {
        Character character = characterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Character not found for this id: " + id));
        return ResponseEntity.ok().body(character);
    }

    @ApiOperation(value = "Post a new character")
    @PostMapping(value = "/characters")
    public Character saveCharacter(@Valid @RequestBody Character character) {
        return characterRepository.save(character);
    }

    @ApiOperation(value = "Upgrade a character")
    @PutMapping("/characters")
    public ResponseEntity<Character> upgradeCharacter(@Valid @RequestBody Character newCharacter, @PathVariable long id) throws ResourceNotFoundException {
        Character character = characterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Character not found for this id: " + id));
        character.setName(newCharacter.getName());
        character.setType(newCharacter.getType());
        final Character updatedCharacter = characterRepository.save(newCharacter);
        return ResponseEntity.ok().body(updatedCharacter);
    }

    @ApiOperation(value = "Delete a character")
    @DeleteMapping("/characters/{id}")
    public Map<String, Boolean> deleteCharacter(@PathVariable long id) throws ResourceNotFoundException {
        Character character = characterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Character not found for this id: " + id));
        characterRepository.delete(character);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
