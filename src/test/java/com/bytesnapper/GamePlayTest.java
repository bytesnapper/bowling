package com.bytesnapper;

import org.junit.Assert;
import org.junit.Test;

/**
 * A Test for different bowling gameplays
 *
 * @author Ahmed Soliman
 * @since Nov-2018
 */
public class GamePlayTest {


    @Test
    public void testPerfectGame() {
        String playerName = "player1";
        GamePlay gamePlay = new GamePlay();
        // When
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        // bonus balls
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        int score = gamePlay.getGameByPlayer(playerName).getTotalScore();
        // Then
        Assert.assertEquals(300, score);
    }


    @Test
    public void testOneStrikeOneOpenFrame() {
        String playerName = "player1";
        GamePlay gamePlay = new GamePlay();
        // When
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 3);
        gamePlay.throwBall(playerName, 6);
        int score = gamePlay.getGameByPlayer(playerName).getTotalScore();
        // Then
        Assert.assertEquals(28, score);
    }


    @Test
    public void testTurkey() {
        String playerName = "player1";
        GamePlay gamePlay = new GamePlay();
        // When
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 8);
        gamePlay.throwBall(playerName, 2);
        gamePlay.throwBall(playerName, 8);
        gamePlay.throwBall(playerName, 0);
        int score = gamePlay.getGameByPlayer(playerName).getTotalScore();
        // Then
        Assert.assertEquals(104, score);
    }


    @Test
    public void testDuckDuckTurkey() {
        String playerName = "player1";
        GamePlay gamePlay = new GamePlay();
        // When
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 7);
        gamePlay.throwBall(playerName, 2);
        int score = gamePlay.getGameByPlayer(playerName).getTotalScore();
        // Then
        Assert.assertEquals(145, score);
    }

    @Test
    public void testOneSpareAndOneOpenFrame() {
        String playerName = "player1";
        GamePlay gamePlay = new GamePlay();
        // When
        gamePlay.throwBall(playerName, 7);
        gamePlay.throwBall(playerName, 3);
        gamePlay.throwBall(playerName, 4);
        gamePlay.throwBall(playerName, 2);
        int score = gamePlay.getGameByPlayer(playerName).getTotalScore();
        // Then
        Assert.assertEquals(20, score);
    }


    @Test
    public void testDoubleStrike() {
        String playerName = "player1";
        GamePlay gamePlay = new GamePlay();
        // When
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 10);
        gamePlay.throwBall(playerName, 9);
        gamePlay.throwBall(playerName, 0);
        int score = gamePlay.getGameByPlayer(playerName).getTotalScore();
        // Then
        Assert.assertEquals(57, score);
    }

    @Test
    public void testDoubleStrikeMultiPlayer() {
        String playerName1 = "player1";
        String playerName2 = "player2";
        String playerName3 = "player3";
        GamePlay gamePlay = new GamePlay();
        // When
        gamePlay.throwBall(playerName1, 10);
        gamePlay.throwBall(playerName1, 10);
        gamePlay.throwBall(playerName1, 9);
        gamePlay.throwBall(playerName1, 0);
        int score1 = gamePlay.getGameByPlayer(playerName1).getTotalScore();
        // Then
        Assert.assertEquals(57, score1);
        // When
        gamePlay.throwBall(playerName2, 7);
        gamePlay.throwBall(playerName2, 3);
        gamePlay.throwBall(playerName2, 4);
        gamePlay.throwBall(playerName2, 2);
        int score2 = gamePlay.getGameByPlayer(playerName2).getTotalScore();
        // Then
        Assert.assertEquals(20, score2);
        // When
        gamePlay.throwBall(playerName3, 10);
        gamePlay.throwBall(playerName3, 3);
        gamePlay.throwBall(playerName3, 6);
        int score3 = gamePlay.getGameByPlayer(playerName3).getTotalScore();
        // Then
        Assert.assertEquals(28, score3);
    }


    @Test
    public void testTwoOpenFrames() {
        String playerName = "player1";
        GamePlay gamePlay = new GamePlay();
        // When
        gamePlay.throwBall(playerName, 7);
        gamePlay.throwBall(playerName, 2);
        gamePlay.throwBall(playerName, 4);
        gamePlay.throwBall(playerName, 2);
        int score = gamePlay.getGameByPlayer(playerName).getTotalScore();
        // Then
        Assert.assertEquals(15, score);
    }
}
