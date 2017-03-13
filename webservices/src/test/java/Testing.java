import org.junit.Test;
import pt.lisbon.db.flavour.dtos.DishesDTO;
import pt.lisbon.db.flavour.enums.DishesType;
import pt.lisbon.flavour.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by José Carlos Campos Sousa on 11/03/2017.
 */
public class Testing {

    @Test
    public void testSend(){
        Controller controller = new Controller();
        List<DishesType> types = new ArrayList<DishesType>();
        types.add(DishesType.MEAT);
        types.add(DishesType.FISH);

        List<DishesDTO> dishes = controller.getDishesByTypes(types);
    }
}
