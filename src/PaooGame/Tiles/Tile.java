package PaooGame.Tiles;

import PaooGame.Tiles.IarbaTiles.IarbaDreaptaJosTile;
import PaooGame.Tiles.IarbaTiles.IarbaStangaJosTile;
import PaooGame.Tiles.IarbaTiles.IarbaTile;
import PaooGame.Tiles.Lvl2.Ciuperci.Ciuperca1Tile;
import PaooGame.Tiles.Lvl2.Ciuperci.Ciuperca2Tile;
import PaooGame.Tiles.Lvl2.Cop.*;
import PaooGame.Tiles.Lvl2.Cutie.*;
import PaooGame.Tiles.Lvl2.Cop.Cop1Tile;
import PaooGame.Tiles.Lvl2.Cutie.Cutie1Tile;
import PaooGame.Tiles.Lvl2.Ind.Ind1Tile;
import PaooGame.Tiles.Lvl2.Ind.Ind2Tile;
import PaooGame.Tiles.Lvl2.Ind.Ind3Tile;
import PaooGame.Tiles.Lvl2.Ind.Ind4Tile;
import PaooGame.Tiles.Lvl2.Pam.*;
import PaooGame.Tiles.Lvl2.Pam.Pam2Tile;
import PaooGame.Tiles.Lvl2.PiatrTile;
import PaooGame.Tiles.Lvl2.RadacinaTile;
import PaooGame.Tiles.Lvl2.apa.Apa1Tile;
import PaooGame.Tiles.Lvl2.apa.Apa2Tile;
import PaooGame.Tiles.Lvl2.apa.Apa3Tile;
import PaooGame.Tiles.Lvl2.apa.Apa4Tile;
import PaooGame.Tiles.Lvl2.castle.*;
import PaooGame.Tiles.Lvl2.tufis.*;
import PaooGame.Tiles.ScaraTiles.*;
import PaooGame.Tiles.PiatraTiles.*;
import PaooGame.Tiles.PamantTiles.*;
import PaooGame.Tiles.IndicatoareTiles.*;
import PaooGame.Tiles.IederaTiles.*;
import PaooGame.Tiles.FloareTiles.*;
import PaooGame.Tiles.FelinarTiles.*;
import PaooGame.Tiles.CufarTiles.*;
import PaooGame.Tiles.CopacTiles.*;
import PaooGame.Tiles.TransparentTiles.TransparentTile;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class public class Tile
    \brief Retine toate dalele intr-un vector si ofera posibilitatea regasirii dupa un id.
 */
public class Tile
{
    private static final int NO_TILES   = 300;
    public static Tile[] tiles          = new Tile[NO_TILES];       /*!< Vector de referinte de tipuri de dale.*/

        /// De remarcat ca urmatoarele dale sunt statice si publice. Acest lucru imi permite sa le am incarcate
        /// o singura data in memorie
    //public static Tile grassTile        = new GrassTile(0);     /*!< Dala de tip iarba*/
    //public static Tile mountainTile     = new MountainTile(1);  /*!< Dala de tip munte/piatra*/
    //public static Tile waterTile        = new WaterTile(2);     /*!< Dala de tip apa*/
    //public static Tile treeTile         = new TreeTile(3);      /*!< Dala de tip copac*/
    //public static Tile soilTile         = new SoilTile(4);      /*!< Dala de tip sol/pamant*/

    public static Tile transparentTile              = new TransparentTile(0);

    public static Tile scara1Tile                   = new Scara1Tile(1);
    public static Tile scara2Tile                   = new Scara2Tile(2);
    public static Tile scara3Tile                   = new Scara3Tile(3);
    public static Tile scara4Tile                   = new Scara4Tile(4);

    public static Tile piatraTile                   = new PiatraTile(5);

    public static Tile pamant1Tile                  = new Pamant1Tile(6);
    public static Tile pamant2Tile                  = new Pamant2Tile(7);
    public static Tile pamant3Tile                  = new Pamant3Tile(8);
    public static Tile pamant4Tile                  = new Pamant4Tile(9);
    public static Tile pamant5Tile                  = new Pamant5Tile(10);
    public static Tile pamant6Tile                  = new Pamant6Tile(11);

    public static Tile indicatorDreaptaTile         = new IndicatorDreaptaTile(12);

    public static Tile indicatorAmbele1Tile         = new IndicatorAmbele1Tile(13);
    public static Tile indicatorAmbele2Tile         = new IndicatorAmbele2Tile(14);

    public static Tile iedera1Tile                  = new Iedera1Tile(15);
    public static Tile iedera2Tile                  = new Iedera2Tile(16);

