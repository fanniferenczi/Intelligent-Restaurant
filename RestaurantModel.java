import jason.environment.grid.GridWorldModel;
import jason.environment.grid.Location;

public class RestaurantModel extends GridWorldModel{
    public static final int TABLE1=8;
    public static final int TABLE2=16;
	public static final int TABLE3=32;
	public static final int TABLE4=64;
	public static final int TABLE5=128;
	public static final int TABLE6=256;
	public static final int MANAGER=512;
	
    public static final int GSizeX=10;
    public static final int GSizeY=7;

    Location lTable1=new Location(6,0);
    Location lTable2=new Location(2,1);
	Location lTable3=new Location(0,3);
	Location lTable4=new Location(2,5);
	Location lTable5=new Location(6,6);
	Location lTable6=new Location(5,3);
	Location lManager=new Location(9,3);
	Location lRobot1 = new Location(9,1);
	Location lRobot2 = new Location(9,5);
	
	boolean carryingOrder=false;
	boolean vertObstacle=false;
	int counter=1;

    public RestaurantModel(){
        super(GSizeX,GSizeY,3);
        setAgPos(0, lRobot1);
		setAgPos(1, lRobot2);
		setAgPos(2, lManager);
		/*setAgPos(3,lTable6);
		setAgPos(3, lTable3);
		setAgPos(4, lTable4);
		setAgPos(5, lTable5);
		setAgPos(6, lTable6);
		setAgPos(7, lRobot1);
		setAgPos(8, lRobot2);*/
        add(TABLE1,lTable1);
        add(TABLE2,lTable2);
		add(TABLE3,lTable3);
		add(TABLE4,lTable4);
		add(TABLE5,lTable5);
		add(TABLE6,lTable6);
		add(MANAGER,lManager);
    }
	
	boolean moveTowards(Location dest, int rNumber){
		
		Location r=getAgPos(rNumber); //rNumber a robotot azonosítja, annak kell az aktuális pozíciója
		
		if(r.x<dest.x && vertObstacle==false){
			if(isFree(r.x+1,r.y)){
				r.x++;
			}
			else{ //ha akadály van, kerülünk, egyszer y+ irányba, egyszer y- irányba (mert be tud akadni, ha nem fordul néha vissza)
				if(counter%2==0){
					counter++;
					if(isFree(r.x,r.y+1)){
						r.y++;
					}
					
				}
				else{
					counter++;
					if(isFree(r.x,r.y-1)){
						r.y--;
					}
				
				}
			}
		}
		else if(r.x>dest.x && vertObstacle==false){
			if(isFree(r.x-1,r.y)){
				r.x--;
			}
			else{
				if(counter%2==0){
					counter++;
					if(isFree(r.x,r.y+1)){
						r.y++;
					}
				}
				else{
					counter++;
					if(isFree(r.x,r.y-1)){
						r.y--;
					}
					
				}
			}
		}
		
			else if(r.y>dest.y){
				if(isFree(r.x,r.y-1)){
					r.y--;
					vertObstacle=false;
				}
				else{
					vertObstacle=true;
					if(isFree(r.x+1,r.y)){
						r.x++;
					}
					else{
						if(isFree(r.x-1,r.y)){
							r.x--;
						}
					}
				}
			}
			else if (r.y<dest.y){
				if(isFree(r.x,r.y+1)){
					vertObstacle=false;
					r.y++;
				}
				else{
					vertObstacle=true;
					if(counter%2==0){
						if(isFree(r.x+1,r.y)){
							r.x++;
						}
						counter++;
					}
					else {
						if(isFree(r.x-1,r.y)){
							r.x--;
					}
					counter++;
					}
				}
			}
		
		
		
		setAgPos(rNumber,r); //move the robot in the grid
		
		if(view!=null){
			view.update(lManager.x,lManager.y);
		}
		
		
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


}
