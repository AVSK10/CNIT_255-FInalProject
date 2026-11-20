package boardgamelibrary.model;

import java.util.List;

/**
 * Defines storage operations for the Board Game Library.
 * Both in-memory and persistent repositories implement this interface.
 *
 * @author Aryan Kondapalli
 * @author Lakulish Saini
 */
public interface GameRepository {

    /** Returns a defensive copy of the stored games. */
    List<Game> findAll();

    /** Returns the game with the given ID, or null if it does not exist. */
    Game findById(int id);

    /**
     * Saves a new game when its ID is 0, or updates an existing game.
     * Returns the saved game with its assigned ID.
     */
    Game save(Game game);

    /** Deletes a stored game by its ID. */
    void deleteById(int id);
}
