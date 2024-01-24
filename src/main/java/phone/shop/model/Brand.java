package phone.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "brands")
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
    @Id
    @GeneratedValue(generator = "brand_seq")
    @SequenceGenerator(name = "brand_seq", initialValue = 1,sequenceName = "brand_seq")
    private Integer id;

    @Column(name = "brand_name")
    private String name;



}
