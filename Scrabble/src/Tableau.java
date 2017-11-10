import java.util.*;

public class Tableau {
	
	 private CaseAbdoul[][] CaseAbdoul = new CaseAbdoul[15][15];
	  // CaseAbdoul[x][y] is CaseAbdoul at this coordinate
	  private List TousCases = new ArrayList(); 

	  public Tableau(Sac b)
	  { // uses b to do layout -- mostly standard
	    CaseAbdoul = b.getTableau();
	    for (int i = 0; i < 15; i++)
	    { for (int j = 0; j < 15; j++)
	      { TousCases.add(CaseAbdoul[i][j]); }
	    }
	  }

	  public Tableau(CaseAbdoul[][] arr) 
	  { CaseAbdoul = arr;
	    for (int i = 0; i < 15; i++)
	    { for (int j = 0; j < 15; j++)
	      { TousCases.add(CaseAbdoul[i][j]); }
	    }
	  } 

	  public Object clone()
	  { CaseAbdoul[][] newCaseAbdoul = new CaseAbdoul[15][15]; 
	    for (int i = 0; i < 15; i++) 
	    { for (int j = 0; j < 15; j++) 
	      { CaseAbdoul sq = (CaseAbdoul) CaseAbdoul[i][j].clone(); 
	        newCaseAbdoul[i][j] = sq; 
	      } 
	    } 
	    return new Tableau(newCaseAbdoul); 
	  } 

	  public CaseAbdoul getCaseAbdoul(int i, int j)
	  { return CaseAbdoul[i][j]; }

	  public ArrayList getLigne(int y)
	  { ArrayList res = new ArrayList(); 
	    for (int i = 0; i < 15; i++) 
	    { res.add(CaseAbdoul[i][y]); } 
	    return res; 
	  } 

	  public List getCaseAbdoul()
	  { return TousCases; }

	  public boolean estOcupee(int i, int j)
	  { return CaseAbdoul[i][j].estOcupee(); }
	 
	  public boolean AdjacentOcupee(int x, int y)
	  { int x0 = x;
	    int y0 = y;
	    int x1 = x;
	    int y1 = y;
	    if (x > 0)
	    { x0 = x-1; }
	    if (x < 14)
	    { x1 = x+1; }
	    if (y > 0)
	    { y0 = y-1; }
	    if (y < 14)
	    { y1 = y+1; }
	    return CaseAbdoul[x][y].estOcupee() ||
	           CaseAbdoul[x0][y].estOcupee() ||
	           CaseAbdoul[x1][y].estOcupee() ||
	           CaseAbdoul[x][y0].estOcupee() ||
	           CaseAbdoul[x][y1].estOcupee();
	  }

	  public boolean validMouv(Place p, int numb)
	  { return p.validatePlace(numb); } // check each created word is valid

	  public boolean placeMove(Place p, Tableau Tab)
	  { if (p == null) { return false; }
	    List lpl = p.getLettrePlace();
	    List connected = new ArrayList(); 
	    List disconnected = new ArrayList(); 

	    for (int i = 0; i < lpl.size(); i++)
	    { PlaceLettre pl = (PlaceLettre) lpl.get(i); 
	      Lettre l = pl.getLettre(); 
	      int x = pl.getX(); 
	      int y = pl.getY(); 
	      if (Tab.AdjacentOcupee(x,y))
	      { connected.add(pl); } 
	      else 
	      { disconnected.add(pl); } 
	      placeLettre(l,x,y); 
	    }

	    if (connected.size() == 0)
	    { System.out.println("Invalid move: disconnected moves " + disconnected); 
	      return false; 
	    } 
	    return true; 
	  }

	  public void placeLettre(Lettre l, int x, int y)
	  { CaseAbdoul[x][y].setlettre(l); }

	  public String toString()
	  { String res = "";
	    for (int j = 0; j < 15; j++)
	    { for (int i = 0; i < 15; i++)
	      { res = res + CaseAbdoul[i][j]; }
	      res = res + "\n";
	    }
	    return res;
	  }
	}

