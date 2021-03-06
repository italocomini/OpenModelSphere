***********************************************************
    Forward Engineering
    Plugin: ANSI DDL Generation Engine (3.2.0 - 05-12-2009), Grandite

    Database Name : "Database"
    Source file   : "/home/nmilosev/Downloads/oms/Open_ModelSphere_971N/examples/oracle/Oracle Project.sms"

    Generated on  : Oct 6, 2016 11:38:33 AM
    Generated by Open ModelSphere Version 3.2"
***********************************************************


***********************************************************
    CREATE STATEMENTS
***********************************************************


CREATE TABLE BUSINESS_TYPE 
(
    BT_CODE NUMBER NOT NULL,
    BT_NAME Name(100) NOT NULL
);


CREATE TABLE CLIENT 
(
    CLI_NUMBER NUMBER NOT NULL,
    CLI_NAME Name(100) NOT NULL,
    CLI_ADDRESS VARCHAR2-100(100) NULL,
    CLI_PHONE Phone(14) NULL,
    CLI_CIE_CODE NUMBER NULL,
    CLI_CLTY_CODE NUMBER NOT NULL
);


CREATE TABLE CLIENT_TYPE 
(
    CLTY_CODE NUMBER NOT NULL,
    CLTY_DESCRIPTION Description(2000) NULL
);


CREATE TABLE COMPANY 
(
    COMP_CODE NUMBER NOT NULL,
    COMP_NAME Name(100) NOT NULL,
    COMP_PHONE Phone(14) NULL,
    COMP_EMP_NBR NUMBER NOT NULL,
    COMP_ADDRESS VARCHAR2-100(100) NULL,
    COMP_FAX Phone(14) NULL,
    COMP_BUSINESS_CODE NUMBER NOT NULL
);


CREATE TABLE INVOICE 
(
    INVC_NUMBER NUMBER NOT NULL,
    INVC_DATE DATE NOT NULL,
    INVC_AMOUNT Amount(8,2) NOT NULL,
    INVC_CLI_NUMBER NUMBER NOT NULL
);


CREATE TABLE INVOICE_LINE 
(
    INVL_INVOICE_NUMBER NUMBER NOT NULL,
    INVL_NUMBER NUMBER NOT NULL,
    INVL_PROD_CODE NUMBER NOT NULL
);


CREATE TABLE ORDER_LINE 
(
    ORDL_CODE NUMBER NOT NULL,
    ORDL_PRODUCT_CODE NUMBER NOT NULL,
    ORDL_NUMBER NUMBER NOT NULL,
    ORDL_AMOUNT Amount(8,2) NOT NULL
);


CREATE TABLE ORDER1 
(
    ORD_CODE NUMBER NOT NULL,
    ORD_DATE DATE NOT NULL,
    ORD_SUB_TOTAL Total(10,2) NOT NULL,
    ORD_AMOUNT Amount(8,2) NOT NULL,
    ORD_CLIENT_NUMBER NUMBER NOT NULL
);


CREATE TABLE PAYMENT 
(
    PMT_INVOICE_NUMBER NUMBER NOT NULL,
    PMT_NUMBER NUMBER NOT NULL,
    PMT_AMOUNT Amount(8,2) NOT NULL
);


CREATE TABLE PAYMENT_SUMMARY 
(
    PMTS_INVOICE_NUMBER NUMBER NOT NULL,
    PMTS_PAYMENT_NUMBER NUMBER NOT NULL,
    PMTS_PAYMENT_AMOUNT Amount(8,2) NOT NULL,
    PMTS_INVOICE_DATE DATE NOT NULL,
    PMTS_INVOICE_AMOUNT Amount(8,2) NOT NULL
);


CREATE TABLE PRODUCT 
(
    PROD_CODE NUMBER NOT NULL,
    PROD_NAME Name(100) NOT NULL,
    PROD_PRICE Price(10,2) NOT NULL,
    PROD_STOCK Qte(6,1) NOT NULL,
    PROD_EOQ Qte(6,1) NOT NULL,
    PROD_IMAGE BLOB NULL
);


