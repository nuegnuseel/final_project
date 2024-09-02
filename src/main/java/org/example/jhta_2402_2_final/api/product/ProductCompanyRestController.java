package org.example.jhta_2402_2_final.api.product;

import lombok.RequiredArgsConstructor;
import org.example.jhta_2402_2_final.model.dto.CustomUserDetails;
import org.example.jhta_2402_2_final.service.product.ProductCompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/product/company")
public class ProductCompanyRestController {
    private final ProductCompanyService productCompanyService;

    // todo: 임시값 companyName = userDetails.getUsername() or userDetails.memberDto.getUserId() 로 받아올것
    private final String companyName = "농심공장";

    @GetMapping()
    public ResponseEntity<Map<String, Object>> getSourcesByCompanyName(@AuthenticationPrincipal CustomUserDetails userDetails){
        // String companyName = userDetails.getUsername(); 구현후에 이거 사용
        Map<String, Object> responseData  = productCompanyService.findAll(companyName);
        return ResponseEntity.ok().body(responseData);
    }

    @PostMapping("produce")
    public ResponseEntity<Map<String, Object>> produce(@AuthenticationPrincipal CustomUserDetails userDetails, @RequestBody Map<String ,Object> dataMap){
        // String companyName = userDetails.getUsername(); 구현후에 이거 사용
        return null;
    }

    @PostMapping("add")
    public ResponseEntity<Map<String, Object>> addSourceToCompany(@AuthenticationPrincipal CustomUserDetails userDetails, @RequestBody Map<String ,Object> dataMap){
        // jsonBody: { "sourceName": "버터", "sourcePrice": 5000 }
        // String companyName = userDetails.getUsername(); 구현후에 이거 사용
        Map<String, Object> responseData = productCompanyService.addSourceToCompany(companyName, dataMap);
        return ResponseEntity.ok().body(responseData);
    }

    @PutMapping()
    public ResponseEntity<Map<String, Object>> updateSource(@AuthenticationPrincipal CustomUserDetails userDetails, @RequestBody Map<String ,Object> dataMap){
        // String companyName = userDetails.getUsername(); 구현후에 이거 사용
        return null;
    }

    @DeleteMapping("{companySourceId}")
    public ResponseEntity<Map<String, Object>> deleteSourceFromCompany(@AuthenticationPrincipal CustomUserDetails userDetails, @PathVariable String companySourceId){
        Map<String, Object> responseData = productCompanyService.deleteSourceFromCompany(companyName, companySourceId);
        return ResponseEntity.ok().body(responseData);
    }



    // todo

    // 실제생산 리스트? 생산품중 생산중인 리스트 ?
    // 실제생산 수정
    // 실제생산 삭제?

    // 등록된 생산품 상세조회?  / 지금까지 생산한거 품목별로 리스트로 보여주기 ?
    // 등록된 생산품 수정 Put (일단 가격 ?)
    // 등록된 생산품 삭제 Delete

    // 차트에 입력할 값
}
