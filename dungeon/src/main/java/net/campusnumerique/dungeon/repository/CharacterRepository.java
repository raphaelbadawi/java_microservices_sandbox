package net.campusnumerique.dungeon.repository;

import org.springframework.data.repository.CrudRepository;
import net.campusnumerique.dungeon.entity.Character;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Long> {
}