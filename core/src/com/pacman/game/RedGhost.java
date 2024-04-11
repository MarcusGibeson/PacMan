package com.pacman.game;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RedGhost extends Ghost {
    private Ball ball;

    public RedGhost(float initialX, float initialY, int xSpeed, int ySpeed, String spritePath, String upSpritePath, String downSpritePath, String leftSpritePath, String rightSpritePath, ArrayList<Wall> walls, Ball ball) {
        super(initialX, initialY, xSpeed, ySpeed, spritePath, upSpritePath, downSpritePath, leftSpritePath, rightSpritePath, walls);
        this.ball = ball;
    }

    @Override
    public void update(float deltaTime) {
        //chase behavior
        float targetX = ball.getX();
        float targetY = ball.getY();


        //Calculate path to Pac-Man's target position using pathfinding algorithm
        ArrayList<Node> path = calculatePathToTarget(targetX, targetY);

        followPath(path, deltaTime);


}
}
