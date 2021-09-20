package PaooGame.Items;

import PaooGame.Maps.Map;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;


/*! \class public abstract class Character extends Item
    \brief Defineste notiunea abstracta de caracter/individ/fiinta din joc.

    Notiunea este definita doar de viata, viteza de deplasare si distanta cu care trebuie sa se
    miste/deplaseze in urma calculelor.
 */
public abstract class Character extends Item
{
    public static final int DEFAULT_LIFE            = 10;   /*!< Valoarea implicita a vietii unui caracter.*/
    public static final float DEFAULT_SPEED         = 5.0f; /*!< Viteza implicita a unu caracter.*/
    public static final int DEFAULT_CREATURE_WIDTH  = 32;   /*!< Latimea implicita a imaginii caracterului.*/
    public static final int DEFAULT_CREATURE_HEIGHT = 32;   /*!< Inaltimea implicita a imaginii caracterului.*/


    protected float speed;  /*!< Retine viteza de deplasare caracterului.*/
    protected float xMove;  /*!< Retine noua pozitie a caracterului pe axa X.*/
    protected float yMove;  /*!< Retine noua pozitie a caracterului pe axa Y.*/

    protected static final float VERTICAL_SPEED = -4.5f; //viteza sariturii
    protected float STATE_SPEED; //starea vitezei
    protected boolean canJump=false;
    boolean onLadder=false;
    boolean onWater=false;

    /*! \fn public Character(RefLinks refLink, float x, float y, int width, int height)
        \brief Constructor de initializare al clasei Character

        \param refLink Referinta catre obiectul shortcut (care retine alte referinte utile/necesare in joc).
        \param x Pozitia de start pa axa X a caracterului.
        \param y Pozitia de start pa axa Y a caracterului.
        \param width Latimea imaginii caracterului.
        \param height Inaltimea imaginii caracterului.
     */
    public Character(RefLinks refLink, float x, float y, int width, int height)
    {
            ///Apel constructor la clasei de baza
        super(refLink, x,y, width, height);
            //Seteaza pe valorile implicite pentru viata, viteza si distantele de deplasare
        speed   = DEFAULT_SPEED;
        xMove   = 0;
        yMove   = 0;
    }

    /*! \fn public void Move()
        \brief Modifica pozitia caracterului
     */
    public void Move()
    {
        if(!checkItemCollisions(xMove,0f))
            ///Modifica pozitia caracterului pe axa X.
            ///Modifica pozitia caracterului pe axa Y.
            MoveX();
        if(!checkItemCollisions(0f,yMove))
            MoveY();

    }

