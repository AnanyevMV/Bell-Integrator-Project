SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS organization;
CREATE TABLE organization (
id INT(11) COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(255) NOT NULL COMMENT 'Короткое название организации',
full_name VARCHAR(255) NOT NULL COMMENT 'Полное название организации',
inn VARCHAR(255) NOT NULL COMMENT 'ИНН',
kpp VARCHAR(255) NOT NULL COMMENT 'КПП',
address VARCHAR(255) NOT NULL COMMENT 'Адрес организации',
phone VARCHAR(255) DEFAULT NULL COMMENT 'Телефон организации',
is_active TINYINT(1) DEFAULT 1 COMMENT 'Активна ли организация',
version INT(11) DEFAULT 0 COMMENT 'Для оптимистичной блокировки',
CONSTRAINT CHK_organization_is_active CHECK ((is_active = 0) OR (is_active = 1)),
CONSTRAINT UX_organization_inn UNIQUE (inn),
CONSTRAINT UX_organization_kpp UNIQUE (kpp),
INDEX IX_organization_phone (phone),
INDEX IX_organization_name (name),
INDEX IX_organization_address (address),
INDEX IX_organization_is_active (is_active)
);

DROP TABLE IF EXISTS office;
CREATE TABLE office (
id INT(11) COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(255) NOT NULL COMMENT 'Имя офиса',
address VARCHAR(255) NOT NULL  COMMENT 'Адрес офиса',
phone VARCHAR(255)  DEFAULT NULL COMMENT 'Телефон офиса',
org_id INT(11)  NOT NULL COMMENT 'Идентификатор организации',
is_active TINYINT(1) DEFAUlT 1 COMMENT 'Активен ли офис',
version INT(11)  DEFAULT 0 COMMENT 'Для оптимистичной блокировки',
INDEX IX_office_name (name),
INDEX IX_office_address (address),
INDEX IX_office_phone (phone),
CONSTRAINT CHK_office_is_active CHECK ((is_active = 0) OR (is_active = 1)),
INDEX IX_office_is_active (is_active),
INDEX FK_office_org_id_idx (org_id),
CONSTRAINT FK_office_org_id FOREIGN KEY (org_id) REFERENCES organization (id)
ON DELETE NO ACTION ON UPDATE NO ACTION
);

DROP TABLE IF EXISTS document;
CREATE TABLE document (
code VARCHAR(255) COMMENT 'Код документа' PRIMARY KEY,
name VARCHAR(255) COMMENT 'Название документа' NOT NULL,
UNIQUE INDEX UX_document_name (name)
);

DROP TABLE IF EXISTS country;
CREATE TABLE country (
code int(11) COMMENT 'Код страны' PRIMARY KEY,
name VARCHAR(255) COMMENT 'Название страны' NOT NULL,
UNIQUE INDEX UX_country_name (name)
);

DROP TABLE IF EXISTS user;
CREATE TABLE user (
id INT(11) COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
office_id INT(11) NOT NULL COMMENT 'Идентификатор офиса',
first_name VARCHAR(255) NOT NULL COMMENT 'Имя пользователя',
last_name VARCHAR(255) DEFAULT NULL COMMENT 'Фамилия пользователя',
middle_name VARCHAR(255) DEFAULT NULL COMMENT 'Второе личное имя пользователя',
position VARCHAR(255) NOT NULL COMMENT 'Должность',
phone VARCHAR(255) DEFAULT NULL COMMENT 'Телефон',
doc_code VARCHAR(255) DEFAULT NULL COMMENT 'Код документа',
doc_name VARCHAR(255) DEFAULT NULL COMMENT 'Название документа',
doc_number VARCHAR(255) DEFAULT NULL COMMENT 'Номер документа',
doc_date DATE DEFAULT NULL COMMENT 'Дата документа',
citizenship_code INT(11) DEFAULT NULL COMMENT 'Код гражданства',
is_identified TINYINT(1) DEFAULT 1 COMMENT 'Идентифицирован ли пользователь',
version INT(11) DEFAULT 0 COMMENT 'Для оптимистичной блокировки',
CONSTRAINT CHK_user_is_identified CHECK ((is_identified = 0) OR (is_identified = 1)),
INDEX IX_user_is_identified (is_identified),
INDEX FK_user_office_id_idx (office_id),
CONSTRAINT FK_user_office_id FOREIGN KEY (office_id) REFERENCES office (id)
ON DELETE NO ACTION ON UPDATE NO ACTION,
INDEX FK_user_doc_code_idx (doc_code),
CONSTRAINT FK_user_doc_code FOREIGN KEY (doc_code) REFERENCES document (code)
ON DELETE NO ACTION ON UPDATE NO ACTION,
INDEX FK_user_doc_name_idx (doc_name),
CONSTRAINT FK_user_doc_name FOREIGN KEY (doc_name) REFERENCES document (name)
ON DELETE NO ACTION ON UPDATE NO ACTION,
INDEX FK_user_citizenship_code_idx (citizenship_code),
CONSTRAINT FK_user_citizenship_code FOREIGN KEY (citizenship_code) REFERENCES country (code)
ON DELETE NO ACTION ON UPDATE NO ACTION,
INDEX IX_user_first_name (first_name),
INDEX IX_user_last_name (last_name),
INDEX IX_user_position (position),
INDEX IX_user_phone (phone),
INDEX IX_user_doc_number (doc_number)
);

SET FOREIGN_KEY_CHECKS=1;