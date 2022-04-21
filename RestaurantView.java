import jason.environment.grid.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class RestaurantView extends GridWorldView{
    RestaurantModel rmodel;

    public RestaurantView(RestaurantModel model){
        super(model,"Intelligen Restaurant",700);
        rmodel=model;
        defaultFont = new Font("Arial", Font.BOLD, 16);
        setVisible(true);
        repaint();
    }


    @Override
    public void draw(Graphics g, int x, int y, int object){
        super.drawAgent(g,x,y,Color.blue,-1); //itt lehetne ezt is haszn�lni: super.drawObstacle(g,x,y); <- sz�rke n�gyzet
												// nem tudom, hogy sz�m�t-e, hogy akad�lyk�nt �s nem agentk�nt van kirajzolva
        switch(object){
            case RestaurantModel.TABLE1:
                g.setColor(Color.black);
                drawString(g,x,y,defaultFont,"Table1");
                break;
            case RestaurantModel.TABLE2:
                g.setColor(Color.black);
                drawString(g,x,y,defaultFont,"Table2");
                break;
			case RestaurantModel.TABLE3:
                g.setColor(Color.black);
                drawString(g,x,y,defaultFont,"Table3");
                break;
			case RestaurantModel.TABLE4:
                g.setColor(Color.black);
                drawString(g,x,y,defaultFont,"Table4");
                break;
			case RestaurantModel.TABLE5:
                g.setColor(Color.black);
                drawString(g,x,y,defaultFont,"Table5");
                break;
			case RestaurantModel.TABLE6:
                g.setColor(Color.black);
                drawString(g,x,y,defaultFont,"Table6");
                break;
        }
        repaint();
    }
    @Override
    public void drawAgent(Graphics g, int x, int y, Color c, int id){
		String label="label";
		c= Color.yellow;
		if(id==2){
			label="Meneger";
			c=Color.red;
		}
		else{
			label="Robot"+(id+1);
		}
        super.drawAgent(g,x,y,c,-1);
        g.setColor(Color.black);
        super.drawString(g, x, y, defaultFont, label);
    }
}
