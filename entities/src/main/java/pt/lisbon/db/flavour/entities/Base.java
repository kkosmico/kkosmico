package pt.lisbon.db.flavour.entities;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import org.hibernate.annotations.Type;

/**
 * Created by José Carlos Campos Sousa on 11/03/2017.
 */
@MappedSuperclass
public abstract class Base implements Serializable {

    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(length = 16)
    private UUID id = UUID.randomUUID();

    protected Base(){}

    protected String getInternalBusinessKey() throws NullPointerException{
        return id.toString();
    }
}
