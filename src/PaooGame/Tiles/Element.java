package PaooGame.Tiles;

import PaooGame.Graphics.Assets;
import PaooGame.Items.Hero;
import PaooGame.RefLinks;
import PaooGame.States.Levels.LevelFlags;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Element {

    public static final int Element_WIDTH=32, Element_HEIGHT=32;

    public static Element[] elements=new Element[256];
    public static Element BluePotion_Element=new Element(Assets.BluePotion, "blue potion", 0);
    public static Element WhiteDiamond_Element=new Element(Assets.WhiteDiamond,"white diamond",1);
    public static Element BlueDiamond_Element=new Element(Assets.BlueDiamond,"blue diamond",2);
    public static Element RedDiamond_Element=new Element(Assets.RedDiamond,"red diamond",3);
    public static Element Piesa1=new Element(Assets.puzzle1,"piesa 1",4);
    public static Element Piesa2=new Element(Assets.puzzle2,"piesa 2",5);
    public static Element Piesa3=new Element(Assets.puzzle3,"piesa 3",6);
    public static Element Piesa4=new Element(Assets.puzzle4,"piesa 4",7);
    public static Element coin=new Element(Assets.coin,"coins",8,Element_WIDTH/2,Element_HEIGHT/2);

    private int width, height;


    private final int id;

    protected RefLinks refLink;
    protected BufferedImage texture;
    protected String name;
   // protected final int id;

    protected int x,y,count;
    protected boolean pickedUp=false;

    protected Rectangle bounds;

    public Element(BufferedImage texture, String name, int id)
    {
        this(texture,name,id,Element_WIDTH,Element_HEIGHT);
    }

    public Element(BufferedImage texture, String name, int id, int width, int height)
    {
        this.texture=texture;
        this.name=name;
        this.id = id;
        count=1;
        this.width=width;
        this.height=height;

        bounds=new Rectangle(x,y,width,height);

        elements[id]=this;
    }

    public void Update() {
        try {
            if (refLink.GetMap().getItemManager().getHero().getCollisionsBounds(0f, 0f).intersects(bounds)) {
                pickedUp = true;
                if (id == 4 || id == 5 || id == 6 || id == 7) {
                    LevelFlags.level1_piese[id - 4] = true;
                }
                Hero.getStorage().addElement(this);
            }
        } catch (Exception e){
            System.out.println("fnsjbvbcikel");
        }
    }

    public void Draw(Graphics g)
    {
        if(refLink==null)
            return;
        Draw(g,(int)(x),(int)(y));
    }

    public void Draw(Graphics g, int x, int y)
    {
        g.drawImage(texture,x,y,width,height,null);
    }

    public Element CreateNew(int count)
    {
        Element el=new Element(texture, name, id);
        el.setPickedUp(true);
        el.setCount(count);
        return el;
    }

    public Element CreateNew(int x, int y)
    {
        Element el=new Element(texture, name, id,width, height);
        el.SetPosition(x,y);
        return el;
    }

    public void SetPosition(int x, int y)
    {
        this.x=x;
        this.y=y;
        bounds.x=x;
        bounds.y=y;
    }


    //Getters and Setters

    public RefLinks getRefLink() {
        return refLink;
    }

    public void setRefLink(RefLinks refLink) {
        this.refLink = refLink;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isPickedUp() {
        return pickedUp;
    }

    public void setPickedUp(boolean pickedUp) {
        this.pickedUp = pickedUp;
    }
}
