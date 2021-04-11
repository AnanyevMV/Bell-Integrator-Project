/**
 * Пакет для маппинга между entity и dto<br>
 * Всего в пакете следующие мапперы, реализующие интерфейс Mapper:<br>
 * CountryMapper - для стран<br>
 * DocumentTypeMapper - для типов документов<br>
 * OfficeMapper - для офисов<br>
 * OrganizationMapper - для организаций<br>
 * UserMapper - для пользователей<br><br>
 *
 * Все мапперы помечены аннотацией @Component<br>
 * Мапперы используют библиотеку org.modelmapper<br>
 * В некоторых мапперах используются кастомные настройки для маппинга с преобразованиями типов<br>
 * и для обработки нетривиальных ситуациях<br>
 */
package ru.bellintegrator.dto.mapper;