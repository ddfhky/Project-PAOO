package PaooGame.Items;

import java.awt.*;
import java.awt.image.BufferedImage;

import PaooGame.Items.Attacks.Explosion;
import PaooGame.Items.Monsters.Monster;
import PaooGame.Items.NPC.NPC;
import PaooGame.RefLinks;
import PaooGame.Graphics.Assets;
import PaooGame.Storage.Storage;
import PaooGame.Tiles.Animation;

/*! \class public class Hero extends Character
    \brief Implementeaza notiunea de erou/player (caracterul controlat de jucator).

    Elementele suplimentare pe care le aduce fata de clasa de baza sunt:
        imaginea (acest atribut poate fi ridicat si in clasa de baza)
        deplasarea
        atacul (nu este implementat momentan)
        dreptunghiul de coliziune
 */
public class Hero extends Character {

    private final Animation animRight;
    private final Animation animLeft;
    private final Animation animDown;
    private final Animation animUp;

    //private BufferedImage image;    /*!< Referinta catre imaginea curenta a eroului.*/

    //Attack timer
    //private long lastAttackTimer, attackCooldown=300, attackTimer=attackCooldown;

    //Storage
    private static Storage storage=null;



    /*! \fn public Hero(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al clasei Hero.

        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a eroului.
        \param y Pozitia initiala pe axa Y a eroului.
     */
    public Hero(RefLinks refLink, float x, float y) {
        ///Apel al constructorului clasei de baza
        super(refLink, x, y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);
        ///Seteaza imaginea de start a eroului
        // image = Assets.heroLeft;
        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        normalBounds.x = 11;
        normalBounds.y = 14;
        normalBounds.width = 12;
        normalBounds.height = 19;

        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea de atac
        attackBounds.x = 10;
        attackBounds.y = 10;
        attackBounds.width = 38;
        attackBounds.height = 38;

        animRight = new Animation(500, Assets.Player_Right);
        animLeft = new Animation(500, Assets.Player_Left);
        animDown = new Animation(500, Assets.Player_Down);
        animUp = new Animation(500, Assets.Player_Up);

        if(storage==null)
            storage= new Storage(refLink);

    }


    /*! \fn public void Update()
        \brief Actualizeaza pozitia si imaginea eroului.
     */
    @Override
    public void Update() {
        animRight.Update();
        animLeft.Update();
       // animDown.Update();
        animUp.Update();

        STATE_SPEED+=0.15f;


        ///Verifica daca a fost apasata o tasta
        GetInput();
        ///Actualizeaza pozitia
        Move();
        checkAttacks();

        storage.Update();
    }

    private void checkAttacks()
    {
        /*attackTimer+=System.currentTimeMillis()-lastAttackTimer;
        lastAttackTimer=System.currentTimeMillis();
        if(attackTimer<attackCooldown)
            return;*/

        if(storage.isActive())
            return;

        Rectangle cb= getCollisionsBounds(0,0);
        Rectangle ar=new Rectangle();
        int arSize=20;
        ar.width=arSize;
        ar.height=arSize;

        if(refLink.GetKeyManager().open_cufar&&refLink.GetKeyManager().right) {
            ar.x = cb.x + cb.width;
            ar.y=cb.y+cb.height/2-arSize/2;
        }
        else if (refLink.GetKeyManager().open_cufar && refLink.GetKeyManager().left)
        {
            ar.x=cb.x-arSize;
            ar.y=cb.y+cb.height/2-arSize/2;
        }
        else if (refLink.GetKeyManager().open_cufar && refLink.GetKeyManager().up)
        {
            ar.x=cb.x+cb.width/2-arSize/2;
            ar.y=cb.y-arSize;
        }
        else if (refLink.GetKeyManager().open_cufar && refLink.GetKeyManager().down)
        {
            ar.x=cb.x+cb.width/2-arSize/2;
            ar.y=cb.y+ cb.height;
        }
        else return;


        for(Item e:refLink.GetMap().getItemManager().getItems()) {
            if (e.equals(this))
                continue;
            if (e.getCollisionsBounds(0,0).intersects(ar))
            {
                if(e instanceof NPC)
                {
                    ((NPC) e).Interact();
                    return;
                }
                if(e instanceof Monster)
                    refLink.GetMap().getAttackManager().addAttack(new Explosion((int)e.GetX(),(int)e.GetY()));
                e.hurt(1);
                return;
            }

        }
    }

    /*! \fn private void GetInput()
        \brief Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului.
     */
    private void GetInput() {
        ///Implicit eroul nu trebuie sa se deplaseze daca nu este apasata o tasta
        xMove = 0;
        yMove = 0;

        if(storage.isActive())
            return;


        if(onLadder)
        {
            STATE_SPEED=0;
            if(refLink.GetKeyManager().up)
                yMove=-speed;
            if(refLink.GetKeyManager().down)
                yMove=speed;
        }
        else {
            yMove+=STATE_SPEED;
            if (canJump && refLink.GetKeyManager().jump) {
                canJump = false;
                STATE_SPEED = VERTICAL_SPEED;
            }
        }


        ///Verificare apasare tasta "left"
        if (refLink.GetKeyManager().left) {
            xMove = -speed;
        }
        ///Verificare apasare tasta "dreapta"
        if (refLink.GetKeyManager().right) {
            xMove = speed;
        }

    }

    /*! \fn public void Draw(Graphics g)
        \brief Randeaza/deseneaza eroul in noua pozitie.

        \brief g Contextul grafi in care trebuie efectuata desenarea eroului.
     */
    @Override
    public void Draw(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) x, (int) y, width, height, null);

        ///doar pentru debug daca se doreste vizualizarea dreptunghiului de coliziune altfel se vor comenta urmatoarele doua linii
        //g.setColor(Color.blue);
        //g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);

    }

    public void PostDraw(Graphics g)
    {
        storage.Draw(g);
    }

    private BufferedImage getCurrentAnimationFrame() {
        if (xMove < 0)
            return animLeft.getCurrentFrame();
        else if (xMove > 0)
            return animRight.getCurrentFrame();
        else if (yMove < 0)
            return animUp.getCurrentFrame();
        else
            return animDown.getCurrentFrame();
    }

    @Override
    public void die()
    {
        System.out.println("You lose");

    }

    public static Storage getStorage() {
        return storage;
    }

    public static void setStorage(Storage storage) {
        Hero.storage = storage;
    }

}
