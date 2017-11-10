

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Case extends JPanel {

	public void paintComponent(Graphics g){

		Graphics2D g2d = (Graphics2D)g;
		List <Graphics> tab= new  ArrayList <Graphics>();
		for(int i=1; i<=15; i++){
			for(int j=1; j<=15; j++){
				int x=55+(45*j);
				int y=1+(45)*i;
				g.drawRect(x, y, 40, 40);
				tab.add(g);
				g.setColor(Color.black);
				
			}	
		}
		Color rouge = new Color(238,26,40);
		Color orange = new Color(255,150,90);
		Color bleue = new Color(0,155,220);
		Color cyan = new Color(130,207,248);
		///// rang1 //////
		GradientPaint gp = new  GradientPaint(50,50, rouge, 125, 75, rouge, true);
		g2d.setPaint(gp);
		g2d.fillRect(101, 47, 40, 40); //x, y, xplus, yplus
		GradientPaint gp2 = new  GradientPaint(40, 75, cyan, 80, 55, cyan, true);
		g2d.setPaint(gp2);
		g2d.fillRect(236, 47, 40, 40);
		GradientPaint gp3 = new  GradientPaint(0,0, rouge, 101, 10, rouge, true);
		g2d.setPaint(gp3);
		g2d.fillRect(416, 47, 40, 40);
		GradientPaint gp4 = new  GradientPaint(101,47, cyan, 0, 0, cyan, true);
		g2d.setPaint(gp4);
		g2d.fillRect(596, 47, 40, 40);
		GradientPaint gp5 = new  GradientPaint(125,75, rouge, 10, 0, rouge, true);
		g2d.setPaint(gp5);
		g2d.fillRect(731, 47, 40, 40);
		
		///// 2e rang //////
		GradientPaint gp11 = new  GradientPaint(0,0, orange, 101, 10, orange, true);
		g2d.setPaint(gp11);
		g2d.fillRect(146, 92, 40, 40); //x, y, xplus, yplus
		GradientPaint gp12 = new  GradientPaint(101,47, bleue, 0, 0, bleue, true);
		g2d.setPaint(gp12);
		g2d.fillRect(326, 92, 40, 40);
		GradientPaint gp13 = new  GradientPaint(0,0, bleue, 101, 10, bleue, true);
		g2d.setPaint(gp13);
		g2d.fillRect(506, 92, 40, 40);
		GradientPaint gp14 = new  GradientPaint(101,47, orange, 0, 0, orange, true);
		g2d.setPaint(gp14);
		g2d.fillRect(686, 92, 40, 40);
		
		///// 3e rang /////
		GradientPaint gp21 = new  GradientPaint(0,0, orange, 101, 10, orange, true);
		g2d.setPaint(gp21);
		g2d.fillRect(191, 137, 40, 40); //x, y, xplus, yplus
		GradientPaint gp22 = new  GradientPaint(101,47, cyan, 0, 0, cyan, true);
		g2d.setPaint(gp22);
		g2d.fillRect(371, 137, 40, 40);
		GradientPaint gp23 = new  GradientPaint(0,0, cyan, 101, 10, cyan, true);
		g2d.setPaint(gp23);
		g2d.fillRect(461, 137, 40, 40);
		GradientPaint gp24 = new  GradientPaint(101,47, orange, 0, 0, orange, true);
		g2d.setPaint(gp24);
		g2d.fillRect(641, 137, 40, 40);
		
		///// 4e rang /////
		GradientPaint gp31 = new  GradientPaint(0,0, cyan, 101, 10, cyan, true);
		g2d.setPaint(gp31);
		g2d.fillRect(101, 182, 40, 40); //x, y, xplus, yplus
		GradientPaint gp32 = new  GradientPaint(101,47, orange, 0, 0, orange, true);
		g2d.setPaint(gp32);
		g2d.fillRect(236, 182, 40, 40);
		GradientPaint gp33 = new  GradientPaint(0,0, cyan, 101, 10, cyan, true);
		g2d.setPaint(gp33);
		g2d.fillRect(416, 182, 40, 40);
		GradientPaint gp34 = new  GradientPaint(101,47, orange, 0, 0, orange, true);
		g2d.setPaint(gp34);
		g2d.fillRect(596, 182, 40, 40);
		GradientPaint gp35 = new  GradientPaint(0,0, cyan, 101, 10, cyan, true);
		g2d.setPaint(gp35);
		g2d.fillRect(731, 182, 40, 40);
		
		///// 5e rang /////
		GradientPaint gp40 = new  GradientPaint(101,47, orange, 0, 0, orange, true);
		g2d.setPaint(gp40);
		g2d.fillRect(281, 227, 40, 40);
		
		g2d.setPaint(gp40);
		g2d.fillRect(551, 227, 40, 40);
		
		///// 6e rang /////
		GradientPaint gp51 = new  GradientPaint(0,0, bleue, 100, 10, bleue, true);
		g2d.setPaint(gp51);
		g2d.fillRect(146, 272, 40, 40); //x, y, xplus, yplus
		GradientPaint gp52 = new  GradientPaint(101,47, bleue, 0, 0, bleue, true);
		g2d.setPaint(gp52);
		g2d.fillRect(326, 272, 40, 40);
		GradientPaint gp53 = new  GradientPaint(0,0, bleue, 101, 10, bleue, true);
		g2d.setPaint(gp53);
		g2d.fillRect(506, 272, 40, 40);
		GradientPaint gp54 = new  GradientPaint(101,47, bleue, 0, 0, bleue, true);
		g2d.setPaint(gp54);
		g2d.fillRect(686, 272, 40, 40);
		
		///// 7e rang /////
		GradientPaint gp61 = new  GradientPaint(0,0, cyan, 101, 10, cyan, true);
		g2d.setPaint(gp61);
		g2d.fillRect(191, 317, 40, 40); //x, y, xplus, yplus
		GradientPaint gp62 = new  GradientPaint(101,47, cyan, 0, 0, cyan, true);
		g2d.setPaint(gp62);
		g2d.fillRect(371, 317, 40, 40);
		GradientPaint gp63 = new  GradientPaint(0,0, cyan, 101, 10, cyan, true);
		g2d.setPaint(gp63);
		g2d.fillRect(461, 317, 40, 40);
		GradientPaint gp64 = new  GradientPaint(101,47, cyan, 0, 0, cyan, true);
		g2d.setPaint(gp64);
		g2d.fillRect(641, 317, 40, 40);
		
		///// 8e rang /////
		
		g2d.setPaint(gp);
		g2d.fillRect(101, 362, 40, 40); 
		
		g2d.setPaint(gp2);
		g2d.fillRect(236, 362, 40, 40);
		GradientPaint gpX = new  GradientPaint(0,0,orange, 101, 10, Color.ORANGE, true);
		g2d.setPaint(gpX);
		g2d.fillRect(416, 362, 40, 40);
		
		g2d.setPaint(gp4);
		g2d.fillRect(596, 362, 40, 40);
		
		g2d.setPaint(gp5);
		g2d.fillRect(731, 362, 40, 40);
		
		///// 9e rang /////
		
		g2d.setPaint(gp61);
		g2d.fillRect(191, 407, 40, 40); 
		
		g2d.setPaint(gp62);
		g2d.fillRect(371, 407, 40, 40);
		
		g2d.setPaint(gp63);
		g2d.fillRect(461, 407, 40, 40);
		
		g2d.setPaint(gp64);
		g2d.fillRect(641, 407, 40, 40);
		
		///// 10e rang /////
		g2d.setPaint(gp51);
		g2d.fillRect(146, 452, 40, 40); 
		
		g2d.setPaint(gp52);
		g2d.fillRect(326, 452, 40, 40);
		
		g2d.setPaint(gp53);
		g2d.fillRect(506, 452, 40, 40);

		g2d.setPaint(gp54);
		g2d.fillRect(686, 452, 40, 40);
		
		///// 11e rang /////
		
		g2d.setPaint(gp40);
		g2d.fillRect(281, 497, 40, 40);
		
		g2d.setPaint(gp40);
		g2d.fillRect(551, 497, 40, 40);
		
		///// 12e rang /////
		
		g2d.setPaint(gp31);
		g2d.fillRect(101, 542, 40, 40); 
		
		g2d.setPaint(gp32);
		g2d.fillRect(236, 542, 40, 40);
		
		g2d.setPaint(gp33);
		g2d.fillRect(416, 542, 40, 40);
		
		g2d.setPaint(gp34);
		g2d.fillRect(596, 542, 40, 40);
		
		g2d.setPaint(gp35);
		g2d.fillRect(731, 542, 40, 40);
		
		///// 13e rang /////
		
		g2d.setPaint(gp21);
		g2d.fillRect(191, 587, 40, 40); 
		
		g2d.setPaint(gp22);
		g2d.fillRect(371, 587, 40, 40);
		
		g2d.setPaint(gp23);
		g2d.fillRect(461, 587, 40, 40);
		
		g2d.setPaint(gp24);
		g2d.fillRect(641, 587, 40, 40);
		
		///// 14e rang /////
		
		g2d.setPaint(gp11);
		g2d.fillRect(146, 632, 40, 40); 
		
		g2d.setPaint(gp12);
		g2d.fillRect(326, 632, 40, 40);
		
		g2d.setPaint(gp13);
		g2d.fillRect(506, 632, 40, 40);
		
		g2d.setPaint(gp14);
		g2d.fillRect(686, 632, 40, 40);
		
		////// 15e rang /////
		
		g2d.setPaint(gp);
		
		g2d.fillRect(101, 677, 40, 40); 
		
		
		g2d.setPaint(gp2);
		g2d.fillRect(236, 677, 40, 40);
		
		
		g2d.setPaint(gp3);
		g2d.fillRect(416, 677, 40, 40);
		
		g2d.setPaint(gp4);
		g2d.fillRect(596, 677, 40, 40);
		
		g2d.setPaint(gp5);
		g2d.fillRect(731, 677, 40, 40);
		
		
		
		////////////// COULEUR
		g.setColor(Color.white);
		
		//légende
		//g.drawString("L pour lettre", 101, 33);
		
		////// case rouge //////
		g.drawString("MT*3", 106, 73);
		g.drawString("MT*3", 736, 73);
		g.drawString("MT*3", 421, 73);
		
		g.drawString("MT*3", 106, 390);
		g.drawString("MT*3", 736, 390);
		
		g.drawString("MT*3", 106, 703);
		g.drawString("MT*3", 421, 703);
		g.drawString("MT*3", 736, 703);
		
		////// case cyan //////
		g.drawString("LD*2", 246, 73);
		g.drawString("LD*2", 606, 73);
		
		g.drawString("LD*2", 381, 163);
		g.drawString("LD*2", 471, 163);
		
		g.drawString("LD*2", 111, 208);
		g.drawString("LD*2", 741, 208);
		g.drawString("LD*2", 426, 208);
		
		g.drawString("LD*2", 201, 345);
		g.drawString("LD*2", 381, 345);
		g.drawString("LD*2", 471, 345);
		g.drawString("LD*2", 651, 345);
		
		g.drawString("LD*2", 246, 390);
		g.drawString("LD*2", 606, 390);
		
		g.drawString("LD*2", 201, 435);
		g.drawString("LD*2", 381, 435);
		g.drawString("LD*2", 471, 435);
		g.drawString("LD*2", 651, 435);
		
		g.drawString("LD*2", 111, 568);
		g.drawString("LD*2", 741, 568);
		g.drawString("LD*2", 426, 568);
		
		g.drawString("LD*2", 381, 613);
		g.drawString("LD*2", 471, 613);
		
		g.drawString("LD*2", 246, 703);
		g.drawString("LD*2", 606, 703);
		
		////// case ORANGE ///////
		g.drawString("MD*2", 151, 118);
		g.drawString("MD*2", 691, 118);
		
		g.drawString("MD*2", 196, 163);
		g.drawString("MD*2", 646, 163);
		
		g.drawString("MD*2", 241, 208);
		g.drawString("MD*2", 601, 208);
		
		g.drawString("MD*2", 286, 253);
		g.drawString("MD*2", 556, 253);
		//
		g.drawString("MD*2", 286, 523);
		g.drawString("MD*2", 556, 523);
		
		g.drawString("MD*2", 241, 568);
		g.drawString("MD*2", 601, 568);
		
		g.drawString("MD*2", 196, 613);
		g.drawString("MD*2", 646, 613);
		
		g.drawString("MD*2", 151, 658);
		g.drawString("MD*2", 691, 658);
		
		////// case bleu ///////
		g.drawString("LT*3", 336, 118);
		g.drawString("LT*3", 516, 118);
		
		g.drawString("LT*3", 156, 300);
		g.drawString("LT*3", 336, 300);
		g.drawString("LT*3", 516, 300);
		g.drawString("LT*3", 696, 300);
		
		g.drawString("LT*3", 156, 480);
		g.drawString("LT*3", 336, 480);
		g.drawString("LT*3", 516, 480);
		g.drawString("LT*3", 696, 480);
		
		g.drawString("LT*3", 336, 658);
		g.drawString("LT*3", 516, 658);
		
		
		/*//15 premières cases
	    g.drawRect(10, 10, 50, 50);
	    g.drawRect(60, 10, 50, 50);
	    g.drawRect(110, 10, 50, 50);
	    g.drawRect(160, 10, 50, 50);
	    g.drawRect(210, 10, 50, 50);
	    g.drawRect(260, 10, 50, 50);
	    g.drawRect(310, 10, 50, 50);
	    g.drawRect(360, 10, 50, 50);
	    g.drawRect(410, 10, 50, 50);
	    g.drawRect(460, 10, 50, 50);
	    g.drawRect(510, 10, 50, 50);
	    g.drawRect(560, 10, 50, 50);
	    g.drawRect(610, 10, 50, 50);
	    g.drawRect(660, 10, 50, 50);
	    g.drawRect(710, 10, 50, 50);
	    */
	  } 

}
