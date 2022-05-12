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
	  public static final Literal at6 = Literal.parseLiteral("at(robot1,table6)");
	  
	  public static final Literal am2 = Literal.parseLiteral("at(robot2,manager)");
	  public static final Literal at12 = Literal.parseLiteral("at(robot2,table1)");
	  public static final Literal at22= Literal.parseLiteral("at(robot2,table2)");
	  public static final Literal at32 = Literal.parseLiteral("at(robot2,table3)");
	  public static final Literal at42 = Literal.parseLiteral("at(robot2,table4)");
	  public static final Literal at52 = Literal.parseLiteral("at(robot2,table5)");
	  public static final Literal at62 = Literal.parseLiteral("at(robot2,table6)");
	  
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
        Location lRobot1 = model.getAgPos(0);
		Location lRobot2 = model.getAgPos(1);
		
		 // add agent location to its percepts
       
		if (lRobot1.equals(model.lManager)) {
            addPercept("robot1", am);
        }
		 if (lRobot1.equals(model.lTable1)) {
            addPercept("robot1", at1);
        }
		 if (lRobot1.equals(model.lTable2)) {
            addPercept("robot1", at2);
        }
		 if (lRobot1.equals(model.lTable3)) {
            addPercept("robot1", at3);
        }
		 if (lRobot1.equals(model.lTable4)) {
            addPercept("robot1", at4);
        }
		 if (lRobot1.equals(model.lTable5)) {
            addPercept("robot1", at5);
        }
		 if (lRobot1.equals(model.lTable6)) {
            addPercept("robot1", at6);
        }
		
		if (lRobot2.equals(model.lManager)) {
            addPercept("robot2", am2);
        }
		 if (lRobot2.equals(model.lTable1)) {
            addPercept("robot2", at12);
        }
		 if (lRobot2.equals(model.lTable2)) {
            addPercept("robot2", at22);
        }
		 if (lRobot2.equals(model.lTable3)) {
            addPercept("robot2", at32);
        }
		 if (lRobot2.equals(model.lTable4)) {
            addPercept("robot2", at42);
        }
		 if (lRobot2.equals(model.lTable5)) {
            addPercept("robot2", at52);
        }
		 if (lRobot2.equals(model.lTable6)) {
            addPercept("robot2", at62);
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
			if(l.equals("table1")){
				dest=model.lTable1;
			}
			else if (l.equals("manager")){
				dest=model.lManager;
			}
			else if (l.equals("robot1")){
				dest=model.lRobot1;
			}
			else if (l.equals("robot2")){
				dest=model.lRobot2;
			}
			else if (l.equals("table2")){
				dest=model.lTable2;
			}
			else if (l.equals("table3")){
				dest=model.lTable3;
			}
			else if (l.equals("table4")){
				dest=model.lTable4;
			}
			else if (l.equals("table5")){
				dest=model.lTable5;
			}
			else if (l.equals("table6")){
				dest=model.lTable6;
			}
			try{
				result=model.moveTowards(dest,nRobot);
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



