package com.vaultborn.entities.characters.mobs;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.vaultborn.entities.characters.Character;

public class Gorgon extends Mob{
    public Gorgon(Vector2 position, TextureRegion texture, int lvl) {
        super(position, texture, "Elvia", lvl, 33);
        this.hp = 100*lvl;
        this.damage = 4*lvl;
        this.defense = 5*lvl;
        this.level = lvl;
        this.agility = 10*lvl;
        this.range = 1;

    }

    public Gorgon(Vector2 position, int lvl) {
        super(position,"Elvia", lvl, 33);
        this.hp = 100*lvl;
        this.damage = 4*lvl;
        this.defense = 5*lvl;
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
        addAnimation("idle", loadTexture("gorgon/Idle.png"), 7, 0.1f);
        addAnimation("walk", loadTexture("gorgon/Walk.png"), 13, 0.1f);
        addAnimation("attack", loadTexture("gorgon/Attack_1.png"), 16, 0.20f);
        addAnimation("attack2", loadTexture("gorgon/Attack_2.png"), 7, 0.20f);
        addAnimation("attack3", loadTexture("gorgon/Attack_3.png"), 10, 0.20f);
        addAnimation("jump", loadTexture("gorgon/Idle_2.png"), 5, 0.09f);
        addAnimation("protect", loadTexture("gorgon/Special.png"), 5, 2f);
        addAnimation("dead", loadTexture("gorgon/Dead.png"), 3, 0.15f);
        addAnimation("hurt", loadTexture("gorgon/Hurt.png"), 3, 0.15f);

    }
}
