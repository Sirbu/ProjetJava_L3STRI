-- Uncomment if you want to reset the database
-- DROP TABLE User;
-- DROP TABLE Salon;
-- DROP TABLE MessageSalon;
-- DROP TABLE MessageUser;
-- DROP TABLE Accede;

CREATE TABLE User
(
    idUser      BIGINT AUTO_INCREMENT,
    login       VARCHAR(20),
    password    BINARY(128),
    isAdmin     BOOLEAN,
    statut      ENUM("Connecté", "Hors ligne", "Absent", "Occupé"),

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
