package phone.shop.util;

import org.apache.commons.collections4.MapUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface PageUtils {

    static int PAGE_SIZE_DEFAULT = 10;
    static int PAGE_NUMBER_DEFAULT = 1;
    static String PAGE_SIZE = "size";
    static String PAGE_NUMBER ="page";




    static Pageable getPageable(Map<String,String> params){
        int pageNumber = MapUtils.getInteger(params,PAGE_NUMBER,PAGE_NUMBER_DEFAULT);//params.get("_page");
        int pageSize = MapUtils.getInteger(params,PAGE_SIZE,PAGE_SIZE_DEFAULT);

        if(pageNumber < 0){
            pageNumber = PAGE_NUMBER_DEFAULT;
        }
        if(pageSize < 0){
            pageSize = PAGE_SIZE_DEFAULT;
        }

        Pageable pageable = PageRequest.of(pageNumber-1,pageSize);
        return pageable;
    }



//    static int PAGE_SIZE_DEFAULT = 10;
//    static int PAGE_NUMBER_DEFAULT = 1;
//    static String PAGE_SIZE = "_limit";
//    static String PAGE_NUMBER = "_page";
//
//    // java 8 can make default method body in interface
//    static Pageable getPageable(Map<String,String> params){
//        int pageSize = MapUtils.getInteger(params,PAGE_SIZE,PAGE_SIZE_DEFAULT); //params.get("_page");
//        int pageNumber = MapUtils.getInteger(params, PAGE_NUMBER,PAGE_NUMBER_DEFAULT);
//
//        if(pageNumber < 0 ){
//            pageNumber = PAGE_NUMBER_DEFAULT;
//        }
//        if(pageSize < 0){
//            pageSize = PAGE_SIZE_DEFAULT;
//        }
//        Pageable pageable = PageRequest.of(pageNumber - 1 ,pageSize);
//
//       return pageable;
//    }
}
