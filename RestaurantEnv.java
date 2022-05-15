// Environment code for project intelligentRestaurant.mas2j
import jason.asSyntax.*;
import jason.environment.*;
import jason.asSyntax.parser.*;
import java.util.logging.*;
import jason.environment.grid.Location;


public class RestaurantEnv extends Environment {


	 
	  public static final Literal am = Literal.parseLiteral("at(robot1,manager)");
	  public static final Literal at1 = Literal.parseLiteral("at(robot1,table1)");
	  public static final Literal at2 = Literal.parseLiteral("at(robot1,table2)");
	  public static final Literal at3 = Literal.parseLiteral("at(robot1,table3)");
	  public static final Literal at4 = Literal.parseLiteral("at(robot1,table4)");
	  public static final Literal at5 = Literal.parseLiteral("at(robot1,table5)");
	  public static final Literal ah1 = Literal.parseLiteral("at(robot1,home1)");
	 
	  
	  
	  public static final Literal am2 = Literal.parseLiteral("at(robot2,manager)");
	  public static final Literal at12 = Literal.parseLiteral("at(robot2,table1)");
	  public static final Literal at22= Literal.parseLiteral("at(robot2,table2)");
	  public static final Literal at32 = Literal.parseLiteral("at(robot2,table3)");
	  public static final Literal at42 = Literal.parseLiteral("at(robot2,table4)");
	  public static final Literal at52 = Literal.parseLiteral("at(robot2,table5)");
	  public static final Literal ah2 = Literal.parseLiteral("at(robot2,home2)");
	  
	  public static final Literal go=Literal.parseLiteral("get(order)");
	  public static final Literal ho=Literal.parseLiteral("hand_in(order)");
	
	private Logger logger = Logger.getLogger("intelligentRestaurant.mas2j."+RestaurantEnv.class.getName());

    RestaurantModel model;  //model of the grid

    @Override
    public void init(String[] args) {
        model = new RestaurantModel();

        if (args.length == 1 && args[0].equals("gui")) {
            RestaurantView view  = new RestaurantView(model);
            model.setView(view);
        }
        updatePercepts();
    }

    void updatePercepts(){
        clearPercepts("robot1");
		clearPercepts("robot2");
		clearPercepts("manager");
		
		// get the robot location
        Location robot1 = model.getAgPos(0);
		Location robot2 = model.getAgPos(1);
		
		 // add agent location to its percepts
       
		if (robot1.equals(model.lManagerDock)) {
            addPercept("robot1", am);
        }
		 if (robot1.equals(model.lTable1Dock)) {
            addPercept("robot1", at1);
        }
		 if (robot1.equals(model.lTable2Dock)) {
            addPercept("robot1", at2);
        }
		 if (robot1.equals(model.lTable3Dock)) {
            addPercept("robot1", at3);
        }
		 if (robot1.equals(model.lTable4Dock)) {
            addPercept("robot1", at4);
        }
		 if (robot1.equals(model.lTable5Dock)) {
            addPercept("robot1", at5);
        }
		 if (robot1.equals(model.lRobot1Home)) {
            addPercept("robot1", ah1);
			model.busy1=false;
			
        }
		
		
		
		
		if (robot2.equals(model.lManagerDock)) {
            addPercept("robot2", am2);
        }
		 if (robot2.equals(model.lTable1Dock)) {
            addPercept("robot2", at12);
        }
		 if (robot2.equals(model.lTable2Dock)) {
            addPercept("robot2", at22);
        }
		 if (robot2.equals(model.lTable3Dock)) {
            addPercept("robot2", at32);
        }
		 if (robot2.equals(model.lTable4Dock)) {
            addPercept("robot2", at42);
        }
		 if (robot2.equals(model.lTable5Dock)) {
            addPercept("robot2", at52);
        }
		if (robot2.equals(model.lRobot2Home)) {
            addPercept("robot2", ah2);
			model.busy2=false;
        }
		
		
		 
		
		
		
    }

    @Override
    public boolean executeAction(String agName, Structure action) {
        logger.info("executing: "+action);
        boolean result=false;
		if(action.getFunctor().equals("move_towards")){
			String l = action.getTerm(0).toString();
			String robot=action.getTerm(1).toString();
			int nRobot=Integer.parseInt(robot);
            Location dest = null;
			Location test=new Location(4,5);
			
			if (l.equals("manager")){
				dest=model.lManagerDock;
			}
			else if(l.equals("table1")){
				dest=model.lTable1Dock;
			}		
			else if (l.equals("table2")){
				dest=model.lTable2Dock;
			}
			else if (l.equals("table3")){
				dest=model.lTable3;
			}
			else if (l.equals("table4")){
				dest=model.lTable4Dock;
			}
			else if (l.equals("table5")){
				dest=model.lTable5;
			}
			else if (l.equals("home1")){
				dest=model.lRobot1Home;
			}
			else if (l.equals("home2")){
				dest=model.lRobot2Home;
			}
			
			
			
			
			try{
				result=model.moveTowards(dest,nRobot);
			} catch (Exception e){
				e.printStackTrace();
			}
			
		}
		else if(action.getFunctor().equals("get_busy")){
			String s = action.getTerm(0).toString();
			int id = Integer.parseInt(s);
			try{
				result=model.getBusy(id);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		
		else if(action.equals(go)){
			result=model.getOrder();
		}
		else if(action.equals(ho)){
			result=model.handInOrder();
		}
		
		   if (result) {
            updatePercepts();
            try {
                Thread.sleep(100);
            } catch (Exception e) {}
        }
		
		
		return result;

    }



    /** Called before the end of MAS execution

    @Override
    public void stop() {
        super.stop();
    }  */

}



