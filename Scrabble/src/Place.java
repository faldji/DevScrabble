
import java.util.*;
import javax.swing.*; 
public class Place 
{ private List mots = new ArrayList(); // of Mot
  // the new mots formed by this Place
  private List letterPlaces = new ArrayList(); 
  // of LetterPlace, the individual new tiles on board
  private int Valeur = 0;  // total Valeur of this Place
  private Joueur p;       // Joueur who Placed

  public Place(Joueur pl)
  { p = pl; }

  public Place(Joueur pl, List Places)
  { letterPlaces = Places;
    p = pl; 
  }

  public Place(Joueur pl, int scre, List Places)
  { this(pl,Places); 
    setValeur(scre); 
  }

  public Place(Joueur pl, Mot wd, Tableau b)
  { p = pl; 
    int x1 = wd.getdebutX(); 
    int y1 = wd.getdebutY(); 
    int x2 = wd.getfinX(); 
    int y2 = wd.getfinY(); 
    int len = 0; 
    if (x1 < x2)
    { len = x2 - x1 + 1; 
      for (int i = 0; i < len; i++) 
      { letterPlaces.add(new PlaceLettre(x1+i,y1,wd.getLettre(i))); } 
    } 
    else if (y1 < y2)  
    { len = y2 - y1 + 1; 
      for (int i = 0; i < len; i++) 
      { letterPlaces.add(new PlaceLettre(x1,y1+i,wd.getLettre(i))); } 
    } 
    // findmots(b); 
  }
    
  public void clearmots()
  { mots = new ArrayList(); } 

  public void ajouterPlaceLettre(PlaceLettre lm)
  { letterPlaces.add(lm); }

  public void setValeur(int x)
  { Valeur = x; } 

  public List getLettrePlace()
  { return letterPlaces; }

  public List getmots()
  { return mots; }

  public List getLettre()
  { List res = new ArrayList(); 
    for (int i = 0; i < letterPlaces.size(); i++) 
    { PlaceLettre lm = (PlaceLettre) letterPlaces.get(i); 
      res.add(lm.getLettre()); 
    } 
    return res; 
  }   

  public static Place Placement(Joueur pl, Tableau b)
  { Grille r = pl.getGrille();
    System.out.println("Your rack is: " + r);
    System.out.println("Select locations on the board");
    System.out.println("to place letters from your rack.");
    System.out.println("All letters placed must be in");
    System.out.println("a single vertical/horizontal line.");
    List Places = new ArrayList();
    String finish = 
        JOptionPane.showInputDialog(
                      "Enter quit to finish Place");
    while (finish != null && !finish.equals("quit"))
    { PlaceLettre lm = PlaceLettre.PlaceUneLettre(b,r);
      if (lm != null)
      { Places.add(lm); }
      finish = 
        JOptionPane.showInputDialog(
                      "Enter quit to finish Place");
    }
    return new Place(pl,Places);
  }

  public boolean validatePlace(int numb) // numb of Places
  { // all must be in line
    boolean res = true; 
    Set xcoords = new TreeSet();
    Set ycoords = new TreeSet();
    for (int i = 0; i < letterPlaces.size(); i++)
    { PlaceLettre lm = (PlaceLettre) letterPlaces.get(i);
      xcoords.add(new Integer(lm.getX()));
      ycoords.add(new Integer(lm.getY()));
      if (xcoords.size() > 1 &&
          ycoords.size() > 1)  // error
      { return false; }
    }
    if (numb == 1) // must contain 7,7 location
    { Integer seven = new Integer(7);
      if (xcoords.contains(seven) &&
          ycoords.contains(seven))
      { res = true; }
      else 
      { res = false; }
    }                                     
    for (int i = 0; i < mots.size(); i++)
    { Mot wd = (Mot) mots.get(i); 
      boolean res1 = Dictionnaire.verifie2(wd); 
      System.out.println("Mot " + wd + " in dictionary: " + res1);
      // res = res && res1;  
    } 
    return res;
  }

 

  public boolean dansDico()
  { boolean res = true; 
    for (int i = 0; i < mots.size(); i++)
    { Mot wd = (Mot) mots.get(i); 
      boolean res1 = Dictionnaire.verifie2(wd); 
      System.out.println("Mot " + wd + " in dictionary: " + res1);
      res = res && res1;  
    } 
    return res;
  }  

  public boolean trouvemots(Tableau b)
  { int lmsize = letterPlaces.size();
    if (lmsize == 0)
    { mots = new ArrayList();
      return false;
    } 
    PlaceLettre lm1 = (PlaceLettre) letterPlaces.get(0);
    PlaceLettre lm2 = (PlaceLettre) letterPlaces.get(lmsize-1);

    int x1 = lm1.getX();
    int x2 = lm2.getX();
    int y1 = lm1.getY();
    int y2 = lm2.getY();

    if (x1 == x2 && y1 == y2) // single letter Place
    { mots = lm1.trouveMotVertical(b); 
      mots.addAll(lm1.trouveMotHorizontal(b));
      return true; 
    } 

    if (x1 == x2) // vertical Place
    { List allvert = lm1.trouveMotVertical(b); 
      if (allvert.size() == 1)
      { mots.addAll(allvert); }  // only one
      else 
      { return false; }
      Mot vertMot = (Mot) allvert.get(0); 
  
      for (int i = 0; i < lmsize; i++)
      { PlaceLettre lm = (PlaceLettre) letterPlaces.get(i);
        if (vertMot.dansMot(lm))
        { mots.addAll(lm.trouveMotHorizontal(b)); }
        else 
        { System.out.println("Disconnected letterPlace: " + lm); 
          return false; 
        } 
      }
      return true; 
    }

    if (y1 == y2)  // horizontal Place
    { List allhoriz = lm1.trouveMotHorizontal(b);
      if (allhoriz.size() == 1)
      { mots.addAll(allhoriz); }
      else 
      { return false; } 
      Mot horizMot = (Mot) allhoriz.get(0); 

      for (int j = 0; j < lmsize; j++)
      { PlaceLettre lm = (PlaceLettre) letterPlaces.get(j);
        if (horizMot.dansMot(lm))
        { mots.addAll(lm.trouveMotVertical(b)); }
        else 
        { System.out.println("Disconnected letterPlace: " + lm); 
          return false; 
        }         
      }
    }
    return true; 
  }

  public int getValeur(Tableau b)
  { int total = 0;
    for (int i = 0; i < mots.size(); i++)
    { Mot wd = (Mot) mots.get(i);
      total += wd.getvaleur(b);
    }
    if (letterPlaces.size() == 7) // bonus
    { total += 50; }
    Valeur = total;
    return total;
  }

  public String toString()
  { String res = "Place: Joueur " + p + " Valeur = " + Valeur + "\n"; 
    for (int i = 0; i < letterPlaces.size(); i++)
    { PlaceLettre lm = (PlaceLettre) letterPlaces.get(i); 
      res = res + " letter Place: " + lm + "\n"; 
    }
    return res;
  }

 
}

