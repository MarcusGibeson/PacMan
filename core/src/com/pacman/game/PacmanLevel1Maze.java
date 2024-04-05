package com.pacman.game;

public class PacmanLevel1Maze {
    // Define wall positions for Pac-Man level 1 maze
    private static final int[][] WALL_POSITIONS = {
            // Outer walls
            {0, 0, 635, 10}, {0, 470, 635, 15},

            //left-top
            {0, 320, 10, 165},

            //left-bottom
            {0,0,10,150},

            //right-top
            {630, 320, 15, 165},

            //right-bottom
            {630, 0, 15, 150},

            // Middle walls
            //left
            {0, 260, 80, 10}, {80, 260, 10, 60}, {0, 320, 85,10},
            {0, 210, 80, 10}, {80, 150, 10, 65}, {0, 150, 80, 10},


            //right
            {560, 260, 80, 10}, {560, 260, 10, 60}, {560, 320, 80, 10},
            {560, 210, 80, 10}, {560, 150, 10, 60}, {560, 150, 80, 10},

            //top

            {320, 395, 20, 85},
    };

    public static int[][] getWallPositions() {
        return WALL_POSITIONS;
    }
    //{x , y, width, height }
    //max range
    //x: 640
    //y: 480
    //x mid: 320
    // y mid: 240
}