import jason.environment.grid.GridWorldModel;
import jason.environment.grid.Location;

public class RestaurantModel extends GridWorldModel{
    public static final int TABLE1=8;
    public static final int TABLE2=16;
	public static final int TABLE3=32;
	public static final int TABLE4=64;
	public static final int TABLE5=128;
	public static final int TABLE6=256;
	
    public static final int GSizeX=10;
    public static final int GSizeY=7;

    Location lTable1=new Location(6,0);
    Location lTable2=new Location(2,1);
	Location lTable3=new Location(0,3);
	Location lTable4=new Location(2,5);
	Location lTable5=new Location(6,6);
	Location lTable6=new Location(5,3);

    public RestaurantModel(){
        super(GSizeX,GSizeY,3);
        setAgPos(0, 3, 4);
		setAgPos(1, 6, 2);
		setAgPos(2, 9, 3);
        add(TABLE1,lTable1);
        add(TABLE2,lTable2);
		add(TABLE3,lTable3);
		add(TABLE4,lTable4);
		add(TABLE5,lTable5);
		add(TABLE6,lTable6);
    }



}