CREATE TABLE SUPPLIER 
(
    SUPL_NUMBER NUMBER NOT NULL,
    SUPL_NAME Name(100) NOT NULL,
    SUPL_ADDRESS VARCHAR2-100(100) NULL,
    SUPL_PHONE Phone(14) NULL
);


CREATE TABLE SUPPLIER_ORDER 
(
    SUPRD_SUPPLIER_NUMBER NUMBER NOT NULL,
    SUPRD_NUMBER NUMBER NOT NULL,
    SUPRD_AMOUNT Amount(8,2) NOT NULL
);


CREATE TABLE SUPPLIER_ORDER_LINE 
(
    SUPORL_SUPPLIER_ORDER_NUMBER NUMBER NOT NULL,
    SUPORL_SUPPLIER_NUMBER NUMBER NOT NULL,
    SUPORL_NUMBER NUMBER NOT NULL,
    SUPORL_AMOUNT Amount(8,2) NOT NULL,
    SUPORL_PRODUCT_CODE NUMBER NOT NULL
);


CREATE TABLE SUPPLIER_PRODUCT 
(
    SUPPRD_SUPPLIER_NUMBER NUMBER NOT NULL,
    SUPPRD_CODE NUMBER NOT NULL,
    SUPPRD_NAME Name(100) NOT NULL,
    SUPPRD_PRICE Price(10,2) NOT NULL,
    SUPPRD_PRODUCT_CODE NUMBER NOT NULL
);


