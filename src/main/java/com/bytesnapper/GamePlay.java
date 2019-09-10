package com.bytesnapper;

import java.util.HashMap;
import java.util.Map;

/**
 * A {@link GamePlay} represents Game Play, to keep record of games and players, each player name is linked to a {@link Game}.
 *
 * @author Ahmed Soliman
 */
public class GamePlay {
    private final Map<String, Game> playerGameMap = new HashMap<>();

    /**
     * Throws a new ball for a player and trigger score calculations, at the beginning of each frame a new frame is created and the ball is assigned to this frame
     * if it is the first time for the player, a new player instance is created.
     *
     * @param playerName name of the player who threw the ball.
     * @param noOfPins   the number of pins hit by the ball.
     */
    public void throwBall(String playerName, int noOfPins) {
        Game game = playerGameMap.get(playerName);
        // create new game if it does not exist
        if (game == null) {
            game = new Game();
            playerGameMap.put(playerName, game);
        }
        ScoreCalculator.addBall(game, noOfPins);
        printScore(game, playerName);
    }

    /**
     * Iterates over frames and print the score of a certain player
     *
     * @param game       the {@link Game}
     * @param playerName player name to get score for.
     */
    private void printScore(Game game, String playerName) {
        if (game.getScorePerFrame().size() > 0) {
            System.out.println("Score for player: " + playerName);
        }
        Map<Integer, Integer> scorePerFrame = game.getScorePerFrame();
        for (Map.Entry<Integer, Integer> score : scorePerFrame.entrySet()) {
            System.out.print("Frame #" + score.getKey() + " score is: " + score.getValue() + "|");
        }
        System.out.println();
    }

    /**
     * Gets {@link Game} for a certain player name
     *
     * @param playerName the name of the player to look for.
     * @return the {@link Game} of a certain player.
     */
    public Game getGameByPlayer(String playerName) {
        return playerGameMap.get(playerName);
    }
}
