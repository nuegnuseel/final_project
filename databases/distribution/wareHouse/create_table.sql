-- 웨어하우스 관련
-- 1. LOGISTICS_WAREHOUSE 테이블 생성

CREATE TABLE `LOGISTICS_WAREHOUSE`
(
    `LOGISTICS_WAREHOUSE_PK` VARCHAR(50) NOT NULL,
    `WAREHOUSE_NAME`         VARCHAR(50) NOT NULL,
    PRIMARY KEY (`LOGISTICS_WAREHOUSE_PK`)
);


-- 2. LOGISTICS_WAREHOUSE_SOURCE 테이블 생성
CREATE TABLE `LOGISTICS_WAREHOUSE_STACK`
(
    `LOGISTICS_WAREHOUSE_STACK_PK` VARCHAR(50) NOT NULL,
    `SOURCE_FK`                     VARCHAR(50) NOT NULL,
    `LOGISTICS_WAREHOUSE_FK`        VARCHAR(50) NOT NULL,
    `QUANTITY`                      INT NULL,
    PRIMARY KEY (`LOGISTICS_WAREHOUSE_STACK_PK`),
    FOREIGN KEY (`SOURCE_FK`) REFERENCES `SOURCE` (`SOURCE_ID`),
    FOREIGN KEY (`LOGISTICS_WAREHOUSE_FK`) REFERENCES `LOGISTICS_WAREHOUSE` (`LOGISTICS_WAREHOUSE_PK`)
);