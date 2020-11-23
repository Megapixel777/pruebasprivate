UPDATE usuario SET tipo='Normal' where tipo='AdminCentro';
COMMIT;

ALTER TABLE usuario MODIFY COLUMN tipo enum('Normal','Admin') CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT 'Normal' NOT NULL;
