package PaooGame.Items.Attacks;



import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class AttackManager {

    private RefLinks refLinks;
    private ArrayList<Attack> attacks;

    public AttackManager(RefLinks refLinks)
    {
        this.refLinks=refLinks;
        attacks=new ArrayList<Attack>();

    }

    public void Update(){

        Iterator<Attack> it=attacks.iterator();
        while(it.hasNext())
        {
            Attack e=it.next();
            e.Update();
            if(!e.isActive())
                it.remove();
        }
    }

    public void Draw(Graphics g)
    {


        for(Attack e: attacks) //for(int i=0;i<items.size();i++) Item e=items.get(i);
        {
            g.drawImage(e.getCurrentFrame(),(int)e.GetX(),(int)e.GetY(), Tile.TILE_WIDTH,Tile.TILE_HEIGHT,null);
            System.out.println("Atac");
        }

    }

    public void addAttack(Attack e)
    {
        attacks.add(e);
    }


    //---

    public ArrayList<Attack> getAttacks() {
        return attacks;
    }

    public void setAttacks(ArrayList<Attack> attacks) {
        this.attacks = attacks;
    }

    public RefLinks getRefLinks() {
        return refLinks;
    }

    public void setRefLinks(RefLinks refLinks) {
        this.refLinks = refLinks;
    }

}
