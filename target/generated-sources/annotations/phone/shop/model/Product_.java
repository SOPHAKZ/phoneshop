package phone.shop.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile SingularAttribute<Product, Color> color;
	public static volatile SingularAttribute<Product, BigDecimal> salePrice;
	public static volatile SingularAttribute<Product, String> imagePath;
	public static volatile SingularAttribute<Product, String> name;
	public static volatile SingularAttribute<Product, Integer> availableUnit;
	public static volatile SingularAttribute<Product, Model> model;
	public static volatile SingularAttribute<Product, Long> id;

	public static final String COLOR = "color";
	public static final String SALE_PRICE = "salePrice";
	public static final String IMAGE_PATH = "imagePath";
	public static final String NAME = "name";
	public static final String AVAILABLE_UNIT = "availableUnit";
	public static final String MODEL = "model";
	public static final String ID = "id";

}

