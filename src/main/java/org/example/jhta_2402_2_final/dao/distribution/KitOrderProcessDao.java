package org.example.jhta_2402_2_final.dao.distribution;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.jhta_2402_2_final.model.dto.distribution.KitOrderProcessDto;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Mapper
public interface KitOrderProcessDao {

    List<Map<String, Object>> findAllOrder();

    int requestKitSourceOrder(KitOrderProcessDto kitOrderProcessDto); // 아직 미사용

    // 주문번호(id)를 파라미터로 해서 마이바티스 매핑 후 레시피 조회
    List<Map<String, Object>> findKitRecipe(@Param("kitOrderId") String kitOrderId);

    ///////////////////////////////////////////////////////////////////////////////////////////

    // MealKit ID와 주문수량으로 재료 및 창고 재고 정보 조회
    List<Map<String, Object>> findKitRecipeWithStock(@Param("mealkitId") String mealkitId, @Param("orderQuantity") int orderQuantity);

    // 주문번호(id)로 밀키트 ID 조회
    String findMealKitByKitOrderId(@Param("kitOrderId") String kitOrderId);

    // 주문번호(id)로 주문수량 조회
    int findOrderQuantityByKitOrderId(@Param("kitOrderId") String kitOrderId);

    // 창고 수량 차감
    void updateWarehouseStock(@Param("sourceId") String sourceId, @Param("quantityChange") int quantityChange);

    // 주문 상태 변경
    void updateOrderStatus(@Param("kitOrderId") String kitOrderId, @Param("status") int status);





    /*List<Map<String, Object>> findKitSource();*/
}