    public static Tile floareTile                   = new FloareTile(17);

    public static Tile felinar1Tile                 = new Felinar1Tile(18);
    public static Tile felinar2Tile                 = new Felinar2Tile(19);

    public static Tile cufarTile                    = new CufarTile(20);

    public static Tile copac1Tile                   = new Copac1Tile(21);
    public static Tile copac2Tile                   = new Copac2Tile(22);
    public static Tile copac3Tile                   = new Copac3Tile(23);
    public static Tile copac4Tile                   = new Copac4Tile(24);
    public static Tile copac5Tile                   = new Copac5Tile(25);
    public static Tile copac6Tile                   = new Copac6Tile(26);
    public static Tile copac7Tile                   = new Copac7Tile(27);
    public static Tile copac8Tile                   = new Copac8Tile(28);
    public static Tile copac9Tile                   = new Copac9Tile(29);
    public static Tile copac10Tile                  = new Copac10Tile(30);
    public static Tile copac11Tile                  = new Copac11Tile(31);
    public static Tile copac12Tile                  = new Copac12Tile(32);

    public static Tile iarbaTile                    = new IarbaTile(33);

    public static Tile pamant1_solidTile            = new Pamant1SolidTile(34);
    public static Tile pamant4_solidTile            = new Pamant4SolidTile(37);

    public static Tile iarbaStangaJosTil            = new IarbaStangaJosTile(35);
    public static Tile iarbaDreaptaJosTile          = new IarbaDreaptaJosTile(36);

    public static Tile apa1Tile                     = new Apa1Tile(37);
    public static Tile apa2Tile                     = new Apa2Tile(38);
    public static Tile apa3Tile                     = new Apa3Tile(39);
    public static Tile apa4Tile                     = new Apa4Tile(40);

    public static Tile ciuperca1Tile                = new Ciuperca1Tile(41);
    public static Tile ciuperca2Tile                = new Ciuperca2Tile(42);

    public static Tile cop1Tile                     = new Cop1Tile(43);
    public static Tile cop2Tile                     = new Cop2Tile(44);
    public static Tile cop3Tile                     = new Cop3Tile(45);
    public static Tile cop4Tile                     = new Cop4Tile(46);
    public static Tile cop5Tile                     = new Cop5Tile(47);
    public static Tile cop6Tile                     = new Cop6Tile(48);
    public static Tile cop7Tile                     = new Cop7Tile(49);
    public static Tile cop8Tile                     = new Cop8Tile(50);
    public static Tile cop9Tile                     = new Cop9Tile(51);
    public static Tile cop10Tile                    = new Cop10Tile(52);
    public static Tile cop11Tile                    = new Cop11Tile(53);
    public static Tile cop12Tile                    = new Cop12Tile(54);
    public static Tile cop13Tile                    = new Cop13Tile(55);
    public static Tile cop14Tile                    = new Cop14Tile(56);
    public static Tile cop15Tile                    = new Cop15Tile(57);
    public static Tile cop16Tile                    = new Cop16Tile(58);

    public static Tile cutie1Tile                   = new Cutie1Tile(59);
    public static Tile cutie2Tile                   = new Cutie2Tile(60);
    public static Tile cutie3Tile                   = new Cutie3Tile(61);
    public static Tile cutie4Tile                   = new Cutie4Tile(62);
    public static Tile cutie5Tile                   = new Cutie5Tile(63);

    public static Tile ind1Tile                     = new Ind1Tile(64);
    public static Tile ind2Tile                     = new Ind2Tile(65);
    public static Tile ind3Tile                     = new Ind3Tile(66);
    public static Tile ind4Tile                     = new Ind4Tile(67);

    public static Tile pam1Tile                     = new Pam1Tile(68);
    public static Tile pam2Tile                     = new Pam2Tile(69);
    public static Tile pam3Tile                     = new Pam3Tile(70);
    public static Tile pam4Tile                     = new Pam4Tile(71);
    public static Tile pam5Tile                     = new Pam5Tile(72);
    public static Tile pam6Tile                     = new Pam6Tile(73);
    public static Tile pam7Tile                     = new Pam7Tile(74);
    public static Tile pam8Tile                     = new Pam8Tile(75);
    public static Tile pam9Tile                     = new Pam9Tile(76);
    public static Tile pam10Tile                    = new Pam10Tile(77);
    public static Tile pam11Tile                    = new Pam11Tile(78);
    public static Tile pam12Tile                    = new Pam12Tile(79);
    public static Tile pam13Tile                    = new Pam13Tile(80);
    public static Tile pam14Tile                    = new Pam14Tile(81);
    public static Tile pam15Tile                    = new Pam15Tile(82);
    public static Tile pam16Tile                    = new Pam16Tile(83);
    public static Tile pam17Tile                    = new Pam17Tile(84);
    public static Tile pam18Tile                    = new Pam18Tile(85);
    public static Tile pam19Tile                    = new Pam19Tile(86);
    public static Tile pam20Tile                    = new Pam20Tile(87);
    public static Tile pam21Tile                    = new Pam21Tile(88);

