CREATE TABLE MISPARTIDOS (_ID INTEGER PRIMARY KEY AUTOINCREMENT,LIGA INTEGER NOT NULL,CATEGORIA INTEGER NOT NULL,EQUIPO1 TEXT NOT NULL,EQUIPO2 TEXT NOT NULL,FECHA TEXT NOT NULL,LUGAR TEXT NOT NULL,NOTIFICAR TEXT NOT NULL);
CREATE TABLE MISPREFERENCIAS(_ID INTEGER PRIMARY KEY AUTOINCREMENT, LIGA INTEGER NOT NULL, CATEGORIA INTEGER NOT NULL);
INSERT INTO MISPARTIDOS (LIGA,CATEGORIA,EQUIPO1,EQUIPO2,FECHA,LUGAR,NOTIFICAR) VALUES (1,2,"VIEJITOSa","VIEJITOSb","2017-1-20","LA CAPILLITA","TRUE");
INSERT INTO MISPARTIDOS (LIGA,CATEGORIA,EQUIPO1,EQUIPO2,FECHA,LUGAR,NOTIFICAR) VALUES (2,2,"SEMIVIEJa","SEMIVIEJb","2017-1-21","LA CAPILLITA","TRUE");
INSERT INTO MISPARTIDOS (LIGA,CATEGORIA,EQUIPO1,EQUIPO2,FECHA,LUGAR,NOTIFICAR) VALUES (3,2,"ADULTOSa","ADULTOSb","2017-1-22","LA CAPILLITA","TRUE");
INSERT INTO MISPARTIDOS (LIGA,CATEGORIA,EQUIPO1,EQUIPO2,FECHA,LUGAR,NOTIFICAR) VALUES (4,2,"JOVENESa","JOVENESb","2017-1-23","CHAPINO","TRUE");
INSERT INTO MISPARTIDOS (LIGA,CATEGORIA,EQUIPO1,EQUIPO2,FECHA,LUGAR,NOTIFICAR) VALUES (5,2,"NENESa","NENESb","2017-1-24","CHAPINO","TRUE");
INSERT INTO MISPARTIDOS (LIGA,CATEGORIA,EQUIPO1,EQUIPO2,FECHA,LUGAR,NOTIFICAR) VALUES (5,2,"BEBESa","BEBESb","2017-1-24","CHAPINO","TRUE");
INSERT INTO MISPREFERENCIAS (LIGA,CATEGORIA) VALUES (0,0);
