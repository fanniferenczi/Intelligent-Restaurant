// Environment code for project intelligentRestaurant.mas2j
import jason.asSyntax.*;
import jason.environment.*;
import jason.asSyntax.parser.*;
import java.util.logging.*;
import jason.environment.grid.Location;


public class RestaurantEnv extends Environment {


    public static final Literal of  = Literal.parseLiteral("open(fridge)");

    private Logger logger = Logger.getLogger("intelligentRestaurant.mas2j."+RestaurantEnv.class.getName());

    RestaurantModel model;

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
        clearPercepts("robot");
        Location lRobot = model.getAgPos(0);
    }

    @Override
    public boolean executeAction(String agName, Structure action) {
        logger.info("executing: "+action+", but not implemented!");
        if (true) { // you may improve this condition
            informAgsEnvironmentChanged();
        }
        return true; // the action was executed with success

    }



    /** Called before the end of MAS execution

    @Override
    public void stop() {
        super.stop();
    }  */

}



