DROP TABLE UserInfo CASCADE CONSTRAINTS;
DROP TABLE Pet CASCADE CONSTRAINTS;
DROP TABLE Area CASCADE CONSTRAINTS;
DROP TABLE Hospital CASCADE CONSTRAINTS;
DROP SEQUENCE petId_seq;
DROP SEQUENCE areaId_seq;
DROP SEQUENCE hospitalId_seq;

CREATE TABLE UserInfo (
   UserInfoId   VARCHAR2(18)   PRIMARY KEY,
   password    	VARCHAR2(18),
   name         VARCHAR2(18),
   email        VARCHAR2(20),   
   phone        VARCHAR2(11),
   birthday     VARCHAR2(6),
   gender       VARCHAR2(1)
);

CREATE TABLE Pet ( 
   petId       	 NUMBER(4)      PRIMARY KEY, 
   pname         VARCHAR2(18)   NOT NULL,
   gender        VARCHAR2(1),
   variety		 VARCHAR2(20),
   age           NUMBER(3),
   kind          VARCHAR2(10),
   pdate         VARCHAR2(8),
   explanation   VARCHAR2(150),
   weight        NUMBER(3),
   UserInfoId    VARCHAR2(18),
   hospitalId    NUMBER(18),
   areaId        NUMBER(4),
   image         VARCHAR2(100),
   adopt         NUMBER(10)      NOT NULL,
   noAdopt       NUMBER(10)      NOT NULL,
   protect       NUMBER(10)      NOT NULL,
   lost          NUMBER(10)      NOT NULL
);

CREATE TABLE Area ( 
   areaId      NUMBER(4)   PRIMARY KEY, 
   city        VARCHAR2(15)   ,
   gu          VARCHAR2(15)   
);

CREATE TABLE Hospital (
   hospitalId   NUMBER(18)      PRIMARY KEY,
   name         VARCHAR2(30),
   phone        VARCHAR2(15),
   address      VARCHAR2(65),
   hour         VARCHAR2(100),
   areaId       NUMBER(4)
);

ALTER TABLE Hospital ADD FOREIGN KEY (areaId) REFERENCES Area (areaId);
ALTER TABLE Pet ADD FOREIGN KEY (UserInfoId) REFERENCES UserInfo (UserInfoId);
ALTER TABLE Pet ADD FOREIGN KEY (hospitalId) REFERENCES Hospital (hospitalId);
ALTER TABLE Pet ADD FOREIGN KEY (areaId) REFERENCES Area (areaId);


CREATE SEQUENCE petId_seq
   START WITH 1
   INCREMENT BY 1; 

CREATE SEQUENCE areaId_seq
   START WITH 1
   INCREMENT BY 1; 

CREATE SEQUENCE hospitalId_seq
   START WITH 1
   INCREMENT BY 1;
   
INSERT INTO Area VALUES (1, '서울특별시', '강남구');
INSERT INTO Area VALUES (2, '서울특별시', '구로구');
INSERT INTO Area VALUES (3, '서울특별시', '은평구');
INSERT INTO Area VALUES (4, '서울특별시', '마포구');
INSERT INTO Area VALUES (5, '서울특별시', '서대문구');

INSERT INTO Area VALUES (6, '인천광역시', '강화군');
INSERT INTO Area VALUES (7, '인천광역시', '계양구');
INSERT INTO Area VALUES (8, '인천광역시', '동구');
INSERT INTO Area VALUES (9, '인천광역시', '서구');
INSERT INTO Area VALUES (10, '인천광역시', '중구');

INSERT INTO Area VALUES (11, '광주광역시', '동구');
INSERT INTO Area VALUES (12, '광주광역시', '남구');
INSERT INTO Area VALUES (13, '광주광역시', '광산구');
INSERT INTO Area VALUES (14, '광주광역시', '서구');
INSERT INTO Area VALUES (15, '광주광역시', '북구');