CREATE UNIQUE INDEX BT_IDX_PK ON BUSINESS_TYPE
(
  BT_CODE ASC
);
CREATE INDEX CLI_IDX_CLIENT_COMPANY ON CLIENT
(
  CLI_CIE_CODE ASC
);
CREATE INDEX CLI_IDX_CLIENT_TYPE_CODE ON CLIENT
(
  CLI_CLTY_CODE ASC
);
CREATE UNIQUE INDEX CLI_IDX_PK_CLIENT_NUMBER ON CLIENT
(
  CLI_NUMBER ASC
);
CREATE UNIQUE INDEX CLI_IDX_UK1_CLIENT_NAME ON CLIENT
(
  CLI_NAME ASC
);
CREATE UNIQUE INDEX CLTY_IDX_CODE ON CLIENT_TYPE
(
  CLTY_CODE ASC
);
CREATE INDEX COMP_IDX_BUSINESS_TYPE ON COMPANY
(
  COMP_BUSINESS_CODE ASC
);
CREATE UNIQUE INDEX COMP_IDX_PK_COMP_CODE ON COMPANY
(
  COMP_CODE ASC
);
CREATE UNIQUE INDEX COMP_IDX_UK1 ON COMPANY
(
  COMP_NAME ASC,
  COMP_PHONE ASC
);
CREATE INDEX INVC_IDX_CLIENT_NUMBER ON INVOICE
(
  INVC_CLI_NUMBER ASC
);
CREATE UNIQUE INDEX INVC_IDX_INVOICE_NUMBER ON INVOICE
(
  INVC_NUMBER ASC
);
CREATE INDEX INVL_IDX_INVOICE_NUMBER ON INVOICE_LINE
(
  INVL_INVOICE_NUMBER ASC
);
CREATE UNIQUE INDEX INVL_IDX_PK ON INVOICE_LINE
(
  INVL_INVOICE_NUMBER ASC,
  INVL_NUMBER ASC
);
CREATE INDEX INVL_IDX_PRODUCT_CODE ON INVOICE_LINE
(
  INVL_PROD_CODE ASC
);
CREATE INDEX ORD_IDX_CLIENT_NUMBER ON ORDER1
(
  ORD_CLIENT_NUMBER ASC
);
CREATE UNIQUE INDEX ORD_IDX_ORDER_CODE ON ORDER1
(
  ORD_CODE ASC
);
CREATE INDEX ORDL_IDX_ORDER_CODE ON ORDER_LINE
(
  ORDL_CODE ASC
);
CREATE UNIQUE INDEX ORDL_IDX_PK ON ORDER_LINE
(
  ORDL_CODE ASC,
  ORDL_PRODUCT_CODE ASC,
  ORDL_NUMBER ASC
);
CREATE INDEX ORDL_IDX_PRODUCT_CODE ON ORDER_LINE
(
  ORDL_PRODUCT_CODE ASC
);
CREATE INDEX PMT_IDX_INVOICE_NUMBER ON PAYMENT
(
  PMT_INVOICE_NUMBER ASC
);
CREATE UNIQUE INDEX PMT_IDX_PK ON PAYMENT
(
  PMT_INVOICE_NUMBER ASC,
  PMT_NUMBER ASC
);
CREATE UNIQUE INDEX PMTS_INVOICE_NUMBER ON PAYMENT_SUMMARY
(
  PMTS_INVOICE_NUMBER ASC
);
CREATE UNIQUE INDEX PROD_IDX_PRODUCT_CODE ON PRODUCT
(
  PROD_CODE ASC
);
CREATE UNIQUE INDEX PROD_IDX_PRODUCT_NAME ON PRODUCT
(
  PROD_NAME ASC
);
CREATE UNIQUE INDEX SUPL_IDX_SUPPLIER_NAME ON SUPPLIER
(
  SUPL_NAME ASC
);
CREATE UNIQUE INDEX SUPL_IDX_SUPPLIER_NUMBER ON SUPPLIER
(
  SUPL_NUMBER ASC
);
CREATE INDEX SUPORL_IDX_PRODUCT_CODE ON SUPPLIER_ORDER_LINE
(
  SUPORL_PRODUCT_CODE ASC
);
CREATE INDEX SUPORL_IDX_SUPPLIER_ORDER ON SUPPLIER_ORDER_LINE
(
  SUPORL_SUPPLIER_ORDER_NUMBER ASC,
  SUPORL_SUPPLIER_NUMBER ASC
);
CREATE UNIQUE INDEX SUPORL_IDX1 ON SUPPLIER_ORDER_LINE
(
  SUPORL_SUPPLIER_ORDER_NUMBER ASC,
  SUPORL_SUPPLIER_NUMBER ASC,
  SUPORL_NUMBER ASC
);
CREATE INDEX SUPPRD_IDX_PRODUCT_CODE ON SUPPLIER_PRODUCT
(
  SUPPRD_PRODUCT_CODE ASC
);
CREATE INDEX SUPPRD_IDX_SUPPLIER_NUMBER ON SUPPLIER_PRODUCT
(
  SUPPRD_SUPPLIER_NUMBER ASC
);
CREATE UNIQUE INDEX SUPPRD_IDX1 ON SUPPLIER_PRODUCT
(
  SUPPRD_SUPPLIER_NUMBER ASC,
  SUPPRD_CODE ASC
);
CREATE INDEX SUPRD_IDX_SUPPLIER_NUMBER ON SUPPLIER_ORDER
(
  SUPRD_SUPPLIER_NUMBER ASC
);
CREATE UNIQUE INDEX SUPRD_IDX1 ON SUPPLIER_ORDER
(
  SUPRD_SUPPLIER_NUMBER ASC,
  SUPRD_NUMBER ASC
);
ALTER TABLE CLIENT 
  ADD CONSTRAINT CLI_PK PRIMARY KEY (
    CLI_NUMBER)  ;
ALTER TABLE CLIENT_TYPE 
  ADD CONSTRAINT CLTY_PK_CODE PRIMARY KEY (
    CLTY_CODE)  ;
