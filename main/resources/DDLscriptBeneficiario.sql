
DROP TABLE IF EXISTS beneficiario;

CREATE TABLE beneficiario ( id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
						fecha_nacimiento VARCHAR(100)
,						curp VARCHAR(100)
,						nombre VARCHAR(100)
,						apellido_materno VARCHAR(100)
,						parentesco VARCHAR(100)
,						apellido_paterno VARCHAR(100)
);

