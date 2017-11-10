
import java.util.*;

public class Mot

{ private int debutx;
  private int debuty; 
  private int finx;
  private int finy; 
  // debutx == finx || debuty == finy
  private List Lettres = new ArrayList(); // of Lettre
  private int valeur = 0;

  private int special = -1;  // index of special CaseAbdoul if any
  
  public Mot(int x1,int y1,int x2,int y2)
  { debutx = x1;
    debuty = y1;
    finx = x2;
    finy = y2;
  }

  public Mot(int x1,int y1,int x2,int y2, String s)
  { this(x1,y1,x2,y2); 
    for (int i = 0; i < s.length(); i++)
    { char c = s.toLowerCase().charAt(i); 
      Lettre lett = (Lettre) Scrabble.builder.getLettre(c).clone(); 
      Lettres.add(lett); 
    }
  }

  public void setLettres(List letts) 
  { Lettres = letts; } 

  public void setspecial(int prem)
  { special = prem; } 

  public int getspecial() 
  { return special; } 

  public int getdebutX() { return debutx; }

  public int getdebutY() { return debuty; }

  public int getfinX() { return finx; }

  public int getfinY() { return finy; }

  public Lettre getLettre(int i)
  { return (Lettre) Lettres.get(i); } 

  public int getLength()
  { if (debutx == finx) 
    { return finy - debuty + 1; } 
    else 
    { return finx - debutx + 1; } 
  } 

  public boolean isVertical()
  { return debutx == finx; } 

  public boolean isHorizontal()
  { return debuty == finy; } 

  private CaseAbdoul getCaseAbdoul(int i, Tableau b)
  { if (isVertical())
    { return b.getCaseAbdoul(debutx,debuty+i); } 
    return b.getCaseAbdoul(debutx+i,debuty); 
  }

  public int getvaleur(Tableau b)
  { int factor = 1; 
    for (int i = 0; i < Lettres.size(); i++) 
    { Lettre l = (Lettre) Lettres.get(i); 
      CaseAbdoul sq = getCaseAbdoul(i,b); // CaseAbdoul under i'th Lettre
      if (sq.estOcupee()) // already covered, by l
      { valeur += l.getValeur(); } 
      else 
      { valeur += sq.getlettreValeur(l); 
        factor *= sq.getMotValeur(); 
      } 
    } 
    valeur = valeur*factor; 
    // System.out.println("valeur for Mot " + Lettres + " is " + valeur); 
    return valeur; 
  } 

  public boolean dansMot(PlaceLettre pl)
  { int x = pl.getX(); 
    int y = pl.getY(); 
    return (debutx <= x && x <= finx &&
            debuty <= y && y <= finy); 
  } // and Lettres are the same?  
    // lm.getLettre().equals(Lettres.get(x - debutx + y - debuty))

      
  public void ajoutDebut(Lettre l)
  { Lettres.add(0,l); }

  public void ajoutFin(Lettre l)
  { Lettres.add(l); }

  public void setDebutX(int x)
  { debutx = x; }

  public void setDebutY(int y)
  { debuty = y; }

  public void setFinX(int x)
  { finx = x; }

  public void setFinY(int y)
  { finy = y; }

  public String toString()
  { String res = ""; 
    for (int i = 0; i < Lettres.size(); i++)
    { res = res + ((Lettre) Lettres.get(i)); }
    return res;
  }

  public boolean equals(Object obj)
  { if (obj instanceof Mot)
    { Mot wd = (Mot) obj; 
      if (wd.toString().equals(toString()) &&
          wd.getdebutX() == debutx &&
          wd.getdebutY() == debuty &&
          wd.getfinX() == finx &&
          wd.getfinY() == finy)
      { return true; }
    }
    return false;
  }

  public List allLettres(List rackLettres, int disp)
  { if (debutx == finx) 
    { return allVerticalLettres(rackLettres,disp); } 
    else 
    { return allHorizLettres(rackLettres,disp); } 
  } 

