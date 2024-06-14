package com.example.petallergytracker.Repository;

import com.example.petallergytracker.Models.AllergicReaction;
import com.example.petallergytracker.Models.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AllergicReactionRepository extends MongoRepository<AllergicReaction, Long> {

    /**
     * Finds the count of allergic reactions per ingredient, ordered by the count in descending order.
     * @return A list of objects containing ingredient names and reaction counts.
     */
    @Query("SELECT r.ingredient.name, COUNT(r) as reactionCount FROM AllergicReaction r GROUP BY r.ingredient.name ORDER BY reactionCount DESC")
    List<Object[]> countReactionsByIngredient();
    /*
    * Testing!
    * */
    Optional<AllergicReaction> deleteAllergicReactionById(Long id);
}
