mvn clean install

docker build -t metricconverter

docker run -p 8090:8080 metricconverter

pause