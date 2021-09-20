package PaooGame.Tiles.Lvl2.Pam;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class Pam6_nesolTile extends Tile
{
    /*! \fn public GrassTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public Pam6_nesolTile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.pam6_nesol, id);
    }

    public boolean IsSolid()
    {
        return false;
    }
}

