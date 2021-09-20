package PaooGame.Items.Attacks;

import PaooGame.Tiles.Animation;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Attack extends Animation {

    protected int x,y;
    protected int length;
    protected boolean isActive=true;

    public Attack(int speed, BufferedImage[] frames,int length, int x, int y) {
        super(speed, frames);
        this.length=length;
        this.x=x;
        this.y=y;
    }

    @Override
    public void Update()
    {
        long currentTime=System.currentTimeMillis();
        timer+=currentTime-LastTime;
        length-=currentTime-LastTime;
        LastTime=System.currentTimeMillis();
        if(timer>speed)
        {
            timer=0;
            index=(index+1)%(frames.length);
        }
        if(length<=0)
            isActive=false;

    }

    public boolean isActive(){return isActive;}

    public float GetX(){return x;}

    public float GetY(){return y;}

    public void SetX(int x){this.x=x;}

    public void SetY(int y){this.y=y;}

}
