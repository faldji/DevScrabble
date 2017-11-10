
import java.util.*;
import javax.swing.*; 

public class PlaceLettre
{ private int x;
  private int y;
  private Lettre Lettre;

  public PlaceLettre(int xx, int yy, Lettre l)
  { x = xx;
    y = yy;
    Lettre = l;
  }

  public int getX()
  { return x; }

  public int getY()
  { return y; }

  public Lettre getLettre()
  { return Lettre; }
 
  public List trouveMot(Tableau b)
  { List res = trouveMotHorizontal(b);
    res.addAll(trouveMotVertical(b));
    return res;
  }

  public List trouveMotHorizontal(Tableau b)
  { List res = new ArrayList();
    // if no left-right adjacent Lettres:
    if (x == 0 || 
        !b.estOcupee(x-1,y))
    { if (x == 14 ||
          !b.estOcupee(x+1,y))
      { // System.out.println("Nothing to left or right of " + x +
        //                    " " + y);
        return res;
      }
      int i = x+1;
      Mot w = new Mot(x,y,0,y); // endx unknown
      w.ajoutFin(Lettre);
      // System.out.println("New Mot: " + w); 
      while (i <= 14 &&
             b.estOcupee(i,y))
      { w.ajoutFin(b.getCaseAbdoul(i,y).getlettre());
        // System.out.println("Found Mot: " + w); 
        i++;
      }
      w.setFinX(i-1);
      res.add(w);
      return res;
    }
    int k = x-1;
    Mot w1 = new Mot(0,y,0,y); // xstart, xend?
    // System.out.println("New Mot: " + w1); 
    w1.ajoutFin(Lettre); 
    while (k >= 0 &&
           b.estOcupee(k,y))
    { w1.ajoutDebut(b.getCaseAbdoul(k,y).getlettre());
      // System.out.println("Found Mot: " + w1); 
      k--;
    }
    w1.setDebutX(k+1);
    int i = x+1;
    while (i <= 14 && 
           b.estOcupee(i,y))
    { w1.ajoutFin(b.getCaseAbdoul(i,y).getlettre());
      // System.out.println("Found Mot: " + w1); 
      i++;
    }
    w1.setFinX(i-1);
    res.add(w1);
    return res;
  }

  public List trouveMotVertical(Tableau b)
  { List res = new ArrayList();
    // if no up-down adjacent Lettres:
    if (y == 0 || 
        !b.estOcupee(x,y-1))
    { if (y == 14 ||
          !b.estOcupee(x,y+1))
      { // System.out.println("Nothing above, below " + x +
        //                    " " + y);
        return res;
      }
      int j = y+1;
      Mot w = new Mot(x,y,x,0); // endy unknown
      w.ajoutFin(Lettre);
      // System.out.println("New Mot: " + w); 
      while (j <= 14 &&
             b.estOcupee(x,j))
      { w.ajoutFin(b.getCaseAbdoul(x,j).getlettre());
        // System.out.println("Found Mot: " + w); 
        j++;
      }
      w.setFinY(j-1);
      res.add(w);
      return res;
    }
    int k = y-1;
    Mot w1 = new Mot(x,0,x,0);
    // System.out.println("New Mot: " + w1); 
    w1.ajoutFin(Lettre); 
    while (k >= 0 &&
           b.estOcupee(x,k))
    { w1.ajoutDebut(b.getCaseAbdoul(x,k).getlettre());
      // System.out.println("Found Mot: " + w1); 
      k--;
    }
    w1.setDebutY(k+1);
    int j = y+1;
    while (j <= 14 && 
           b.estOcupee(x,j))
    { w1.ajoutFin(b.getCaseAbdoul(x,j).getlettre());
      // System.out.println("Found Mot: " + w1); 
      j++;
    }
    w1.setFinY(j-1);
    res.add(w1);
    return res;
  }
          
  public static PlaceLettre PlaceUneLettre(Tableau b,
                                          Grille r)
  { String num = 
        JOptionPane.showInputDialog(
                      "Enter x-coord de 1..15");
    int x = Integer.parseInt(num);
    if (x < 1 || x > 15)
    { System.out.println("Error, non valide");
      return null;
    }
    x--;
    num = 
        JOptionPane.showInputDialog(
                      "Entrer y-coord de 1..15");
    int y = Integer.parseInt(num);
    if (y < 1 || y > 15)
    { System.out.println("Erreur, non valide");
      return null;
    }
    y--;
    // if already occupied:
    CaseAbdoul sq = b.getCaseAbdoul(x,y);
    Lettre lt = sq.getlettre();
    if (lt != null)
    { System.out.println("Dejà occupée");
      return null;
    }
    int GrilleSize = r.tailleGrille();
    num = 
        JOptionPane.showInputDialog(
                      "Selection un element de la grille: 1.." +
                      GrilleSize);
    int n = Integer.parseInt(num);
    if (n < 1 || n > GrilleSize)
    { System.out.println("Erreur, Trop Long");
      return null;
    }
    n--;
    Lettre l = r.getLettre(n);
    return new PlaceLettre(x,y,l);
  }

  public int getScore(Tableau b)
  { CaseAbdoul CaseAbdoul = b.getCaseAbdoul(x,y);
    return CaseAbdoul.getlettreValeur(Lettre);
  }

  public String toString()
  { return "Lettre placée: " + Lettre + " en: " + x + " " + y; } 


}  




