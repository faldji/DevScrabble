
public abstract class Joueur {
	protected String nom;
	protected int score = 0;
	protected MainJoueur main;
	protected Grille grille;
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public MainJoueur getMain() {
		return main;
	}
	public void setMain(MainJoueur main) {
		this.main = main;
	}
	public Grille getGrille() {
		return this.grille;
	}
	public void ajoutScore(int x)
	  { this.score += x; }
	public String getnom() {
		return this.nom;
	}
	public void setnom(String nm) {
		this.nom = nm;
	}
	public abstract Place deplacer(Tableau b);
	public Joueur(String nm) {
		this.nom = nm;
		this.grille = new Grille();
	}
	public Joueur(int score, MainJoueur main) {
		super();
		this.score = score;
		this.main = main;
		this.grille = new Grille();
	}
	
	 public String toString()
	  { return nom; } 
	 class Humain extends Joueur
	 { // to make a move, user enters each letter move
	   public Humain(String nme)
	   { super(nme); }

	   public Place deplacer(Tableau b)
	   { return Place.Placement(this,b); } 
	 }

	 class IA extends Joueur
	 { // calculates optimal move
	   public IA(String nme)
	   { super(nme); }

	   public Place deplacer(Tableau b)
	   { return Place.Placement(this,b); } 
	 }

	
	
	
}
