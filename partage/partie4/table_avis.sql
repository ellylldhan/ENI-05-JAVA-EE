Create table AVIS
(identifiant int IDENTITY(1,1) CONSTRAINT PK_AVIS PRIMARY KEY,
description varchar(150) not null,
note tinyint NOT NULL CONSTRAINT CK_AVIS_NOTE CHECK(note between 1 and 5)
);