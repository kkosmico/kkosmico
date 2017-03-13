package pt.lisbon.flavour;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pt.lisbon.db.flavour.dao.DishesDAO;
import pt.lisbon.db.flavour.dtos.DishesDTO;
import pt.lisbon.db.flavour.enums.DishesType;

import java.util.*;

/**
 * Created by José Carlos Campos Sousa on 11/03/2017.
 */
@RestController
public class Controller {

    private final Logger LOG = Logger.getLogger(getClass());

    @RequestMapping("/getDishesByTypes")
    public List<DishesDTO> getDishesByTypes(@RequestParam(value = "types") List<DishesType> types){

        LOG.info("Received [types:" + types + "]");

        DishesDAO dao = new DishesDAO();
        return dao.getDishesDTO(types);

    }


    @RequestMapping("/getDishesByType")
    public List<DishesDTO> getDishesByType(@RequestParam(value = "type") DishesType type){

        LOG.info("Received [type:" + type + "]");

        DishesDAO dao = new DishesDAO();
        return dao.getDishesDTO(type);

    }

    @RequestMapping("/getDishes")
    public List<DishesDTO> getDishes(){

        LOG.info("cheguei aqui 2");

        DishesDAO dao = new DishesDAO();
        List<DishesType> types = new ArrayList<DishesType>();
        types.add(DishesType.FISH);
        return dao.getDishesDTO(types);

    }
}
