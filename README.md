# restAssured
Это мой проект, созданный в рамках обучения по курсу [Тестирование ПО: Автотесты для API с Java, REST Assured и TestNG](https://stepik.org/course/116286/).
Сервис запускался локально, поэтому опишу кратко запросы.

## GET
<details>
<summary>Получение информации о книгах</summary>

**Path URL:** /rest-api/books<br>
**Параметры:**
| Наименование<br>парметра | Описание |
|:-----:|:-----------:|
|from      | Позиция, с которой нужно начать. Значение по умолчанию: 0.|
|perPage   | Количество элементов на странице. Значение по умолчанию: 10. |
|title     | Фильтрует список книг по названию.|
|author    | Фильтрует список книг по имени автора.|
|priceLess | Фильтрует список книг по цене. Возвращает книги с ценой ниже значения.       |
|priceMore | Фильтрует список книг по цене. Возвращает книги с ценой больше, чем значение.    |
|countMore | Фильтрует список книг по количеству. Возвращает книги с количеством больше значения.     |
<br>

**Заголовки:** Content-type: application/json

**Тело запроса:** -

**Ответы:**
| Код ответа | Описание |Тело|
|:-----:|:-----------:|:-----:|
|200      | OK| {  "books": [    {      "author": "Mark Twain",      "category": "Adventures",      "count": 10,      "description": "The story about Tom Sawyer.",      "id": 0,      "lastUpdated": "2025-06-16T20:36:20.445Z",      "price": 250,      "title": "The Adventures of Tom Sawyer"    }  ],  "size": 0}
|400   | Bad Request |
|404     | Not Found|

</details>

<details>
<summary>Получение информации о книге по ID</summary>

**Path URL:** /rest-api/books/{id}<br>

**Заголовки:**
Content-type: application/json

**Тело запроса:** -

**Ответы:**
| Код ответа | Описание |Тело|
|:-----:|:-----------:|:-----:|
|200      | OK| {"id": 0, "title": "The Adventures of Tom Sawyer", "description": "The story about Tom Sawyer.", "author": "Mark Twain", "category": "Adventures", count": 10, "price": 250, "lastUpdated": "2022-09-05T17:40:33.563Z" }
|400   | Bad Request |
|404     | Not Found|

</details>

## POST
<details>
<summary>Добавление новой книги в каталог</summary>

**Path URL:** /rest-api/books<br>

**Заголовки:**
Content-type: application/json

**Тело запроса:**
{
  "author": "Mark Twain",
  "category": "Adventures",
  "count": 10,
  "description": "The story about Tom Sawyer.",
  "price": 250,
  "title": "The Adventures of Tom Sawyer"
}

**Ответы:**
| Код ответа | Описание |Тело|
|:-----:|:-----------:|:-----:|
|201      | Created| {"id": 0, "title": "The Adventures of Tom Sawyer", "description": "The story about Tom Sawyer.", "author": "Mark Twain", "category": "Adventures", count": 10, "price": 250, "lastUpdated": "2022-09-05T17:40:33.563Z" }
|400   | Bad Request |

</details>

## DELETE
<details>
<summary>Удаление всех книг из каталога</summary>

**Path URL:** /rest-api/books<br>

**Заголовки:**
Content-type: application/json

**Тело запроса:** -


**Ответы:**
| Код ответа | Описание |Тело|
|:-----:|:-----------:|:-----:|
|200     | OK|

</details>

<details>
<summary>Удаление книги из каталога по ID</summary>

**Path URL:** /rest-api/books/{id}<br>

**Заголовки:**
Content-type: application/json

**Тело запроса:** -

**Ответы:**
| Код ответа | Описание |
|:-----:|:-----------:|
|200      | OK| 
|400   | Bad Request |
|404     | Not Found|

</details>

## PUT
<details>
<summary>Обновление ифнормации о книге в каталоге</summary>

**Path URL:** /rest-api/books/{id}<br>

**Заголовки:**
Content-type: application/json

**Тело запроса:**
{
  "author": "Mark Twain",
  "category": "Adventures",
  "count": 10,
  "description": "The story about Tom Sawyer.",
  "price": 250,
  "title": "The Adventures of Tom Sawyer"
}


**Ответы:**
| Код ответа | Описание |Тело|
|:-----:|:-----------:|:-----:|
|200      | Created| {"id": 0, "title": "The Adventures of Tom Sawyer", "description": "The story about Tom Sawyer.", "author": "Mark Twain", "category": "Adventures", count": 10, "price": 250, "lastUpdated": "2022-09-05T17:40:33.563Z" }
|400   | Bad Request |
|404   | Not Found |

</details>

## Ограничения параметров книги
| Параметр | Тип данных|Обязательное поле |Описание |
|:-----:|:-----------:|:-----:|:-----:|
|title      | string| ДА |Название книги. Минимальная длина 3, максимальная длина 256.|
|description   | string |ДА|Short description. Min length 3, max length 512.|
|author   | string|ДА|Author of the book. Min length 3, max length 100.|
|category   | string |ДА||
|count   | integer |ДА||
|price   | integer |ДА||
