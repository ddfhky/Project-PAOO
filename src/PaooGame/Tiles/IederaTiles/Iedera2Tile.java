package PaooGame.Tiles.IederaTiles;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class Iedera2Tile extends Tile
{
    /*! \fn public GrassTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public Iedera2Tile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.iedera2, id);
    }
}
