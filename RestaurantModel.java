import jason.environment.grid.GridWorldModel;
import jason.environment.grid.Location;
import jason.asSyntax.*;
import jason.environment.*;
import jason.asSyntax.parser.*;
import java.util.logging.*;
import jason.environment.grid.Location;

public class RestaurantModel extends GridWorldModel{
    public static final int TABLE1DOCK=8;
    public static final int TABLE2DOCK=16;
	public static final int TABLE3DOCK=32;
	public static final int TABLE4DOCK=64;
	public static final int TABLE5DOCK=128;
	public static final int MANAGERDOCK=256;
	
	
	
    public static final int GSizeX=10;
    public static final int GSizeY=7;

    Location lTable1=new Location(6,0);
    Location lTable2=new Location(2,1);
	Location lTable3=new Location(0,3);
	Location lTable4=new Location(2,5);
	Location lTable5=new Location(6,6);
	//Location lTable6=new Location(5,3);
	
	Location lManager=new Location(9,3);
	Location lRobot1 = new Location(8,1);
	Location lRobot2 = new Location(8,5);
	
	
	Location lTable1Dock=new Location(lTable1.x+1,lTable1.y);
	Location lTable2Dock=new Location(lTable2.x+1,lTable2.y);
	Location lTable3Dock=new Location(lTable3.x+1,lTable3.y);
	Location lTable4Dock=new Location(lTable4.x+1,lTable4.y);
	Location lTable5Dock=new Location(lTable5.x+1,lTable5.y);
	Location lManagerDock=new Location(lManager.x-1,lManager.y);
	Location lRobot1Home=new Location(8,1);
	Location lRobot2Home=new Location(8,5);
	
	
	
	
	boolean carryingOrder=false;
	boolean busy1=false;
	boolean busy2=false;
	
	private Logger logger = Logger.getLogger("intelligentRestaurant.mas2j."+RestaurantModel.class.getName());

    public RestaurantModel(){
        super(GSizeX,GSizeY,8);
        setAgPos(0, lRobot1);
		setAgPos(1, lRobot2);
		setAgPos(2, lManager);
		
		setAgPos(3,lTable1);
		setAgPos(4,lTable2);
		setAgPos(5, lTable3);
		setAgPos(6, lTable4);
		setAgPos(7, lTable5);
		
		
        add(TABLE1DOCK,lTable1Dock);
        add(TABLE2DOCK,lTable2Dock);
		add(TABLE3DOCK,lTable3Dock);
		add(TABLE4DOCK,lTable4Dock);
		add(TABLE5DOCK,lTable5Dock);
		add(MANAGERDOCK,lManagerDock);
	
		
		
    }
	
	boolean moveTowards(Location dest, int rId){
		
		Location r=getAgPos(rId); //rNumber a robotot azonosítja, annak kell az aktuális pozíciója
		
		
		int dist=r.distance(dest);
		logger.info("rNumber: "+rId+" distance: "+dist);
		
		if(rId==0){
			busy1=true;
		}
		else{
			busy2=true;
		}
		
		
		if (r.x < dest.x && isFree(r.x+1,r.y))   {
			r.x++;
		}
        else if (r.x > dest.x && isFree(r.x-1,r.y)){
			r.x--;
		}
        if (r.y < dest.y && isFree(r.x,r.y+1)){
			r.y++;
		}        
        else if (r.y > dest.y && isFree(r.x,r.y-1)) {
			r.y--;
		}
		
		logger.info("busy1: "+busy1);
		setAgPos(rId,r); //move the robot in the grid
		
		/*if(view!=null){
			view.update(lManager.x,lManager.y);
		}*/
		
		return true;
	}

	boolean getOrder(){  //egyelõre nem csinál sok mindent
		carryingOrder=true;
		return true;
	}
	boolean handInOrder(){  //szintén
		carryingOrder=false;
		return true;
	}
	boolean getBusy(int rId){
		if(rId==0){
			return busy1;
		}
		else{
			return busy2;
		}
		
	}


}
