package PaooGame.States;

import PaooGame.RefLinks;
import PaooGame.Maps.Map;

import java.awt.*;

/*! \class public class PlayState extends State
    \brief Implementeaza/controleaza jocul.
 */
public abstract class PlayState extends State
{
    //private Hero hero;  /*!< Referinta catre obiectul animat erou (controlat de utilizator).*/
    protected Map map;    /*!< Referinta catre harta curenta.*/
   // private MonstruletVerde monstruletVerde;
    protected int NrNivel;
    protected boolean ComingFromRight =false,ComingFromLeft=false;



    /*! \fn public PlayState(RefLinks refLink)
        \brief Constructorul de initializare al clasei

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public PlayState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza
        super(refLink);

    }

    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a jocului.
     */
    @Override
    public void Update()
    {
        refLink.SetMap(map);
        map.Update();
        //System.out.println(refLink.GetMouseManager().getMouseX()+"     " +refLink.GetMouseManager().getMouseY()); //afiseaza coordonatele unde se afla mouse-ul

    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a jocului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        map.Draw(g);
        //hero.Draw(g);
        //monstruletVerde.Draw(g);
    }
}
