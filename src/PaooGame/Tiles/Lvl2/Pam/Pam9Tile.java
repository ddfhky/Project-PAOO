package PaooGame.Tiles.Lvl2.Pam;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class Pam9Tile extends Tile
{
    /*! \fn public GrassTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public Pam9Tile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.pam9, id);
    }
    public boolean IsSolid()
    {
        return true;
    }

}

