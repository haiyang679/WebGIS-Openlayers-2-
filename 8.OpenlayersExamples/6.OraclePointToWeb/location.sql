--------------------------------------------------------
--  File created - ÐÇÆÚÒ»-¾ÅÔÂ-07-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table LOCATIONS
--------------------------------------------------------

  CREATE TABLE "LOCATIONS" 
   (	"LAT" VARCHAR2(522), 
	"LON" VARCHAR2(522), 
	"CITY" VARCHAR2(522), 
	"NUMBER" NUMBER
   ) ;

---------------------------------------------------
--   DATA FOR TABLE LOCATIONS
--   FILTER = none used
---------------------------------------------------
REM INSERTING into LOCATIONS
Insert into LOCATIONS (LAT,LON,CITY,NUMBER) values ('45.420833','-75.69','Ottawa',200);
Insert into LOCATIONS (LAT,LON,CITY,NUMBER) values ('46.066667','11.116667','Trento',140);
Insert into LOCATIONS (LAT,LON,CITY,NUMBER) values ('44.9441','-93.0852','St Paul',125);
Insert into LOCATIONS (LAT,LON,CITY,NUMBER) values ('13.752222','100.493889100.493889','Bangkok',150);
Insert into LOCATIONS (LAT,LON,CITY,NUMBER) values ('44.9801','-93.251867','Minneapolis',350);
Insert into LOCATIONS (LAT,LON,CITY,NUMBER) values ('46.519833','6.6335','Lausanne',560);
Insert into LOCATIONS (LAT,LON,CITY,NUMBER) values ('48.428611','-123.365556','Victoria',721);
Insert into LOCATIONS (LAT,LON,CITY,NUMBER) values ('-33.925278','18.423889','Cape Town',550);
Insert into LOCATIONS (LAT,LON,CITY,NUMBER) values ('-33.859972','151.211111','Sydney',436);
Insert into LOCATIONS (LAT,LON,CITY,NUMBER) values ('41.383333','2.183333','Barcelona',914);
Insert into LOCATIONS (LAT,LON,CITY,NUMBER) values ('39.739167','-104.984722','Denver',869);
Insert into LOCATIONS (LAT,LON,CITY,NUMBER) values ('52.95','-1.133333','Nottingham',800);
Insert into LOCATIONS (LAT,LON,CITY,NUMBER) values ('45.52','-122.681944','Portland',840);
Insert into LOCATIONS (LAT,LON,CITY,NUMBER) values ('39.916527','116.397128','beijin',1);

---------------------------------------------------
--   END DATA FOR TABLE LOCATIONS
---------------------------------------------------
