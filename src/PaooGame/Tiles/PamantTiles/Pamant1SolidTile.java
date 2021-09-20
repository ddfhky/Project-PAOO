package PaooGame.Tiles.PamantTiles;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class Pamant1SolidTile extends Tile
{
    /*! \fn public GrassTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public Pamant1SolidTile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.pamant1_solidTile, id);
    }

    @Override
    public boolean IsSolid() {
        return true;
    }
}

