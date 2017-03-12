import pt.lisbon.db.flavour.dao.DishesDAO;
import pt.lisbon.db.flavour.dtos.DishesDTO;
import pt.lisbon.db.flavour.entities.Dishes;
import pt.lisbon.db.flavour.enums.DishesType;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by José Carlos Campos Sousa on 11/03/2017.
 */
public class Testing {

    private DishesDAO dao = new DishesDAO();

    public void testingDishesBD(){
        List<DishesType> types = new ArrayList<DishesType>();
        types.add(DishesType.FISH);
        types.add(DishesType.MEAT);
        List<Dishes> dishes = dao.getDishes(types);

        if(dishes != null){
            for(Dishes d : dishes){
                System.out.println(d);
            }
        }
    }

    public void testingDishesBD2(){
        List<DishesType> types = new ArrayList<DishesType>();
        types.add(DishesType.FISH);
        types.add(DishesType.MEAT);
        List<DishesDTO> dishes = dao.getDishesDTO(types);

        if(dishes != null){
            for(DishesDTO d : dishes){
                System.out.println(d);
            }
        }
    }

    @Test
    public void testingInsert(){
        testingDishesBD();

        DishesDTO dto = new DishesDTO("Bacalhau à bras", null, DishesType.FISH, 13.3f);

        //System.out.println(dao.insertDishes(dto));

        testingDishesBD2();
    }
}