  private List allVerticalLettres(List rLettres, int disp)
  { if (disp + debuty > finy) { return null; } 
    if (disp > special) { return null; } 
    boolean found = false; 
    int rsize = rLettres.size(); 
    // if (special < 7 - rsize) { return null; } 
    // otherwise, debut at 7 - rsize, fin at prem. disp: (7 - rsize)..prem
    List res = new ArrayList(); 
    int p = 0; 
    int i = disp; 

    // add occupied CaseAbdouls before the debut of line to be filled:  
    int k = i - 1; 
    for ( ; k >= 0; k--)
    { String st = "" + ((Lettre) Lettres.get(k)); 
      if (st.equals("*")) { break; } 
      res.add(0,st); 
      found = true; 
    }
    while (i < finy - debuty + 1 && p < rsize) 
    { String loc = "" + ((Lettre) Lettres.get(i)); 
      if (loc.equals("*"))
      { res.add(rLettres.get(p)); 
        p++; 
      } 
      else 
      { res.add(loc);
        found = true; 
      } 
      i++; 
    } 
    while (i < finy - debuty + 1)  // p == rsize
    { String loc = "" + ((Lettre) Lettres.get(i)); 
      if (loc.equals("*"))
      { break; } 
      else 
      { res.add(loc); 
        found = true; 
      } 
      i++; 
    }
    if (!found) { return null; } 

    res.add(0,new Integer(i-1)); 
    res.add(0,new Integer(k+1)); 
    return res; 
  }     

  private List allHorizLettres(List rLettres, int disp)
  { if (disp + debutx > finx) { return null; } 
    if (disp > special) { return null; } 
    boolean found = false; 
    int rsize = rLettres.size(); 
    // if (special < 7 - rsize) { return null; } 
    // otherwise, debut at 7 - rsize, fin at prem. disp: (7 - rsize)..prem
    List res = new ArrayList(); 
    int p = 0; 
    int i = disp; 

    // add occupied CaseAbdouls before the debut of line to be filled:  
    int k = i - 1; 
    for ( ; k >= 0; k--)
    { String st = "" + ((Lettre) Lettres.get(k)); 
      if (st.equals("*")) { break; } 
      res.add(0,st); 
      found = true; 
    }
    while (i < finx - debutx + 1 && p < rsize) 
    { String loc = "" + ((Lettre) Lettres.get(i)); 
      if (loc.equals("*"))
      { res.add(rLettres.get(p)); 
        p++; 
      } 
      else 
      { res.add(loc);
        found = true; 
      } 
      i++; 
    } 
    while (i < finx - debutx + 1)  // p == rsize
    { String loc = "" + ((Lettre) Lettres.get(i)); 
      if (loc.equals("*"))
      { break; } 
      else 
      { res.add(loc); 
        found = true; 
      } 
      i++; 
    }
    if (!found) { return null; } 

    res.add(0,new Integer(i-1)); 
    res.add(0,new Integer(k+1)); 
    return res; 
  }     

  public List fitsY(String letts, int disp) 
  { // checks if letts fits into range debuting at disp. Returns new Lettres
    List res = new ArrayList(); 
    for (int i = disp; i < finy - debuty + 1; i++) 
    { String loc = "" + ((Lettre) Lettres.get(i)); 
      if (i < letts.length())
      { String lett = "" + letts.charAt(i); 
        if (loc.equals("*"))  // new Lettre to be placed in move
        { Lettre ll = 
            (Lettre) 
              Scrabble.builder.getLettre(lett.toLowerCase().charAt(0)).clone(); 
          res.add(new PlaceLettre(debutx, i + debuty, ll));
        } 
        else if (loc.equalsIgnoreCase(lett)) // existing Lettres, must be same
        { } 
        else 
        { return new ArrayList(); }  // doesn't fit
      }
    }
    return res; 
  } 

  public List fitsX(String letts, int disp) 
  { // checks if letts fits into range debuting at disp. Returns new Lettres
    List res = new ArrayList(); 
    for (int i = disp; i < finx - debutx + 1; i++) 
    { String loc = "" + ((Lettre) Lettres.get(i)); 
      if (i < letts.length())
      { String lett = "" + letts.charAt(i); 
        if (loc.equals("*"))  // new Lettre to be placed in move
        { Lettre ll = 
            (Lettre) 
              Scrabble.builder.getLettre(lett.toLowerCase().charAt(0)).clone(); 
          res.add(new PlaceLettre(debutx + i,debuty, ll));
        } 
        else if (loc.equalsIgnoreCase(lett)) // existing Lettres, must be same
        { } 
        else 
        { return new ArrayList(); }  // doesn't fit
      }
    }
    return res; 
  } 

  public static void main(String[] args)
  { Mot w = new Mot(1,4,1,11,"***shco*");
    System.out.println(w.fitsY("slishcom",0)); 
  }  
       
}