INSERT INTO Area VALUES (16, '대전광역시', '중구');
INSERT INTO Area VALUES (17, '대전광역시', '대덕구');
INSERT INTO Area VALUES (18, '대전광역시', '동구');
INSERT INTO Area VALUES (19, '대전광역시', '서구');
INSERT INTO Area VALUES (20, '대전광역시', '유성구');

INSERT INTO Area VALUES (21, '대구광역시', '동구');
INSERT INTO Area VALUES (22, '대구광역시', '중구');
INSERT INTO Area VALUES (23, '대구광역시', '남구');
INSERT INTO Area VALUES (24, '대구광역시', '북구');
INSERT INTO Area VALUES (25, '대구광역시', '서구');

INSERT INTO Area VALUES (26, '부산광역시', '서구');
INSERT INTO Area VALUES (27, '부산광역시', '남구');
INSERT INTO Area VALUES (28, '부산광역시', '북구');
INSERT INTO Area VALUES (29, '부산광역시', '중구');
INSERT INTO Area VALUES (30, '부산광역시', '강서구');

INSERT INTO Area VALUES (31, '울산광역시', '울주군');
INSERT INTO Area VALUES (32, '울산광역시', '동구');
INSERT INTO Area VALUES (33, '울산광역시', '남구');
INSERT INTO Area VALUES (34, '울산광역시', '중구');
INSERT INTO Area VALUES (35, '울산광역시', '북구');

INSERT INTO Area VALUES (36, '경상북도', '포항시');
INSERT INTO Area VALUES (37, '경상북도', '의성군');
INSERT INTO Area VALUES (38, '경상북도', '안동시');
INSERT INTO Area VALUES (39, '경상북도', '영천시');
INSERT INTO Area VALUES (40, '경상북도', '울릉군');

INSERT INTO Area VALUES (41, '경상남도', '통영시');
INSERT INTO Area VALUES (42, '경상남도', '함양군');
INSERT INTO Area VALUES (43, '경상남도', '합천군');
INSERT INTO Area VALUES (44, '경상남도', '거제시');
INSERT INTO Area VALUES (45, '경상남도', '밀양시');

INSERT INTO Area VALUES (46, '경기도', '광명시');
INSERT INTO Area VALUES (47, '경기도', '김포시');
INSERT INTO Area VALUES (48, '경기도', '고양시');
INSERT INTO Area VALUES (49, '경기도', '여주시');
INSERT INTO Area VALUES (50, '경기도', '안양시');

INSERT INTO Area VALUES (51, '전라북도', '임실군');
INSERT INTO Area VALUES (52, '전라북도', '전주시');
INSERT INTO Area VALUES (53, '전라북도', '익산시');
INSERT INTO Area VALUES (54, '전라북도', '군산시');
INSERT INTO Area VALUES (55, '전라북도', '김제시');

INSERT INTO Area VALUES (56, '충청남도', '아산시');
INSERT INTO Area VALUES (57, '충청남도', '천안시');
INSERT INTO Area VALUES (58, '충청남도', '당진시');
INSERT INTO Area VALUES (59, '충청남도', '논산시');
INSERT INTO Area VALUES (60, '충청남도', '보령시');

INSERT INTO Area VALUES (61, '충청북도', '충주시');
INSERT INTO Area VALUES (62, '충청북도', '청주시');
INSERT INTO Area VALUES (63, '충청북도', '단양군');
INSERT INTO Area VALUES (64, '충청북도', '제천시');
INSERT INTO Area VALUES (65, '충청북도', '영동군');

INSERT INTO Area VALUES (66, '강원도', '평창군');
INSERT INTO Area VALUES (67, '강원도', '고성군');
INSERT INTO Area VALUES (68, '강원도', '양양군');
INSERT INTO Area VALUES (69, '강원도', '인제군');
INSERT INTO Area VALUES (70, '강원도', '강릉시');

INSERT INTO Area VALUES (71, '세종특별자치시', '세종특별자치시');

