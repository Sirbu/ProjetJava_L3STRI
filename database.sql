DROP TABLE MessageSalon CASCADE; 
DROP TABLE MessageUser CASCADE;
DROP TABLE Accede CASCADE; 
DROP TABLE Salon CASCADE; 
DROP TABLE User CASCADE; 

CREATE TABLE User 
( 
     idUser      BIGINT AUTO_INCREMENT, 
     login       VARCHAR(20), 
     password	 VARCHAR(50), 
     isAdmin     BOOLEAN, 
     statut      ENUM("Connecte", "Hors ligne", "Absent", "Occupe"), 
 
 
     PRIMARY KEY pk_User_idUser(idUser) 
); 
 
CREATE TABLE Salon 
( 
     idSalon         BIGINT AUTO_INCREMENT, 
     nomSalon        VARCHAR(50), 
     description     TEXT(200), 
 
 
     PRIMARY KEY pk_Salon_idSalon(idSalon) 
); 
 

CREATE TABLE MessageSalon 
( 
     idMessSalon     BIGINT AUTO_INCREMENT, 
     contenu         TEXT(200), 
     dateEnvoi       DATETIME, 
     -- Foreign Keys 
     idUser          BIGINT, 
     idSalon         BIGINT, 
 
 
     PRIMARY KEY pk_MessageSalon_idMessSalon(idMessSalon), 
 
 
     FOREIGN KEY fk_MessageSalon_idUser(idUser) REFERENCES User (idUser), 
     FOREIGN KEY fk_MessageSalon_idSalon(idSalon) REFERENCES Salon (idSalon) 
); 
 
CREATE TABLE MessageUser  
( 
     idMessUser      BIGINT AUTO_INCREMENT, 
     contenu         TEXT(200), 
     dateEnvoi       DATETIME, 
     -- Foreign Keys 
     idExpediteur    BIGINT, 
     idRecepteur     BIGINT,   
 
 
     PRIMARY KEY pk_MessageUser_idMessUser(idMessUser), 
 
 
     FOREIGN KEY fk_MessageUser_idExpediteur(idExpediteur) REFERENCES User (idUser), 
     FOREIGN KEY fk_MessageUser_idRecepteur(idRecepteur) REFERENCES User (idUser) 
); 
 
 
CREATE TABLE Accede 
( 
     -- Foreign-Primary Keys 
     idUser      BIGINT, 
     idSalon     BIGINT, 
 

     lecture     BOOLEAN, 
     ecriture    BOOLEAN, 
 

     FOREIGN KEY fk_Accede_idUser(idUser) REFERENCES User (idUser), 
     FOREIGN KEY fk_Accede_idSalon(idSalon) REFERENCES Salon (idSalon), 
 
 
     PRIMARY KEY pk_Accede_idUser_idSalon(idUser, idSalon) 
);


INSERT INTO User (login,password,isAdmin,statut) VALUES ('test','test1','0','Connecte');
INSERT INTO User (login,password,isAdmin,statut) VALUES ('quentin','junca','0','Occupe');
INSERT INTO User (login,password,isAdmin,statut) VALUES ('alexis','sirbu','0','Connecte');
INSERT INTO User (login,password,isAdmin,statut) VALUES ('sandre','dubois','0','Absent');


INSERT INTO Salon (nomSalon,description) VALUES ('Saloon','salon de discussion autour d"un verre');
INSERT INTO Salon (nomSalon,description) VALUES ('SalonProject','salon de discussion autour du projet JAVA');
INSERT INTO Salon (nomSalon,description) VALUES ('SalonCloud','salon de discussion autour du Cloud');


INSERT INTO MessageSalon (contenu,dateEnvoi,idUser,idSalon) VALUES ('Message','2016-05-10 17:19:34','1','2');
INSERT INTO MessageSalon (contenu,dateEnvoi,idUser,idSalon) VALUES ('Message1','2016-05-10 17:20:34','2','1');
INSERT INTO MessageSalon (contenu,dateEnvoi,idUser,idSalon) VALUES ('Message2','2016-05-10 17:21:34', '2', '1');


INSERT INTO MessageUser (contenu,dateEnvoi,idExpediteur,idRecepteur) VALUES ('Message','2016-05-10 17:32:34','1','2');
INSERT INTO MessageUser (contenu,dateEnvoi,idExpediteur,idRecepteur) VALUES ('Message1','2016-05-10 17:42:12','2','1');
INSERT INTO MessageUser (contenu,dateEnvoi,idExpediteur,idRecepteur) VALUES ('Message2','2016-05-10 17:53:45', '1', '2');

INSERT INTO Accede (idUser,idSalon,lecture,ecriture) VALUES ('1','2','1','1');
INSERT INTO Accede (idUser,idSalon,lecture,ecriture) VALUES ('2','1','1','0');
INSERT INTO Accede (idUser,idSalon,lecture,ecriture) VALUES ('3', '1', '1', '1');
INSERT INTO Accede (idUser,idSalon,lecture,ecriture) VALUES ('3', '2', '1', '1');
INSERT INTO Accede (idUser,idSalon,lecture,ecriture) VALUES ('3', '3', '1', '1');

SELECT * FROM User;
SELECT * FROM Salon;
SELECT * FROM MessageSalon;
SELECT * FROM MessageUser;
SELECT * FROM Accede;
