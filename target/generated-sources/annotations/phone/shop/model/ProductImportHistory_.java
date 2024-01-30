package phone.shop.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProductImportHistory.class)
public abstract class ProductImportHistory_ {

	public static volatile SingularAttribute<ProductImportHistory, LocalDate> dateImport;
	public static volatile SingularAttribute<ProductImportHistory, Product> product;
	public static volatile SingularAttribute<ProductImportHistory, Integer> importUnit;
	public static volatile SingularAttribute<ProductImportHistory, Long> id;
	public static volatile SingularAttribute<ProductImportHistory, BigDecimal> pricePerUnit;

	public static final String DATE_IMPORT = "dateImport";
	public static final String PRODUCT = "product";
	public static final String IMPORT_UNIT = "importUnit";
	public static final String ID = "id";
	public static final String PRICE_PER_UNIT = "pricePerUnit";

}

