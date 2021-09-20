package PaooGame.Tiles.Lvl2.Pam;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class Pam16Tile extends Tile
{
    /*! \fn public GrassTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public Pam16Tile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.pam16, id);
    }

    public boolean IsSolid()
    {
        return true;
    }
}

