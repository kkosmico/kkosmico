package pt.lisbon.db.flavour.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pt.lisbon.db.Connection;
import pt.lisbon.db.flavour.dtos.DishesDTO;
import pt.lisbon.db.flavour.entities.Dishes;
import pt.lisbon.db.flavour.enums.DishesType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by José Carlos Campos Sousa on 10/03/2017.
 */
public class DishesDAO {

    private Logger LOG = Logger.getLogger(this.getClass());

    private Session session;

    public DishesDAO() {
        session = Connection.getConnection();
    }

    public List<Dishes> getDishes(List<DishesType> types){
        try{
            final String queryString =
                            "SELECT d " +
                            "  FROM Dishes d" +
                            " WHERE d.type IN (:types)";

            Query query = session.createQuery(queryString);
            query.setParameterList("types", types);

            return (List<Dishes>)query.list();

        }catch (Exception e){
            LOG.info(e.getMessage());
        }
        return null;
    }

    public boolean insertDishes(DishesDTO dto){

        Dishes dishes = new Dishes();
        dishes.setName(dto.getName());
        dishes.setDescription(dto.getDescription());
        dishes.setType(dto.getType());
        dishes.setPrice(dto.getPrice());

        Transaction transaction = session.beginTransaction();
        try{
            Serializable serializable = session.save(dishes);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            LOG.error(e.getMessage());
        }
        return false;
    }

    private static final String CONSTRUCTOR = "new pt.lisbon.db.flavour.dtos.DishesDTO(" +
            "d.name, " +
            "d.description, " +
            "d.type, " +
            "d.price" +
            ")";

    public List<DishesDTO> getDishesDTO(List<DishesType> types) {
        try{
            final String queryString =
                            "SELECT " + CONSTRUCTOR +
                            "  FROM Dishes d" +
                            " WHERE d.type IN (:types)";

            Query query = session.createQuery(queryString);
            query.setParameterList("types", types);

            return (List<DishesDTO>)query.list();

        }catch (Exception e){
            LOG.info(e.getMessage());
        }
        return null;
    }

    public List<DishesDTO> getDishesDTO(DishesType type) {

        List<DishesType> types = new ArrayList<DishesType>();
        types.add(type);

        return getDishesDTO(types);
    }
}
