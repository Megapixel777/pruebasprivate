SET FOREIGN_KEY_CHECKS=0;

ALTER TABLE centro MODIFY COLUMN id int(10) unsigned auto_increment NOT NULL;
ALTER TABLE usuario MODIFY COLUMN id int(10) unsigned auto_increment NOT NULL;
ALTER TABLE trabajo MODIFY COLUMN id int(10) unsigned auto_increment NOT NULL;

SET FOREIGN_KEY_CHECKS=0;
