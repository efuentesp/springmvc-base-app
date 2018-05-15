
DROP TABLE IF EXISTS afiliado;

CREATE TABLE afiliado ( 

generoId VARCHAR(100),
beneficiarioId INT,

nss VARCHAR(100),
nombre VARCHAR(100),
apellido_paterno VARCHAR(100),
apellido_materno VARCHAR(100),
observaciones VARCHAR(100),
fecha_afiliacion VARCHAR(100),
foto VARCHAR(100),
acta_nacimiento VARCHAR(100),
correo VARCHAR(100),
semanas_cotizadas VARCHAR(100),
monto_pension VARCHAR(100),

afiliadoId INT NOT NULL AUTO_INCREMENT PRIMARY KEY);