ALTER TABLE COMPANY 
  ADD CONSTRAINT COMP_PK_CODE PRIMARY KEY (
    COMP_CODE)  ;
ALTER TABLE INVOICE 
  ADD CONSTRAINT INVC_PK_INVOICE_NUMBER PRIMARY KEY (
    INVC_NUMBER)  ;
ALTER TABLE INVOICE_LINE 
  ADD CONSTRAINT INVL_PK PRIMARY KEY (
    INVL_INVOICE_NUMBER, INVL_NUMBER)  ;
ALTER TABLE ORDER1 
  ADD CONSTRAINT ORD_PK_ORDER_CODE PRIMARY KEY (
    ORD_CODE)  ;
ALTER TABLE ORDER_LINE 
  ADD CONSTRAINT ORDL_PK PRIMARY KEY (
    ORDL_CODE, ORDL_PRODUCT_CODE, ORDL_NUMBER)  ;
ALTER TABLE BUSINESS_TYPE 
  ADD CONSTRAINT PK_BT PRIMARY KEY (
    BT_CODE)  ;
ALTER TABLE PAYMENT 
  ADD CONSTRAINT PMT_PK PRIMARY KEY (
    PMT_INVOICE_NUMBER, PMT_NUMBER)  ;
ALTER TABLE PAYMENT_SUMMARY 
  ADD CONSTRAINT PMTS_INVOICE_NUMBER PRIMARY KEY (
    PMTS_INVOICE_NUMBER)  ;
ALTER TABLE PRODUCT 
  ADD CONSTRAINT PROD_CODE PRIMARY KEY (
    PROD_CODE)  ;
ALTER TABLE SUPPLIER 
  ADD CONSTRAINT SUPL_PK_SUPPLIER_NUMBER PRIMARY KEY (
    SUPL_NUMBER)  ;
ALTER TABLE SUPPLIER_ORDER_LINE 
  ADD CONSTRAINT SUPORL_PK PRIMARY KEY (
    SUPORL_SUPPLIER_ORDER_NUMBER, SUPORL_SUPPLIER_NUMBER, SUPORL_NUMBER)  ;
ALTER TABLE SUPPLIER_PRODUCT 
  ADD CONSTRAINT SUPPRD_PK PRIMARY KEY (
    SUPPRD_SUPPLIER_NUMBER, SUPPRD_CODE)  ;
ALTER TABLE SUPPLIER_ORDER 
  ADD CONSTRAINT SUPRD_PK PRIMARY KEY (
    SUPRD_SUPPLIER_NUMBER, SUPRD_NUMBER)  ;
ALTER TABLE CLIENT 
  ADD CONSTRAINT CLI_UK1_CLIENT_NAME UNIQUE (
    CLI_NAME)  ;
ALTER TABLE COMPANY 
  ADD CONSTRAINT COMP_UK1 UNIQUE (
    COMP_NAME, COMP_PHONE)  ;
ALTER TABLE PRODUCT 
  ADD CONSTRAINT PROD_NAME UNIQUE (
    PROD_NAME)  ;
ALTER TABLE SUPPLIER 
  ADD CONSTRAINT SUPL_UK_SUPPLIER_NAME UNIQUE (
    SUPL_NAME)  ;
ALTER TABLE CLIENT
  ADD CONSTRAINT CLI_FK_CLIENT_TYPE 
    FOREIGN KEY (CLI_CLTY_CODE)
      REFERENCES CLIENT_TYPE(CLTY_CODE);

ALTER TABLE CLIENT
  ADD CONSTRAINT CLI_FK_COMPANY_CODE 
    FOREIGN KEY (CLI_CIE_CODE)
      REFERENCES COMPANY(COMP_CODE);

ALTER TABLE COMPANY
  ADD CONSTRAINT COMP_FK_BUSINESS_TYPE 
    FOREIGN KEY (COMP_BUSINESS_CODE)
      REFERENCES BUSINESS_TYPE(BT_CODE);

