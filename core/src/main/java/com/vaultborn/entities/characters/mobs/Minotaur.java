package com.vaultborn.entities.characters.mobs;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.vaultborn.entities.characters.Character;

public class Minotaur extends Mob{
    public Minotaur(Vector2 position, TextureRegion texture, int lvl) {
        super(position, texture, "Gorm", lvl, 50);
        this.hp = 100*lvl;
        this.damage = 20*lvl;
        this.defense = 15*lvl;
        this.level = lvl;
        this.agility = 10*lvl;
        this.range = 1;

    }

    public Minotaur(Vector2 position, int lvl) {
        super(position, "Gorm", lvl, 33);
        this.hp = 100*lvl;
        this.damage = 20*lvl;
        this.defense = 15*lvl;
        this.level = lvl;
        this.agility = 10*lvl;
        this.range = 1;

    }

    @Override
    public void attack(Character target) {
        if (isDead) return;
        int dmg = Math.max(1, this.damage - target.getDefense());
        target.takeDamage(dmg);
    }

    public void loadAnimations() {
        addAnimation("idle", loadTexture("minotaur/Idle.png"), 10, 0.1f);
        addAnimation("walk", loadTexture("minotaur/Walk.png"), 12, 0.1f);
        addAnimation("attack", loadTexture("minotaur/Attack.png"), 5, 0.20f);
        addAnimation("attack2", loadTexture("minotaur/Attack.png"), 5, 0.20f);
        addAnimation("attack3", loadTexture("minotaur/Attack.png"), 5, 0.20f);
        addAnimation("jump", loadTexture("minotaur/Idle.png"), 10, 0.09f);
        addAnimation("protect", loadTexture("minotaur/Attack.png"), 5, 2f);
        addAnimation("dead", loadTexture("minotaur/Dead.png"), 5, 0.15f);
        addAnimation("hurt", loadTexture("minotaur/Hurt.png"), 3, 0.15f);

    }
}
