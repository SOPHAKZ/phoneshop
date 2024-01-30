package phone.shop.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Model.class)
public abstract class Model_ {

	public static volatile SingularAttribute<Model, Integer> yearMade;
	public static volatile SingularAttribute<Model, String> name;
	public static volatile SingularAttribute<Model, Long> id;
	public static volatile SingularAttribute<Model, Brand> brand;

	public static final String YEAR_MADE = "yearMade";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String BRAND = "brand";

}

