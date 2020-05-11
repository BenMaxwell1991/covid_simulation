curl -X POST ^ localhost:8080/getconfig ^
--data-binary @Config.json ^
--header "Content-Type: application/json"
pause