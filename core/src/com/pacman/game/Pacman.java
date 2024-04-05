package com.pacman.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Random;


public class Pacman extends ApplicationAdapter {

	Stage stage;
	ShapeRenderer shape;
	Ball ball;
	ArrayList<Coin> coins;
	ArrayList<Wall> walls;
//	Ghost ghost;



	@Override
	public void create () {
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		shape = new ShapeRenderer();
		ball = new Ball(150, 200,12);
		coins = new ArrayList<>();
		walls = new ArrayList<>();
		generateRandomCoins(10);

		//add maze walls
		int[][] wallPositions = PacmanLevel1Maze.getWallPositions();
		for(int[] position : wallPositions) {
			walls.add(new Wall(position[0], position[1], position[2], position[3]));
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0,0,0,0);
		ScreenUtils.clear(0,0,0,0);

		stage.draw();
		shape.begin(ShapeRenderer.ShapeType.Filled);

		//wall
		for (Wall wall : walls) {
			wall.draw(shape);
		}

		//update and draw player
		ball.update();
		ball.updatePosition(walls);
		shape.setColor(ball.color);
		shape.circle(ball.x, ball.y, ball.size);
		shape.end();

		//draw coins
		for(Coin coin: coins) {
			coin.draw(shape);
		}


		//check collisions
		ball.checkCollision(coins);

		//check if all coins are collected
		if (allCoinsCollected()) {
			generateRandomCoins(10);
		}
	}

	private void generateRandomCoins(int numCoins) {
		Random random = new Random();
		int screenWidth = Gdx.graphics.getWidth();
		int screenHeight = Gdx.graphics.getHeight();
		float coinSize = 10;

		for (int i =0; i < numCoins; i++) {
			float randomX = random.nextFloat() * (screenWidth - coinSize * 2) + coinSize;
			float randomY = random.nextFloat() * (screenHeight - coinSize * 2) + coinSize;

			Coin coin = new Coin(randomX, randomY, coinSize);

			coins.add(coin);
		}
	}

	private boolean allCoinsCollected() {
		for (Coin coin : coins) {
			if (!coin.isCollected()) {
				return false;
			}
		}
		return true;
	}

}
