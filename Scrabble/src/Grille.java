
import java.util.*;
public class Grille 
{ private List lettres = new ArrayList(); // of Lettre
      
  public void addlettres(List l)
  { lettres.addAll(l); }  // highest scorers first

  public void removelettres(List l)
  { for (int i = 0; i < l.size(); i++) 
    { Lettre lett = (Lettre) l.get(i);
      int ind = lettres.indexOf(lett); // using Equals on Lettre
      if (ind >= 0)
      { lettres.remove(ind); } 
    }
  }

  public int tailleGrille()
  { return lettres.size(); }

  public Lettre getLettre(int i)
  { return (Lettre) lettres.get(i); }

  public String toString()
  { return lettres.toString(); }

  public List getSuffixes()
  { List res = new ArrayList(); 
    boolean e = false; 
    boolean d = false; 
    for (int i = 0; i < lettres.size(); i++)
    { Lettre lett = (Lettre) lettres.get(i); 
      if ("e".equals("" + lett))
      { e = true; } 
      else if ("d".equals("" + lett))
      { d = true; }
      else if ("s".equals("" + lett))
      { res.add("s"); } 
    } 
    if (e && d) 
    { res.add("ed"); } 
    return res; 
  } 
}
