# Решение квадратного уравнения
## Задание
### 1 часть
Разработать SOAP сервис "Решение квадратного уравнения" вида A*X^2+B*X+C=0, через дискриминант
в запросе передаются переменные A, B, C, например:
<request><a>3</a><b>4</b><c>1</c></request>
в ответ сервис возвращает общий вид уравнения и найденные корни, например:
<response><formula>3x^2+4x+1=0</formula><D>0</D><x1>0</x1><x2>0</x2></response>
в случае если дискриминант меньше нуля создается исключение
у сервиса должно автоматически генерироваться описание в формате wsdl с xsd-схемами
в запросе элементы a,b,c - являются обязательными
в ответе элемент "x2" может отсутствовать если дискриминант равен 0
в случае исключения ответ с ошибкой должен содержать помимо сообщения об ошибке, элементы "formula, D"

### 2 часть
Разработать веб-сервис
который при обращении на url http://localhost:port/api/calc/?a=3&b=4&c=1
обращается к первому сервису за решением.
SOAP клиент для сервиса создается, используя контракт wsdl из сервиса в 1 части
ответ на запрос в формате JSON

### Требования к проектам:
1 проект = 2 модуля
maven/gradle
Java8+, любой сервер приложений WildFly, Tomcat, etc..
инструкция по сборке и запуску
плюсом будет:
наличие тестов, docker + docker-compose

## Решение
### Структура
- Модуль [quadratic-equation-soap](/quadratic-equation-soap) - реализация бизнес-логики, SOAP сервиса, unit-тесты
- Модуль [quadratic-equation-rest](/quadratic-equation-rest) - реализация REST сервиса
- Папка [/SoapUI](/SoapUI) - проект SoapUI для интеграционных тестов
- Папка [/Postman](/Postman) - проект Postman для интеграционных тестов
- Файл [docker-compose.yml](docker-compose.yml) - для сборки проекта в одном docker compose

### Сборка и запуск
1. Запустить сборку - `gradle build`
2. Запустить docker compose - `docker-compose up`
3. WSDL SOAP сервиса модуля 1 - http://localhost:50001/?wsdl
4. Endpoint REST сервиса модуля 2 http://localhost:50002/api/calc