    public static Tile tufis1Tile                   = new Tufis1Tile(89);
    public static Tile tufis2Tile                   = new Tufis2Tile(90);
    public static Tile tufis3Tile                   = new Tufis3Tile(91);
    public static Tile tufis4Tile                   = new Tufis4Tile(92);
    public static Tile tufis5Tile                   = new Tufis5Tile(93);
    public static Tile tufis6Tile                   = new Tufis6Tile(94);

    public static Tile piatrTile                    = new PiatrTile(95);
    public static Tile radacinaTile                 = new RadacinaTile(96);

    public static Tile pam4_nesolTile               = new Pam4_nesolTile(97);
    public static Tile pam5_nesolTile               = new Pam5_nesolTile(98);
    public static Tile pam6_nesolTile               = new Pam6_nesolTile(99);
    public static Tile pam7_nesolTile               = new Pam7_nesolTile(100);
    public static Tile pam8_nesolTile               = new Pam8_nesolTile(101);
    public static Tile pam9_nesolTile               = new Pam9_nesolTile(102);

    public static Tile castle1Tile                  =new Castle1Tile(103);
    public static Tile castle2Tile                  =new Castle2Tile(104);
    public static Tile castle3Tile                  =new Castle3Tile(105);
    public static Tile castle4Tile                  =new Castle4Tile(106);
    public static Tile castle5Tile                  =new Castle5Tile(107);
    public static Tile castle6Tile                  =new Castle6Tile(108);
    public static Tile castle7Tile                  =new Castle7Tile(109);
    public static Tile castle8Tile                  =new Castle8Tile(110);
    public static Tile castle9Tile                  =new Castle8Tile(111);
    public static Tile castle10Tile                  =new Castle10Tile(112);
    public static Tile castle11Tile                  =new Castle11Tile(113);
    public static Tile castle12Tile                  =new Castle12Tile(114);
    public static Tile castle13Tile                  =new Castle13Tile(115);
    public static Tile castle14Tile                  =new Castle14Tile(116);
    public static Tile castle15Tile                  =new Castle15Tile(117);
    public static Tile castle16Tile                  =new Castle16Tile(118);
    public static Tile castle17Tile                  =new Castle17Tile(119);
    public static Tile castle18Tile                  =new Castle18Tile(120);
    public static Tile castle19Tile                  =new Castle19Tile(121);
    public static Tile castle20Tile                  =new Castle20Tile(122);
    public static Tile castle21Tile                  =new Castle21Tile(123);



    public static final int TILE_WIDTH  = 32;                       /*!< Latimea unei dale.*/
    public static final int TILE_HEIGHT = 32;                       /*!< Inaltimea unei dale.*/
    public static int length;

    protected BufferedImage img;                                    /*!< Imaginea aferenta tipului de dala.*/
    protected final int id;                                         /*!< Id-ul unic aferent tipului de dala.*/

    /*! \fn public Tile(BufferedImage texture, int id)
        \brief Constructorul aferent clasei.

        \param image Imaginea corespunzatoare dalei.
        \param id Id-ul dalei.
     */
    public Tile(BufferedImage image, int idd)
    {
        img = image;
        id = idd;

        tiles[id] = this;
    }

    /*! \fn public void Update()
        \brief Actualizeaza proprietatile dalei.
     */
    public void Update()
    {

    }

    /*! \fn public void Draw(Graphics g, int x, int y)
        \brief Deseneaza in fereastra dala.

        \param g Contextul grafic in care sa se realizeze desenarea
        \param x Coordonata x in cadrul ferestrei unde sa fie desenata dala
        \param y Coordonata y in cadrul ferestrei unde sa fie desenata dala
     */
    public void Draw(Graphics g, int x, int y)
    {
            /// Desenare dala
        g.drawImage(img, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    /*! \fn public boolean IsSolid()
        \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
     */
    public boolean IsSolid()
    {
        return false;
    }
    public boolean OnLadder(){return false;}
    public boolean OnWater(){return false;}

    /*! \fn public int GetId()
        \brief Returneaza id-ul dalei.
     */
    public int GetId()
    {
        return id;
    }

    public boolean NextMap(){return false;}
}
