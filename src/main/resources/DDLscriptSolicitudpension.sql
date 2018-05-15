
DROP TABLE IF EXISTS solicitudpension;

CREATE TABLE solicitudpension ( 

afiliadoId INT,
tipopensionId INT,

numero VARCHAR(100),
fecha_solicitud VARCHAR(100),
observaciones VARCHAR(100),

solicitudpensionId INT NOT NULL AUTO_INCREMENT PRIMARY KEY);

