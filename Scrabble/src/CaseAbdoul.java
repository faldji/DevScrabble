import javax.swing.*;
	import java.awt.*;
public abstract class CaseAbdoul {

protected Lettre lettre = null;
	  protected int x; 
	  protected int y; 

	  public CaseAbdoul() { }

	  public CaseAbdoul(int xx, int yy)
	  { x = xx; 
	    y = yy; 
	  } 

	  public CaseAbdoul(Lettre l)
	  { lettre = l; } 

	  public void setlettre(Lettre l)
	  { lettre = l; }

	  public void setX(int xx) 
	  { x = xx; } 

	  public void setY(int yy) 
	  { y = yy; } 

	  public int getX()
	  { return x; } 

	  public int getY()
	  { return y; }

	  public void Vider()
	  { lettre = null; } 

	  public Lettre getlettre()
	  { return lettre; }

	  public boolean estOcupee()
	  { return lettre != null; } 

	  // hook method:
	  public abstract int getlettreValeur(Lettre l);
	  
	  // template method:
	  public int getlettreValeur()
	  { if (lettre == null)
	    { return 0; }
	    return getlettreValeur(lettre);
	  }

	  public abstract int getMotValeur(); 

	  // hook method:
	  public abstract String CaseAbdoulSymbol();
	  
	  // template method:
	  public String toString()
	  { String res = "[";
	    if (lettre != null)
	    { res = res + lettre + "]"; }
	    else 
	    { res = res + CaseAbdoulSymbol() + "]"; }
	    return res;
	  }

	  public String getText()
	  { if (lettre != null)
	    { return lettre + ""; }
	    return CaseAbdoulSymbol();
	  }

	  public abstract Color getColor();

	  public abstract Object clone(); 
	}


	class SimpleCaseAbdoul extends CaseAbdoul
	{ public SimpleCaseAbdoul(Lettre l)
	  { super(l); } 

	  public SimpleCaseAbdoul()
	  { super(); }

	  public SimpleCaseAbdoul(int xx, int yy)
	  { super(xx,yy); } 

	  public Object clone()
	  { CaseAbdoul res = new SimpleCaseAbdoul(lettre); 
	    res.setX(x); 
	    res.setY(y); 
	    return res; 
	  } 

	  public int getlettreValeur(Lettre l)
	  { return l.getValeur(); }

	  public int getMotValeur()
	  { return 1; } 

	  public String CaseAbdoulSymbol()
	  { return "-"; }

	  public Color getColor()
	  { return new Color(0,89,85); } 
	}


	class LdCaseAbdoul extends CaseAbdoul
	{
	  public LdCaseAbdoul()
	  { super(); }

	  public LdCaseAbdoul(int xx, int yy)
	  { super(xx,yy); } 

	  public LdCaseAbdoul(Lettre l)
	  { super(l); } 

	  public Object clone()
	  { CaseAbdoul res = new LdCaseAbdoul(lettre); 
	    res.setX(x); 
	    res.setY(y); 
	    return res; 
	  } 

	  public int getlettreValeur(Lettre l)
	  { return 2*l.getValeur(); }

	  public int getMotValeur()
	  { return 1; } 

	  public String CaseAbdoulSymbol()
	  { return "~"; }

	  public Color getColor()
	  { return new Color(130,207,248); } 
	}


	class LtCaseAbdoul extends CaseAbdoul
	{ public LtCaseAbdoul()
	  { super(); }

	  public LtCaseAbdoul(Lettre l)
	  { super(l); }

	  public LtCaseAbdoul(int xx, int yy)
	  { super(xx,yy); } 

	  public Object clone()
	  { CaseAbdoul res = new LtCaseAbdoul(lettre); 
	    res.setX(x); 
	    res.setY(y); 
	    return res; 
	  } 

	  public int getlettreValeur(Lettre l)
	  { return 3*l.getValeur(); }

	  public int getMotValeur()
	  { return 1; } 

	  public String CaseAbdoulSymbol()
	  { return "="; }

	  public Color getColor()
	  { return new Color(0,155,220); } 
	}


	class MdCaseAbdoul extends CaseAbdoul
	{ public MdCaseAbdoul(Lettre l)
	  { super(l); } 

	  public MdCaseAbdoul()
	  { super(); }

	  public MdCaseAbdoul(int xx, int yy)
	  { super(xx,yy); } 

	  public Object clone()
	  { return new MdCaseAbdoul(lettre); } 

	  public int getlettreValeur(Lettre l)
	  { return l.getValeur(); }

	  public int getMotValeur()
	  { return 2; } 

	  public String CaseAbdoulSymbol()
	  { return "*"; }

	  public Color getColor()
	  { return Color.pink; } 
	}


	class MtCaseAbdoul extends CaseAbdoul
	{ public MtCaseAbdoul(Lettre l)
	  { super(l); } 

	  public MtCaseAbdoul()
	  { super(); }

	  public MtCaseAbdoul(int xx, int yy)
	  { super(xx,yy); } 

	  public Object clone()
	  { return new MtCaseAbdoul(lettre); } 

	  public int getlettreValeur(Lettre l)
	  { return l.getValeur(); }

	  public int getMotValeur()
	  { return 3; } 

	  public String CaseAbdoulSymbol()
	  { return "#"; }

	  public Color getColor()
	  { return new Color(238,26,40); } 
	
}
