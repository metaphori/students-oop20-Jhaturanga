package jhaturanga.model;

import java.util.Optional;

import jhaturanga.commons.Pair;
import jhaturanga.model.game.gametypes.GameTypesEnum;
import jhaturanga.model.match.Match;
import jhaturanga.model.player.Player;
import jhaturanga.model.timer.DefaultsTimers;
import jhaturanga.model.timer.Timer;
import jhaturanga.model.user.User;

/**
 * The Model class of MVC pattern.
 */
public interface Model {

    // USERS FUNCTIONALITY

    /**
     * Set the first user.
     * 
     * @param user - the user to be setted
     */
    void setFirstUser(User user);

    /**
     * Set the second user.
     * 
     * @param user - the user to be setted
     */
    void setSecondUser(User user);

    /**
     * Get the first user.
     * 
     * @return an optional of user
     */
    Optional<User> getFirstUser();

    /**
     * Get the second user.
     * 
     * @return an optional of user
     */
    Optional<User> getSecondUser();

    // GAME FUNCTIONALITY

    /**
     * @return the actual matches if presents.
     */
    Optional<Match> getActualMatch();

    /**
     * Sets the starting board information.
     * 
     * @param startingBoardInfo - the startingBoard info.
     */
    void setDynamicGameType(Pair<String, Pair<Integer, Integer>> startingBoardInfo);

    /**
     * Create a new Match.
     * 
     */
    void createMatch();

    /**
     * Sets the Timer for the match from a DefaultTimer.
     * 
     * @param timer
     */
    void setTimer(DefaultsTimers timer);

    /**
     * Gets the match's timer.
     * 
     * @return Optional<Timer>
     */
    Optional<Timer> getTimer();

    /**
     * 
     * @param gameType
     */
    void setGameType(GameTypesEnum gameType);

    /**
     * 
     * @return Optional<GameType>
     */
    Optional<GameTypesEnum> getGameType();

    /**
     * Sets the white player for the gametype.
     * 
     * @param player
     */
    void setWhitePlayer(Player player);

    /**
     * Sets the black player for the gametype.
     * 
     * @param player
     */
    void setBlackPlayer(Player player);

    /**
     * Gets the name of the GameType.
     * 
     * @return String - the name of the GameType
     */
    String getGameTypeName();

    /**
     * Gets the white player for the gametype.
     * 
     * @return player
     */
    Player getWhitePlayer();

    /**
     * Gets the black player for the gametype.
     * 
     * @return player
     */
    Player getBlackPlayer();

    /**
     * Use this method to delete from the model the info on the current match.
     */
    void clearMatchInfo();

    /**
     * 
     * @return true - if the dynamic gametype is set in the model.
     */
    boolean isDynamicGameTypeSet();

}
