package com.pacman.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ghost {
    float x;
    float y;
    int size;
    int xSpeed;
    int ySpeed;

    Sprite ghostSprite;

    public Ghost(float initialX, float initialY) {
        Texture ghostTexture = new Texture(Gdx.files.internal("RedGhostLookCenter.png"));

        ghostSprite = new Sprite(ghostTexture);

        this.x = initialX;
        this.y = initialY;

        ghostSprite.setPosition(x, y);
    }

    public void render(SpriteBatch batch) {
        ghostSprite.draw(batch);
    }

    public void update(float deltaTime) {
        //movement logic
    }


}
