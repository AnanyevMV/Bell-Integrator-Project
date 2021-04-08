-- Организации
INSERT INTO organization (name, full_name, inn, kpp, address,phone)
VALUES ('Рога и копыта', 'ООО "Рога и копыта"', '1122334455', '111222333', 'г. Москва, ул. Ленина, д. 1', '+71234567890');

INSERT INTO organization (name, full_name, inn, kpp, address,phone)
VALUES ('Парикмахерская "Светлана"', 'ИП Светлана Сидорова', '223344556677', '666777888', 'г. Владимир, ул. Пушкина, д. 2', '+74564567809');

INSERT INTO organization (name, full_name, inn, kpp, address,phone)
VALUES ('ТРАНССИБСТАЛЬМАШ', 'ЗАО "ТРАНССИБСТАЛЬМАШ"', '3344556677', '333444555', 'г. Челябинск, ул. Советская, д. 3', '+79874568725');

-- Страны
INSERT INTO country (code,name) VALUES (643, 'Российская Федерация');
INSERT INTO country (code,name) VALUES (804, 'Украина');
INSERT INTO country (code,name) VALUES (112, 'Республика Беларусь');
INSERT INTO country (code,name) VALUES (398, 'Казахстан');

-- Типы документов
INSERT INTO document_type (doc_code, doc_name) VALUES ('03', 'Свидетельство о рождении');
INSERT INTO document_type (doc_code, doc_name) VALUES ('07', 'Военный билет');
INSERT INTO document_type (doc_code, doc_name) VALUES ('08', 'Временное удостоверение, выданное взамен военного билета');
INSERT INTO document_type (doc_code, doc_name) VALUES ('10', 'Паспорт иностранного гражданина');
INSERT INTO document_type (doc_code, doc_name) VALUES ('11', 'Свидетельство о рассмотрении ходатайства о признании лица беженцем на территории Российской Федерации по существу');
INSERT INTO document_type (doc_code, doc_name) VALUES ('12', 'Вид на жительство в Российской Федерации');
INSERT INTO document_type (doc_code, doc_name) VALUES ('13', 'Удостоверение беженца');
INSERT INTO document_type (doc_code, doc_name) VALUES ('15', 'Разрешение на временное проживание в Российской Федерации');
INSERT INTO document_type (doc_code, doc_name) VALUES ('18', 'Свидетельство о предоставлении временного убежища на территории Российской Федерации');
INSERT INTO document_type (doc_code, doc_name) VALUES ('21', 'Паспорт гражданина Российской Федерации');
INSERT INTO document_type (doc_code, doc_name) VALUES ('23', 'Свидетельство о рождении, выданное уполномоченным органом иностранного государства');
INSERT INTO document_type (doc_code, doc_name) VALUES ('24', 'Удостоверение личности военнослужащего Российской Федерации');
INSERT INTO document_type (doc_code, doc_name) VALUES ('91', 'Иные документы');

-- Документы
INSERT INTO document (doc_code, doc_number, doc_date) VALUES
(21, 1234567890, parseDateTime('20200101000000','yyyyMMddHHmmss'));
INSERT INTO document (doc_code, doc_number, doc_date) VALUES
(21, 1234567809, parseDateTime('20200303000000','yyyyMMddHHmmss'));
INSERT INTO document (doc_code, doc_number, doc_date) VALUES
(10, 123454321, parseDateTime('20190525000000','yyyyMMddHHmmss'));
INSERT INTO document (doc_code, doc_number, doc_date) VALUES
(13, 1234567895, parseDateTime('20180713000000','yyyyMMddHHmmss'));
INSERT INTO document (doc_code, doc_number, doc_date) VALUES
(21, 1234658791, parseDateTime('20160305000000','yyyyMMddHHmmss'));
INSERT INTO document (doc_code, doc_number, doc_date) VALUES
(10, 1132435465, parseDateTime('20190405000000','yyyyMMddHHmmss'));

-- Офисы
INSERT INTO office (name, address, phone, org_id) VALUES ('Главный офис', 'г. Москва, ул. Ленина, д. 1', '+71234567890', 1);
INSERT INTO office (name, address, phone, org_id) VALUES ('Офис №2', 'г. Москва, ул. Ленина, д. 2', '+71234567899', 1);
INSERT INTO office (name, address, phone, org_id) VALUES ('Салон красоты', 'г. Владимир, ул. Пушкина, д. 2', '+74564567809', 2);
INSERT INTO office (name, address, phone, org_id) VALUES ('Центральный офис', 'г. Челябинск, ул. Советская, д. 3', '+79874568725', 3);
INSERT INTO office (name, address, phone, org_id) VALUES ('Офис #2', 'г. Челябинск, ул. Советская, д. 6', '+79874568746', 3);
INSERT INTO office (name, address, phone, org_id) VALUES ('Склад', 'г. Челябинск, ул. Советская, д. 12', '+79874568784', 3);

-- Пользователи
INSERT INTO user (office_id, first_name,last_name,position,phone,doc_code,doc_number,citizenship_code)
VALUES (1,'Иван', 'Кузнецов', 'Директор', '+73456789023','21','1234567890',643);
INSERT INTO user (office_id, first_name,last_name,position,phone,doc_code,doc_number,citizenship_code)
VALUES (2,'Пётр', 'Смирнов', 'Зам. директора', '+73456789065','21','1234567809',643);
INSERT INTO user (office_id, first_name,last_name,position,phone,doc_code,doc_number,citizenship_code)
VALUES (3,'Светлана', 'Сидорова', 'Парикмахер', '+74564567809','10','123454321',112);
INSERT INTO user (office_id, first_name,last_name,position,phone,doc_code,doc_number,citizenship_code)
VALUES (4,'Виктор', 'Белых', 'Директор', '+79874568725','13','1234567895',804);
INSERT INTO user (office_id, first_name,last_name,position,phone,doc_code,doc_number,citizenship_code)
VALUES (5,'Дмитрий', 'Пчелов', 'Зам. директора', '+73456787892','21','1234658791',643);
INSERT INTO user (office_id, first_name,last_name,position,phone,doc_code,doc_number,citizenship_code)
VALUES (6,'Роман', 'Балашов', 'Управляющий складом', '+73456785673','10','1132435465',398);
