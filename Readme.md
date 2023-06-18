# API 문서

## GET /api/v1/areas/main

이 API는 지역의 대분류 정보를 리스트 형식으로 제공합니다.

### 요청 방식

- GET

### URL

- /api/v1/areas/main

### 응답 예시

```json
{
    "result": {
        "status": "success"
    },
    "body": {
        "totalCount": 17,
        "depth": 1,
        "items": [
            {
                "code": "1100000000",
                "name": "서울특별시"
            },
            // 생략
        ]
    }
}
```

- "status": 요청 처리 결과 상태입니다. 성공한 경우 "success"를 반환합니다.
- "totalCount": 반환된 지역의 수입니다.
- "depth": 지역의 계층을 나타냅니다. 1은 대분류, 2는 중분류, 3은 소분류를 의미합니다.
- "items": 지역 정보 리스트입니다. 각 항목은 지역 코드("code")와 지역 이름("name")을 포함합니다.
---
## GET /api/v1/areas/sub/{parentCode}

이 API 엔드포인트는 중분류 및 소분류에 대한 결과값을 반환합니다.

### 요청 방식

- GET

### URL

- /api/v1/areas/sub/{parentCode}

### Path 변수

- {parentCode}: 상위 코드를 나타내는 변수입니다.

### 응답 예시

```json
{
    "result": {
        "status": "success"
    },
    "body": {
        "totalCount": 11,
        "depth": 2,
        "items": [
            {
                "code": "4311000000",
                "name": "충청북도 청주시"
            },
            {
                "code": "4313000000",
                "name": "충청북도 충주시"
            },
            // 생략
        ]
    }
}
```
- "status": 요청 처리 결과 상태입니다. 성공한 경우 "success"를 반환합니다.
- "totalCount": 반환된 지역의 수입니다.
- "depth": 지역의 계층을 나타냅니다. 2는 중분류, 3은 소분류를 의미합니다.
- "items": 지역 정보 리스트입니다. 각 항목은 지역 코드("code")와 지역 이름("name")을 포함합니다.
---
## GET /api/v1/areas/detail/{code}

이 API는 지역 코드에 해당하는 상세 정보를 반환합니다.

### 요청 방식

- GET

### URL

- /api/v1/areas/detail/{code}

### Path 변수

- {code}: 조회할 지역 코드를 나타내는 경로 변수입니다.

### 응답 예시

```json
{
    "result": {
        "status": "success"
    },
    "body": {
        "code": "1111000000",
        "parent": "1100000000",
        "name": "서울특별시 종로구",
        "depth": 2,
        "createdAt": "2023-06-19T03:16:20.399511",
        "modifiedAt": "2023-06-19T03:16:20.399511"
    }
}
```

- "status": 요청 처리 결과 상태입니다. 성공한 경우 "success"를 반환합니다.
- "code": 조회된 지역의 코드입니다.
- "parent": 조회된 지역의 상위 지역 코드입니다. 부모가 없는 경우에는 `null`로 반환됩니다.
- "name": 조회된 지역의 이름입니다.
- "depth": 조회된 지역의 계층을 나타냅니다.
- "createdAt": 지역 정보가 생성된 일시입니다.
- "modifiedAt": 지역 정보가 수정된 일시입니다.
---
## GET /api/v1/city/reconstructions/{code}

이 API는 지역 코드에 해당하는 정비사업 정보를 반환합니다.

### 요청 방식

- GET

### URL

- /api/v1/city/reconstructions/{code}

### Path 변수

- {code}: 조회할 지역 코드를 나타내는 경로 변수입니다.

### 응답 예시

```json
{
    "result": {
        "status": "success"
    },
    "body": {
        "code": "1111000000",
        "name": "서울특별시 종로구",
        "total": 13,
        "items": [
            {
                "count": 1,
                "businessName": "재건축"
            },
            {
                "count": 3,
                "businessName": "재개발(주택정비형)"
            },
            {
                "count": 8,
                "businessName": "재개발(도시정비형)"
            },
            {
                "count": 1,
                "businessName": "가로주택정비"
            }
        ]
    }
}
```

- "status": 요청 처리 결과 상태입니다. 성공한 경우 "success"를 반환합니다.
- "code": 조회된 지역의 코드입니다.
- "name": 조회된 지역의 이름입니다.
- "total": 조회된 정비사업의 총 개수입니다.
- "items": 정비사업 정보 리스트입니다. 각 항목은 "count"와 "businessName"으로 구성되어 있습니다.
    - "count": 해당 정비사업의 개수입니다.
    - "businessName": 정비사업의 이름입니다.