    /*! \fn public void MoveX()
        \brief Modifica pozitia caracterului pe axa X.
     */
    public void MoveX()
    {
            ///Aduna la pozitia curenta numarul de pixeli cu care trebuie sa se deplaseze pe axa X.
        //x += xMove;

        if (xMove >0 ){ //move right

            boolean canMove=true;
            boolean ladder=false;


            int tx=(int) (x+xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
            for(int layer = 0; layer< refLink.GetMap().getLayersNumber(); layer++)
            {
            if(collisionWithTile(layer,tx, (int) (y+bounds.y) / Tile.TILE_HEIGHT) ||
                        collisionWithTile(layer,tx,(int) (y+bounds.y+bounds.height)/Tile.TILE_HEIGHT) || tx>=refLink.GetMap().getWidth()) // (upper right corner && lower right corner)
                {
                    canMove=false;
                    break;
                }

                if(LadderTile(layer,tx, (int) (y+bounds.y) / Tile.TILE_HEIGHT) ||
                        LadderTile(layer,tx,(int) (y+bounds.y+bounds.height)/Tile.TILE_HEIGHT) )
                {
                    ladder=true;
                    break;
                }


            }

            if(canMove)
                x+=xMove;
            else
                x=tx*Tile.TILE_WIDTH-bounds.x-bounds.width-1; //coliziune perfecta

            if(ladder)
                onLadder=true;
            else
                onLadder=false;


        }

        else if(xMove<0)

        { //move left

            boolean canMove=true;
            boolean ladder=false;


            int tx=(int) (x+xMove + bounds.x) / Tile.TILE_WIDTH;
            for(int layer = 0; layer< refLink.GetMap().getLayersNumber(); layer++)
            {
                if(collisionWithTile(layer,tx, (int) (y+bounds.y) / Tile.TILE_HEIGHT) ||
                        collisionWithTile(layer,tx,(int) (y+bounds.y+bounds.height)/Tile.TILE_HEIGHT) || tx<0 ) // (upper right corner && lower right corner)
                {
                    canMove=false;
                    break;
                }

                if(LadderTile(layer,tx, (int) (y+bounds.y) / Tile.TILE_HEIGHT) ||
                        LadderTile(layer,tx,(int) (y+bounds.y+bounds.height)/Tile.TILE_HEIGHT) )
                {
                    ladder=true;
                    break;
                }


            }
            if(canMove)
                x+=xMove;
            else
                x=tx*Tile.TILE_WIDTH+Tile.TILE_WIDTH-bounds.x; //coliziunea perfecta

            if(ladder)
                onLadder=true;
            else onLadder=false;


        }
    }

    /*! \fn public void MoveY()
        \brief Modifica pozitia caracterului pe axa Y.
     */
    public void MoveY()
    {
            ///Aduna la pozitia curenta numarul de pixeli cu care trebuie sa se deplaseze pe axa Y.
        if(yMove<0) //up
        {

            boolean canMove=true;



            int ty = (int) (y + yMove + bounds.y) / Tile.TILE_HEIGHT;

            for (int layer = 0; layer < refLink.GetMap().getLayersNumber(); layer++) {
                {
                    if (collisionWithTile(layer, (int) (x + bounds.x) / Tile.TILE_WIDTH, ty) ||
                            collisionWithTile(layer, (int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
                        canMove = false;
                        break;
                    }
                }

            }

            if(canMove)
                y+=yMove;
            else {
                y = ty * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - bounds.y; //coliziunea perfecta
            }



        }

        else if(yMove>0) //down
        {
            boolean canMove=true;

            int ty = (int) (y + yMove + bounds.y+bounds.height) / Tile.TILE_HEIGHT;

            for (int layer = 0; layer < refLink.GetMap().getLayersNumber(); layer++)
            {
            {
                if (collisionWithTile(layer, (int) (x + bounds.x) / Tile.TILE_WIDTH, ty) ||
                        collisionWithTile(layer, (int) (x + bounds.x+bounds.width) / Tile.TILE_WIDTH, ty))
                {
                    canMove=false;
                    break;
                }


            }
            }

            if(canMove)
                y+=yMove;
            else {
                y = ty * Tile.TILE_HEIGHT - bounds.y - bounds.height - 1; //coliziunea perfecta
                STATE_SPEED=0;
               /* if(refLink.GetKeyManager().up)
                    STATE_SPEED=VERTICAL_SPEED;*/
                canJump=true;
            }



        }

    }

    protected boolean collisionWithTile(int layer,int x, int y){
            return refLink.GetMap().GetTile(layer,x, y).IsSolid();
    }

  protected boolean LadderTile(int layer,int x, int y){
     return refLink.GetMap().GetTile(layer,x,y).OnLadder();
    }


    protected boolean NextMapTile(int layer, int x, int y) {
        return refLink.GetMap().GetTile(layer,x,y).NextMap();
    }

    /*! \fn public int GetLife()
        \brief Returneaza viata caracterului.
     */
    public int GetLife()
    {
        return life;
    }

    /*! \fn public int GetSpeed()
        \brief Returneaza viteza caracterului.
     */
    public float GetSpeed()
    {
        return speed;
    }

    /*! \fn public void SetLife(int life)
        \brief Seteaza viata caracterului.
     */
    public void SetLife(int life)
    {
        this.life = life;
    }

    /*! \fn public void SetSpeed(float speed)
        \brief
     */
    public void SetSpeed(float speed) {
        this.speed = speed;
    }

    /*! \fn public float GetXMove()
        \brief Returneaza distanta in pixeli pe axa X cu care este actualizata pozitia caracterului.
     */
    public float GetXMove()
    {
        return xMove;
    }

    /*! \fn public float GetYMove()
        \brief Returneaza distanta in pixeli pe axa Y cu care este actualizata pozitia caracterului.
     */
    public float GetYMove()
    {
        return yMove;
    }

    /*! \fn public void SetXMove(float xMove)
        \brief Seteaza distanta in pixeli pe axa X cu care va fi actualizata pozitia caracterului.
     */
    public void SetXMove(float xMove)
    {
        this.xMove = xMove;
    }

    /*! \fn public void SetYMove(float yMove)
        \brief Seteaza distanta in pixeli pe axa Y cu care va fi actualizata pozitia caracterului.
     */
    public void SetYMove(float yMove)
    {
        this.yMove = yMove;
    }





}

