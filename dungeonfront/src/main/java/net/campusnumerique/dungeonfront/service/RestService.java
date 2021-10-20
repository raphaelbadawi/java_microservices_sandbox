package net.campusnumerique.dungeonfront.service;

import net.campusnumerique.dungeonfront.entity.Character;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
public class RestService {
    private final RestTemplate restTemplate;

    private final String endpoint;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        this.endpoint = "http://dungeon:9000/public/characters";
    }

    public Character[] getCharactersAsObject() {
        ResponseEntity<Character[]> response = this.restTemplate.getForEntity(endpoint, Character[].class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

    public Character getCharacterAsObject(long id) {
        String endpoint = this.endpoint + "/" + id;
        ResponseEntity<Character> response = this.restTemplate.getForEntity(endpoint, Character.class, id);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

    public Character createCharacter(Character character) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Character> entity = new HttpEntity<>(character, headers);
        return restTemplate.postForObject(endpoint, entity, Character.class);
    }

    public void upgradeCharacter(Character character, long id) {
        String endpoint = this.endpoint + "/" + id;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Character> entity = new HttpEntity<>(character, headers);
        restTemplate.exchange(endpoint, HttpMethod.PUT, entity, Character.class).getBody();
    }

    public void deleteCharacter(long id) {
        String endpoint = this.endpoint + "/" + id;
        restTemplate.delete(endpoint);
    }
}
