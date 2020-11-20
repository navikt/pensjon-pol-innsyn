echo "Checking mounted folders "
mount
echo "Listing files in database config"
ls /secrets/oracle/config
echo "Listing files in database credentials"
ls /secrets/oracle/popp
echo "Exporting secrets"
export SPRING_DATASOURCE_URL=$(cat /secrets/oracle/config/jdbc_url)
export SPRING_DATASOURCE_USERNAME=$(cat /secrets/oracle/popp/username)
export SPRING_DATASOURCE_PASSWORD=$(cat /secrets/oracle/popp/password)