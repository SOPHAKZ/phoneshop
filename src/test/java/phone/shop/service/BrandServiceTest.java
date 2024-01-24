package phone.shop.service;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import phone.shop.exception.ResourceNotFoundResponse;
import phone.shop.model.Brand;
import phone.shop.repository.BrandRepository;
import phone.shop.service.impl.BrandServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class BrandServiceTest {

    @Mock
    private BrandRepository brandRepo;

    private BrandService brandService;

    private Brand brand;

    @BeforeEach
    public void setUp(){
        brandService = new BrandServiceImpl(brandRepo);
        brand = new Brand(1,"Apple");

        // when save don't call So we need @ @MockitoSettings(strictness = Strictness.LENIENT)
        when(brandRepo.findById(1)).thenReturn(Optional.of(brand));
    }

    @Test
    public void saveBrand(){

        // given
//        Brand brand = new Brand();
//        brand.setName("Apple");

        Brand brand1 = brandService.save(brand);

        // then

        // to  check brand repo have call one time
        verify(brandRepo,times(1)).save(brand);
    }

    @Test
    public void getById(){
        brand = brandService.getById(1);

        // then

        assertNotNull(brand);

        assertEquals(1,brand.getId());
        assertEquals("Apple",brand.getName());
    }

    @Test
    public void getByIdError(){

        when(brandRepo.findById(2)).thenReturn(Optional.empty());

       // assertThrows(ResourceNotFoundResponse.class, () -> brandService.getById(2));
        assertThatThrownBy(()-> brandService.getById(2))
                .isInstanceOf(ResourceNotFoundResponse.class)
                .hasMessage("Brand not found for id=2");

    }

    @Test
    public void testUpdateBrand(){
        // given
        Brand brandUpdate = new Brand(1,"Apple V2");

        Brand after = brandService.update(1,brandUpdate);

        // then

        verify(brandRepo,times(1)).save(brandUpdate);

    }

    @Test
    public void testDeleteBrand(){
        Integer brandToDelete = 1;

        brandService.deleted(brandToDelete);

        verify(brandRepo,times(1)).delete(brand);
    }

    @Test
    public void testListBrand(){
        List<Brand> brands = List.of(
                new Brand(1,"Apple"),
                new Brand(2,"Samsung")
        );

        when(brandRepo.findAll()).thenReturn(brands);
         List<Brand> list = brandService.getBrands();

         assertEquals(2,list.size());
         assertEquals("Apple",list.get(0).getName());

    }
}
