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
        switch(object){
            case RestaurantModel.TABLE1DOCK:
				super.drawObstacle(g,x,y);
                break;
            case RestaurantModel.TABLE2DOCK:
				super.drawObstacle(g,x,y);
                break;
			case RestaurantModel.TABLE3DOCK:
				super.drawObstacle(g,x,y);
                break;
			case RestaurantModel.TABLE4DOCK:
				super.drawObstacle(g,x,y);
                break;
			case RestaurantModel.TABLE5DOCK:
				super.drawObstacle(g,x,y);
                break;
			case RestaurantModel.MANAGERDOCK:
				super.drawObstacle(g,x,y);
                break;
        }
       // repaint();  ez okozta a villódzást
    }
    @Override
    public void drawAgent(Graphics g, int x, int y, Color c, int id){
		String label="label";
		c=Color.yellow;
		switch(id){
			case 0:
				label="Robot1";
				c=Color.yellow;
				break;
			case 1:
				label="Robot2";
				c=Color.yellow;
				break;
			case 2:
				label="Manager";
				c=Color.red;
				break;
			default:
				label="Table"+(id-2);
				c=Color.blue;
		}
        super.drawAgent(g,x,y,c,-1);
        g.setColor(Color.black);
        super.drawString(g, x, y, defaultFont, label);
    }
}
