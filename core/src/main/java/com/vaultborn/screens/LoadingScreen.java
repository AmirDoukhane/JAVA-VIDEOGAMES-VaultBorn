package com.vaultborn.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vaultborn.MainGame;
import com.vaultborn.factories.Factory;
import com.vaultborn.factories.FactoryException;
import com.vaultborn.world.DungeonWorld;
import com.vaultborn.world.ForestWorld;
import com.vaultborn.world.HellWorld;

public class LoadingScreen implements Screen {

    private final MainGame game;
    private final com.badlogic.gdx.scenes.scene2d.ui.Skin skin;
    private final String classKey;
    private final boolean isContinue;

    private SpriteBatch batch;
    private BitmapFont font;
    private int frameCount = 0;

    public LoadingScreen(MainGame game, com.badlogic.gdx.scenes.scene2d.ui.Skin skin, String classKey) {
        this.game = game;
        this.skin = skin;
        this.classKey = classKey;
        this.isContinue = false;
    }

    public LoadingScreen(MainGame game, com.badlogic.gdx.scenes.scene2d.ui.Skin skin) {
        this.game = game;
        this.skin = skin;
        this.classKey = null;
        this.isContinue = true;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        font = MainGame.getFont();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.05f, 0.05f, 0.08f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        float cx = Gdx.graphics.getWidth() / 2f;
        float cy = Gdx.graphics.getHeight() / 2f;

        batch.begin();
        font.getData().setScale(2f);
        font.draw(batch, "Chargement en cours...", cx - 200f, cy + 20f);
        font.getData().setScale(1f);
        batch.end();

        frameCount++;
        if (frameCount < 2) return;

        try {
            if (isContinue) {
                game.loadGame();
            } else {
                startNewGame();
            }
        } catch (FactoryException e) {
            throw new RuntimeException(e);
        }
    }

    private void startNewGame() throws FactoryException {
        Factory factory = new Factory();

        game.forestWorld = new ForestWorld(game);
        game.hellWorld = new HellWorld(game);
        game.dungeonWorld = new DungeonWorld(game);

        game.currentWorld = game.forestWorld;
        game.player = factory.createPlayer(classKey, 350, 400, game.forestWorld);
        game.forestWorld.setPlayer(game.player);
        game.player.setInput(game.inputManager.allInput());

        game.forestWorld.linkWorlds();
        game.dungeonWorld.linkWorlds();
        game.hellWorld.linkWorlds();

        InventoryPlayer inv = new InventoryPlayer(false);
        game.player.setInventory(inv);
        inv.setPlayer(game.player);

        game.setScreen(new GameScreen(game, game.forestWorld, skin));
    }

    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}

    @Override
    public void dispose() {
        if (batch != null) batch.dispose();
    }
}