INSERT INTO Area VALUES (72, '전라남도', '나주시');
INSERT INTO Area VALUES (73, '전라남도', '강진군');
INSERT INTO Area VALUES (74, '전라남도', '순천시');
INSERT INTO Area VALUES (75, '전라남도', '완도군');
INSERT INTO Area VALUES (76, '전라남도', '해남군');

INSERT INTO Area VALUES (77, '제주특별자치도', '제주특별자치도');

INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '강남동물병원', '02-514-7582', '서울 강남구 봉은사로 205 상하빌딩', '매일 09:00~19:00', 1);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '굿모닝동물병원', '02-2060-8673', '서울 구로구 개봉로 121', '매일 10:00~22:00', 2);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '가든펫동물병원', '0507-1338-5555', '서울 은평구 증산로9길 26-23 지하1층', '매일 10:00~16:00', 3);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '웰케어동물병원', '02-337-7575', '서울 마포구 월드컵북로 27 이화빌딩', '매일 09:30~19:30', 4);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '독립문동물병원', '02-733-5060', '서울 서대문구 통일로 171-1', '매일 09:00~18:00', 5);

INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '베스트동물병원', '032-934-9340', '인천 강화군 강화읍 강화대로 217', '매일 10:00~20:00', 6);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '신영재동물병원', '032-552-0075', '인천 계양구 장제로 932', '매일 10:00~20:00', 7);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '인천종합동물병원', '032-765-0112', '인천 동구 솔빛로 2', '매일 10:00~19:00', 8);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '가정동물병원', '032-575-0833', '인천 서구 가정로 346', '매일 10:00~19:30', 9);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '경동동물병원', '032-765-9988', '인천 중구 개항로 66-2', '매일 10:00~20:30', 10);

INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '튼튼동물병원', '062-511-7582', '광주 동구 중앙로 358', '평일 10:00~18:30/점심시간 12:00~13:30', 11);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '노아동물종합병원', '062-363-4860', '광주 남구 대남대로 407', '평일 9:30~23:00/점심시간 13:00~14:00', 12);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '24시 동물병원 공감', '062-716-2979', '광주 광산구 장신로 72', '매일 00:00~24:00', 13);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '광주24시스카이동물메디컬센터', '062-719-4275', '광주 서구 상무대로 879 두왕빌딩 3,4,5층', '매일 00:00~24:00', 14);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '광주 동물 보호소', '062-571-2808', '광주광역시 북구 본촌 마을길 25(본촌동, 건국동사무소)', '매일 9:00~17:00/점심시간 12:30~13:30', 15);

INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '대전24시 센트럴동물병원', '042-719-7779', '대전 중구 계룡로 789 1층', '매일 00:00~24:00', 16);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '스마일동물병원', '042-626-3075', '대전 대덕구 중리로 58', '평일 10:30~19:00', 17);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, ' 24시 더원동물메디컬센터', '042-623-8461', '대전 동구 계족로 510 1층', '매일 00:00~24:00', 18);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '24아프리카동물메디컬센터', '042-486-7581', '대전 서구 문정로 16', '매일 00:00~24:00', 19);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '대전동물보호센터', '042-825-1118', '대전 유성구 갑동로15번길 20-39', '매일 9:00~17:00', 20);

INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '다사랑종합동물병원', '053-942-0805', '대구 동구 신암로 86-1', '매일 09:00~19:00', 21);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '센트럴동물병원', '053-214-5577', '대구 중구 달구벌대로 1943 대신이편한세상 상가 101동 2층', '매일 10:00~20:00', 22);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '남부동물병원', '053-654-1444', '대구 남구 두류공원로 18-2', '매일 10:00~20:00', 23);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '가나동물병원', '053-941-0075', '대구 북구 산격로 109', '매일 10:00~22:00', 24);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '더펫동물병원', '0507-1414-0622', '대구 서구 서대구로 361', '매일 10:00~16:00', 25);

INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '만박동물병원', '0507-1420-7975', '부산 서구 까치고개로 257', '매일 09:30~21:00', 26);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '용호동물병원', '051-628-0855', '부산 남구 용호로123번길 5 목련아파트', '매일 09:00~18:00', 27);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '노아동물병원', '051-343-7588', '부산 북구 금곡대로 175 상가 2층', '매일 09:30~18:30', 28);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '피닉스동물병원', '051-246-7551', '부산 중구 구덕로 30-1', '매일 10:00~20:00', 29);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '해옴동물병원', '0507-1405-8119', '부산 강서구 명지오션시티4로 69 2층 201호', '매일 09:30~21:00', 30);

INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '와우동물병원', '052-225-0075', '울산 울주군 언양읍 읍성로 135', '매일 09:30~18:30', 31);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '동울산동물병원', '052-235-0458', '울산 동구 방어진순환도로 737', '매일 09:30~21:00', 32);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '주동물병원', '0507-1493-8276', '울산 남구 돋질로 385-1', '매일 10:00~16:00', 33);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '닥터강동물병원', '052-246-3123', '울산 중구 화진길 13-2', '매일 10:00~20:00', 34);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '쿨펫동물병원', '052-286-3567', '울산 북구 신답로 26 홈플러스', '매일 0:00~22:00', 35);

INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '굿모닝동물병원', '0507-1344-8275', '경북 포항시 남구 오천읍 냉천로 310 1층', '평일 09:30~19:00', 36);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '의성축협동물병원', '054-861-1665', '경북 의성군 봉양면 모선길 20', '평일 9:00~18:00', 37);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '신세계동물병원', '0507-1329-7553', '경북 안동시 퇴계로 127', '평일 09:30~18:30', 38);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '경민동물병원', '070-8882-6179', '경북 영천시 선창길 9', '평일 10:00~20:00', 39);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '우산동물병원', '054-791-0911', '경북 울릉군 서면 남양1길 4', '평일 09:30~18:30', 40);

INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '사랑애완동물병원', '055-648-7582', '경남 통영시 광도면 죽림3로 33 가동 103호', '매일 9:00~18:00', 41);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '중앙동물병원', '055-963-7615', '경남 함양군 수동면 변동3길 6-2', '매일 9:00~18:00', 42);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '태민동물병원', '055-931-7975', '경남 합천군 합천읍 옥산로 16 까치빌라 상가 101호', '매일 9:00~18:00', 43);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '거제동물메디컬센터', '055-632-7582', '거제시 서문로6길 1 타워프라임2층(고현동)', '매일 9:00~18:00', 44);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '가야동물병원', '055-352-6610', '밀양시 백민로 101-1', '매일 9:00~18:00', 45);

INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '광명 24 아이디동물의료센터', '02-6952-2475', '경기 광명시 오리로 870 서희스타힐스빌딩 2층 아이디동물의료센터', '매일 00:00~24:00', 46);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '김포메디엘동물병원', '031-985-7075', '경기 김포시 김포한강4로 521 한강메디플라자 2층', '평일 10:00~20:00', 47);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '24시 나음동물의료센터', '031-906-7975', '경기 고양시 일산동구 백마로 223 현대에뜨레보 1층', '매일 00:00~24:00', 48);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '나무동물병원', '031-885-7475', '경기 여주시 청심로 17-7', '평일 10:00~18:00/토요일 10:00~12:30', 49);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '24시마음든든동물병원', '031-474-2475', '경기 안양시 만안구 경수대로 1234', '매일 00:00~24:00', 50);

INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '박영재동물병원', '063-284-7774', '전북 전주시 완산구 전주천서로 111', '평일 08:30~21:00/토요일 08:30~19:00/일요일 10:30~18:00', 51);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '늘푸른동물병원', '063-281-0075', '전북 전주시 완산구 충경로 11', '평일 09:00~18:00', 52);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '익산유기동물보호소', '010-3659-2380', '전북 익산시 서동로42길 77', '평일 09:00~18:00', 53);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '군산24시 제일동물병원', '063-461-5079', '전북 군산시 진포로 73', '평일 09:30~20:30', 54);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '우리동물병원', '063-547-2670', '전북 김제시 남북로 213-1', '평일 09:00~18:00', 55);

INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '린동물병원', '041-558-8875', '충남 아산시 배방읍 광장로 181 1층 104호', '매일 10:00~20:00', 56);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '굿모닝24시동물병원', '041-576-7552', '충남 천안시 서북구 쌍용대로 43 진주빌딩', '매일 08:00~24:00', 57);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '당진종합동물병원', '041-352-6141', '충남 당진시 무수동로 36', '평일 09:00~18:00', 58);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '호크종합동물병원', '041-736-8875', '충남 논산시 중앙로398번길 2', '평일 09:00~18:00', 59);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '보령동물병원', '041-934-0013', '충남 보령시 한내로 21', '평일 09:00~18:00', 60);

INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '충주 반려동물 보호센터', '043-851-3168', '충북 충주시 중앙탑면 일곱실길 70', '매일 9:00~18:00', 61);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '반려동물보호센터', '043-201-2298', '충북 청주시 흥덕구 강내면 서부로 411-55', '매일 9:00~18:00', 62);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '단양군유기동물보호소', '043-420-2744', '충북 단양군 매포읍 단양산업단지2로 88-34', '매일 9:00~18:00', 63);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '제천시동물보호센터', '043-627-0059', '충북 제천시 금성면 동막리 994-2', '매일 9:00~18:00', 64);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '최종주동물병원', '043-744-4209', '충북 영동군 영동읍 계산로 54', '매일 9:00~18:00', 65);

INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '평창군유기동물보호소', '010-3397-9150', '강원 평창군 진부면 청송로 61', '매일 9:00~18:00', 66);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '고성군임시보호소', '033-680-3723', '강원 고성군 죽왕면 가진리', '매일 9:00~18:00', 67);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '양양군유기동물보호소', '033-670-2278', '강원 양양군 손양면 동해대로 2558', '매일 9:00~18:00', 68);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '인제군유기동물보호소', '033-460-2473', '강원 인제군 인제읍 비봉로44번길 105', '매일 9:00~18:00', 69);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '강릉시 동물보호소', '033-641-7515', '강원 강릉시 성산면 내맬길 172', '매일 9:00~18:00', 70);

INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '세종유기동물보호센터', '044-863-3720', '세종특별자치시 전동면 미륵당1길 188', '매일 9:00~18:00', 71);

INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '빛고을 애견', '010-5019-0076', '전남 나주시 남평읍 회재로 22', '매일 9:00~18:00', 72);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '강진군유기견보호소', '061-430-3613', '전남 강진군 강진읍 남당로 97-73', '매일 9:00~18:00', 73);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '순천시유기동물보호소', '061-749-8793', '전남 순천시 승주읍 승주로 628', '매일 9:00~18:00', 74);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '유기동물임시보호센터', '010-3616-6658', '전라남도 완도군 신지면 신지로6번길 23-89', '매일 9:00~18:00', 75);
INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '해남군유기동물보호소', '061-533-1141', '전남 해남군 해남읍 남부순환로 18-1', '매일 9:00~18:00', 76);

INSERT INTO Hospital VALUES(hospitalId_seq.NEXTVAL, '제주동물보호센터', '064-710-4065', '제주 제주시 첨단동길 184-14', '평일 09:00~18:00/토요일 09:00~13:00', 77);

INSERT INTO UserInfo VALUES('20180994', '20180994', '이승혜', 'laurel8310@naver.com', '01077953736', '990322', 'F');
INSERT INTO Pet VAlUES(petId_seq.NEXTVAL, '멍', 'M', '비숑', 2, '강아지', '0502', '기욤', 2.1, 'img.jpg', 1, 0, 0, 0, '20180994', 1, 1);