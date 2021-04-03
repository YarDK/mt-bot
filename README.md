Для запуска на новой машине:

На машине должны быть установлены:
- JRE (Рекомендуется Version 8 Update 27)
- Maven

Шаги:
1) Клонировать репозиторий
2) В корне проекта выполнить команду "mvn test -Denvironment={среда}"

Поддерживаемые среды: pres, prod, dev.

Для настройки переменных середы нужно внести изменения в соответствующий файл 
в папке \src\main\resources

Running a Single Test
mvn -Dtest=TestCircle test

Запуск testng.xml с заданной средой
mvn test -Denvironment=pres