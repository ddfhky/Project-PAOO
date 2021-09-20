package PaooGame.Items.Monsters;

import PaooGame.Items.Character;
import PaooGame.Items.Hero;
import PaooGame.RefLinks;
import PaooGame.Tiles.Animation;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public abstract class Monster extends Character {

    //protected Animation animTransf_dr,animTransf_stg;
    protected BufferedImage image;

    public Monster(RefLinks refLink, float x, float y, int width, int height, BufferedImage image) {
        super(refLink, x, y, width, height);
        this.image=image;

        normalBounds.width = DEFAULT_CREATURE_WIDTH/4;
        normalBounds.height = DEFAULT_CREATURE_HEIGHT/4;
        normalBounds.x = DEFAULT_CREATURE_WIDTH/8;
        normalBounds.y = DEFAULT_CREATURE_HEIGHT/8;

        attackBounds.width = DEFAULT_CREATURE_WIDTH/2;
        attackBounds.height = DEFAULT_CREATURE_HEIGHT/2;
        attackBounds.x = DEFAULT_CREATURE_WIDTH/4;
        attackBounds.y = DEFAULT_CREATURE_HEIGHT/4;
        speed/=8;
    }

    @Override
    public void Move()
    {
        Random random=new Random();
        if(random.nextInt(2)==1)
            xMove=-speed;
        else
            xMove=speed;
        super.Move();
    }

    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(image,(int)(x),(int)(y),width,height,null);
    }

    @Override
    public void Update()
    {
        //daca eroul atinge inamicul, il trimite la inceput
        Hero hero=refLink.GetMap().getItemManager().getHero();
        Rectangle heroBounds=hero.getCollisionsBounds(0,0);
        Rectangle attackBounds=new Rectangle((int)x+this.attackBounds.x,(int)y+this.attackBounds.y,
                this.attackBounds.width,this.attackBounds.height);

        if(heroBounds.intersects(attackBounds))
        {
            hero.SetX(Tile.TILE_WIDTH);
            hero.SetY(9*Tile.TILE_HEIGHT);
        }

        Move();



    }

}
