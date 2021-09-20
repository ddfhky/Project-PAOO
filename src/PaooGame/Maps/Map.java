package PaooGame.Maps;

import PaooGame.Graphics.ImageLoader;
import PaooGame.Items.Attacks.AttackManager;
import PaooGame.Items.Hero;
import PaooGame.Items.ItemManager;
import PaooGame.RefLinks;
import PaooGame.StaticItem.Cufar;
import PaooGame.Tiles.Element;
import PaooGame.Tiles.ElementManager;
import PaooGame.Tiles.Tile;
import PaooGame.Tiles.Utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/*! \class public class Map
    \brief Implementeaza notiunea de harta a jocului.
 */
public abstract class Map
{
    protected RefLinks refLink;   /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/
    protected int width;          /*!< Latimea hartii in numar de dale.*/
    protected int height;         /*!< Inaltimea hartii in numar de dale.*/
    public int [][][] tiles;     /*!< Referinta catre o matrice cu codurile dalelor ce vor construi harta.*/

    //Items
    protected ItemManager itemManager;
    protected ElementManager elementManager;

    protected BufferedImage background;

    private int spawnX, spawnY;

    protected AttackManager attackManager;

    protected ArrayList<Element> elementsToBeRefreshed;

    /*! \fn public Map(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public Map(String[] paths, RefLinks links)
    {
            /// Retine referinta "shortcut".
       refLink = links;
            ///incarca harta de start. Functia poate primi ca argument id-ul hartii ce poate fi incarcat.

        //ADAUGAM ENTITATILE------------------------------

        itemManager=new ItemManager(refLink,new Hero(refLink,0,0));
        //itemManager.addItem(new MonstruletVerde(refLink,190,256));


        //ADAUGAM ELEMENTE DIN INVENTAR------------------------------
        elementManager=new ElementManager(refLink);

        //MANAGER DE ATACURI-------------------------------------
        attackManager=new AttackManager(refLink);

        LoadWorld(paths);

        itemManager.getHero().SetX(spawnX);
        itemManager.getHero().SetY(spawnY);

        elementsToBeRefreshed=new ArrayList<Element>();

    }

    /*! \fn public  void Update()
        \brief Actualizarea hartii in functie de evenimente (un copac a fost taiat)
     */
    public  void Update()
    {
        elementManager.Update();
        itemManager.Update();
        attackManager.Update();
    }

    /*! \fn public void Draw(Graphics g)
        \brief Functia de desenare a hartii.

        \param g Contextl grafi in care se realizeaza desenarea.
     */
    public void Draw(Graphics g) //FUNCTIA CARE DESENEAZA DALELE
    {
            ///Se parcurge matricea de dale (codurile aferente) si se deseneaza harta respectiva

        g.drawImage(background,0,0,null);


        for(int layer=0;layer<tiles.length;layer++)
        {
            for(int y = 0; y < refLink.GetGame().GetHeight()/Tile.TILE_HEIGHT; y++)
        {
                for(int x = 0; x < refLink.GetGame().GetWidth()/Tile.TILE_WIDTH; x++)
            {
                    GetTile(layer,x, y).Draw(g, (int)x * Tile.TILE_HEIGHT, (int)y * Tile.TILE_WIDTH);
            }
        }
        }

        //Items

        elementManager.Draw(g);
        itemManager.Draw(g);
        attackManager.Draw(g);
    }

    /*! \fn public Tile GetTile(int x, int y)
        \brief Intoarce o referinta catre dala aferenta codului din matrice de dale.

        In situatia in care dala nu este gasita datorita unei erori ce tine de cod dala, coordonate gresite etc se
        intoarce o dala predefinita (ex. grassTile, mountainTile)
     */


    public Tile GetTile(int layer,int x, int y)
    {
        Tile t=null;
        if(x<0||y<0||x>=width||y>=height)
        {
            return Tile.piatraTile;
        }
        try {
            t=Tile.tiles[tiles[layer][x][y]];
        } catch(Exception s){
            System.out.println("nskfs");
        }

        if(t==null)
                return Tile.pamant4Tile;
        return t;

    }

    /*! \fn private void LoadWorld()
        \brief Functie de incarcare a hartii jocului.
        Aici se poate genera sau incarca din fisier harta. Momentan este incarcata static.
     */
    private void LoadWorld(String[] paths) {
        //atentie latimea si inaltimea trebuiesc corelate cu dimensiunile ferestrei sau
        //se poate implementa notiunea de camera/cadru de vizualizare al hartii
        ///Se stabileste latimea hartii in numar de dale.
        // width = 22;
        ///Se stabileste inaltimea hartii in numar de dale
        //  height = 12;
        ///Se construieste matricea de coduri de dale
        //  tiles = new int[width][height];
        //Se incarca matricea cu coduri
       /* for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                tiles[x][y] = 0;
            }
        }*/


        tiles = new int[paths.length][width][height];

        for (int layer = 0; layer < paths.length; layer++) {
            String file = Utils.loadFileAsString(paths[layer]);
            String[] tokens = file.split("\\s+");
            int readWidth = Utils.parseInt(tokens[0]);
            int readHeight = Utils.parseInt(tokens[1]);

            spawnX = Utils.parseInt(tokens[2]);
            spawnY = Utils.parseInt(tokens[3]);

            if(layer==0)
            {
                width=readWidth;
                height=readHeight;
                tiles=new int[paths.length][width][height];
            }
            else if(readWidth!=width||readHeight!=height){
                //
            }


            for (int y = 0; y < height; y++)
                for (int x = 0; x < width; x++)
                    tiles[layer][x][y] = Utils.parseInt(tokens[(x + y * width) + 4]); //adaugam 4 deoarece avem deja 4 luate, alea de sus

        }
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public RefLinks getRefLink() {
        return refLink;
    }

    public void setRefLink(RefLinks refLink) {
        this.refLink = refLink;
    }

    public ElementManager getElementManager() {
        return elementManager;
    }

    public void setElementManager(ElementManager elementManager) {
        this.elementManager = elementManager;
    }

    public int getLayersNumber(){
        return tiles.length;
}

    public void Refresh(){
        ArrayList<Element> list=elementManager.getElements();
        for(int i=0;i<elementsToBeRefreshed.size();i++) {
            boolean found=false;
            for(int j=0;j<list.size();j++)
                if(list.get(j).getX()==elementsToBeRefreshed.get(i).getX() && list.get(j).getY()==elementsToBeRefreshed.get(i).getY())
                    found=true;
            if(!found)
                elementManager.addElement(elementsToBeRefreshed.get(i).CreateNew(elementsToBeRefreshed.get(i).getX(),elementsToBeRefreshed.get(i).getY()));
        }
    }

    public AttackManager getAttackManager() {
        return attackManager;
    }

    public void setAttackManager(AttackManager attackManager) {
        this.attackManager = attackManager;
    }



}