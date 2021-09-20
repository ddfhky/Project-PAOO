package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.Graphics.ImageLoader;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;
import PaooGame.UI.ClickListener;
import PaooGame.UI.UIImageButton;
import PaooGame.UI.UIManager;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class public class MenuState extends State
    \brief Implementeaza notiunea de menu pentru joc.
 */
public class WinState extends State
{

    private UIManager uiManager;
    private BufferedImage background;

    /*! \fn public MenuState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public WinState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza.
        super(refLink);

        background= ImageLoader.LoadImage("res/textures/winStateBackground.png");

        uiManager=new UIManager(refLink);

        refLink.GetMouseManager().setUIManager(uiManager); //pentru a se vedea animatia butonului

       /* uiManager.addObject(new UIImageButton(288, 96, 128, 64, Assets.btn_exit, new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUIManager(null);
                State.SetState(refLink.GetGame().level1_Part1);
            }
        }) );
*/
       /* uiManager.addObject(new UIImageButton(288, 160, 128, 64, Assets.btn_storage, new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUIManager(null);
                //State.SetState(refLink.GetGame().playState);
            }
        }) );
*/
        uiManager.addObject(new UIImageButton(9* Tile.TILE_WIDTH, 8*Tile.TILE_HEIGHT, 128, 64, Assets.btn_exit, new ClickListener() {
            @Override
            public void onClick() {
                System.exit(0);
            }
        }) );


    }


    @Override
    public void SetAsCurrent(){
        super.SetAsCurrent();
        refLink.GetMouseManager().setUIManager(uiManager);
    }

    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniului.
     */
    @Override
    public void Update()
    {
        //System.out.println(refLink.GetMouseManager().getMouseX()+"     "+refLink.GetMouseManager().getMouseY()); //afiseaza coordonatele unde se afla mouse-ul
        uiManager.Update();

    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(background,0,0,null); //deseneaza background-ul
        uiManager.draw(g);
    }
}