ALTER TABLE INVOICE
  ADD CONSTRAINT INVC_FK_CLIENT_NUMBER 
    FOREIGN KEY (INVC_CLI_NUMBER)
      REFERENCES CLIENT(CLI_NUMBER);

ALTER TABLE INVOICE_LINE
  ADD CONSTRAINT INVL_FK_INVOICE_NUMBER 
    FOREIGN KEY (INVL_INVOICE_NUMBER)
      REFERENCES INVOICE(INVC_NUMBER);

ALTER TABLE INVOICE_LINE
  ADD CONSTRAINT INVL_FK_PRODUCT_CODE 
    FOREIGN KEY (INVL_PROD_CODE)
      REFERENCES PRODUCT(PROD_CODE);

ALTER TABLE ORDER1
  ADD CONSTRAINT ORD_CLIENT_NUMBER 
    FOREIGN KEY (ORD_CLIENT_NUMBER)
      REFERENCES CLIENT(CLI_NUMBER);

ALTER TABLE ORDER_LINE
  ADD CONSTRAINT ORDL_FK_ORDER_CODE 
    FOREIGN KEY (ORDL_CODE)
      REFERENCES ORDER1(ORD_CODE);

ALTER TABLE ORDER_LINE
  ADD CONSTRAINT ORDL_FK_PRODUCT_CODE 
    FOREIGN KEY (ORDL_PRODUCT_CODE)
      REFERENCES PRODUCT(PROD_CODE);

ALTER TABLE PAYMENT
  ADD CONSTRAINT PMT_FK_INVOICE_NUMBER 
    FOREIGN KEY (PMT_INVOICE_NUMBER)
      REFERENCES INVOICE(INVC_NUMBER);

ALTER TABLE SUPPLIER_ORDER_LINE
  ADD CONSTRAINT SUPORL_FK_PRODUCT_CODE 
    FOREIGN KEY (SUPORL_PRODUCT_CODE)
      REFERENCES PRODUCT(PROD_CODE);

ALTER TABLE SUPPLIER_ORDER_LINE
  ADD CONSTRAINT SUPORL_FK_SUPPLIER_ORDER 
    FOREIGN KEY (SUPORL_SUPPLIER_ORDER_NUMBER, SUPORL_SUPPLIER_NUMBER)
      REFERENCES SUPPLIER_ORDER(SUPRD_SUPPLIER_NUMBER, SUPRD_NUMBER);

ALTER TABLE SUPPLIER_PRODUCT
  ADD CONSTRAINT SUPPRD_FK_PRODUCT_CODE 
    FOREIGN KEY (SUPPRD_PRODUCT_CODE)
      REFERENCES PRODUCT(PROD_CODE);

ALTER TABLE SUPPLIER_PRODUCT
  ADD CONSTRAINT SUPPRD_FK_SUPPLIER_NUMBER 
    FOREIGN KEY (SUPPRD_SUPPLIER_NUMBER)
      REFERENCES SUPPLIER(SUPL_NUMBER);

ALTER TABLE SUPPLIER_ORDER
  ADD CONSTRAINT SUPRD_FK_SUPPLIER_NUMBER 
    FOREIGN KEY (SUPRD_SUPPLIER_NUMBER)
      REFERENCES SUPPLIER(SUPL_NUMBER);

CREATE VIEW CLIENT_CORPO_VIEW (CLI_NAME, CLI_PHONE, CLI_CLTY_CODE)
    AS SELECT (CLI_NAME, CLI_PHONE, CLI_CLTY_CODE) AS SELECT CLI_NAME,  CLI_PHONE,  CLI_CLTY_CODE FROM CLIENT CLI, CLIENT_TYPE CLTY WHERE CLI.CLI_CLTY_CODE =CLTY.CLTY_CODE AND UPPER(CLTY.CLTY_DESCRIPTION) LIKE 'CORPO%' ;


    END

