ls /secrets/oracle/config
ls /secrets/oracle/popp
export SPRING_DATASOURCE_URL=$(cat /secrets/oracle/config/jdbc_url)
export SPRING_DATASOURCE_USERNAME=$(cat /secrets/oracle/popp/username)
export SPRING_DATASOURCE_PASSWORD=$(cat /secrets/oracle/popp/password)