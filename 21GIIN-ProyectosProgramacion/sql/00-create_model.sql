-- Creación inicial del esquema

CREATE TABLE IF NOT EXISTS usuario (
  id INT(10) UNSIGNED NOT NULL,
  nombre VARCHAR(10) NOT NULL,
  password VARCHAR(8) NOT NULL,
  tipo ENUM('Normal', 'AdminCentro', 'Admin') NOT NULL DEFAULT 'Normal',
  estado ENUM('Alta', 'Baja') NOT NULL DEFAULT 'Alta',
  PRIMARY KEY (id),
  UNIQUE INDEX Nombre_UNIQUE (nombre ASC) )
ENGINE = INNODB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS centro (
  id INT(10) UNSIGNED NOT NULL,
  id_administrador INT(10) UNSIGNED NOT NULL,
  nombre VARCHAR(10) NOT NULL,
  capacidad FLOAT(11) NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_CENTRO_USUARIO_admin_idx (id_administrador ASC) ,
  CONSTRAINT fk_CENTRO_USUARIO_admin
    FOREIGN KEY (id_administrador)
    REFERENCES usuario (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS trabajo (
  id INT(10) UNSIGNED NOT NULL,
  nombre VARCHAR(30) NOT NULL,
  propietario INT(10) UNSIGNED NOT NULL,
  modificado_por INT(10) UNSIGNED NOT NULL,
  fecha_creacion DATETIME NOT NULL,
  fecha_fin DATETIME NULL DEFAULT NULL,
  centro INT(10) UNSIGNED NULL DEFAULT NULL,
  estado ENUM('Pendiente', 'Ejecución', 'Cancelado', 'Finalizado') NOT NULL DEFAULT 'Pendiente',
  operaciones_iniciales FLOAT(11) NOT NULL,
  operaciones_pendientes FLOAT(11) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX nombre_UNIQUE (nombre ASC) ,
  INDEX fk_TRABAJO_CENTRO_asignado_idx (centro ASC) ,
  INDEX fk_TRABAJO_USUARIO_propietario_idx (modificado_por ASC) ,
  CONSTRAINT fk_TRABAJO_CENTRO_asignado
    FOREIGN KEY (centro)
    REFERENCES centro (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_TRABAJO_USUARIO_propietario
    FOREIGN KEY (modificado_por)
    REFERENCES usuario (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_TRABAJO_USUARIO_modificador_por
    FOREIGN KEY (modificado_por)
    REFERENCES usuario (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

