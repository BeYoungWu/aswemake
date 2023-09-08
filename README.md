# aswemake
애즈위메이크 모험가 모집 과제

### 테스트코드
※ Junit Test를 실행하면 기본 데이터 적재됨
#### 1. 관리자 등록 테스트
    - 1개 관리자 등록
    - {password : 1234}
#### 1. 상품 등록 테스트
    - 2개 상품 등록
    - {productName : 애플워치, nowPrice : 2000}, {productName : 갤럭시워치, nowPrice : 2000}
#### 2. 상품 수정 테스트
    - 1개 상품 가격 수정 테스트
    - {productName : 애플워치, nowPrice : 3000}
#### 3. 특정 시점 가격 조회 테스트
    - 1개 상품 2023-09-08 조회
    - {productName : 애플워치, priceCreated : 2023-09-08}
#### 4. 상품 삭제 테스트
    - 1개 상품 삭제 테스트
    - {productName : 갤럭시워치}

### API 명세서
#### 1. 관리자 등록
    - (POST) /api/accounts/register
#### 1. 관리자 로그인
    - (POST) /api/accounts/login
#### 2. 상품 등록
    - (POST) /api/products/register
#### 3. 상품 수정
    - (PATCH) /api/products/modify
#### 4. 특정 시점 가격 조회
    - (POST) /api/products/get-prices
#### 5. 상품 삭제
    - (DELETE) /apli/products/remove

