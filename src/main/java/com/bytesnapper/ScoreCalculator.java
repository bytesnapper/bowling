package com.bytesnapper;

import java.util.List;

/**
 * A {@link ScoreCalculator} calculates score after each ball
 *
 * @author Ahmed Soliman
 */
public final class ScoreCalculator {

    private ScoreCalculator() {
    }

    public static void addBall(Game game, int noOfPins) {
        List<Integer> balls = game.getBalls();
        balls.add(noOfPins);
        calculatePerFrame(game, balls);
    }

    private static void calculatePerFrame(Game game, List<Integer> balls) {
        int frameCounter = 0;
        int ball = 0;
        while (ball < balls.size())
            if (isStrikeFrame(balls, ball)) {
                frameCounter++;
                int score = 10 + balls.get(ball + 1) + balls.get(ball + 2);
                game.getScorePerFrame().put(frameCounter, score);
                ball++;
            } else if (isSpareFrame(balls, ball)) {
                frameCounter++;
                int score = 10 + balls.get(ball + 2);
                game.getScorePerFrame().put(frameCounter, score);
                ball += 2;
            } else if (isOpenFrame(balls, ball)) {
                frameCounter++;
                int score = balls.get(ball) + balls.get(ball + 1);
                game.getScorePerFrame().put(frameCounter, score);
                ball += 2;
            } else {
                ball++;
            }
    }

    private static boolean isStrikeFrame(List<Integer> balls, int i) {
        return i < balls.size() - 2 && balls.get(i) == 10;
    }


    private static boolean isSpareFrame(List<Integer> balls, int i) {
        return i < balls.size() - 2 && balls.get(i) + balls.get(i + 1) == 10;
    }

    private static boolean isOpenFrame(List<Integer> balls, int i) {
        return i < balls.size() - 1 && balls.get(i) + balls.get(i + 1) < 10;
    }
}
