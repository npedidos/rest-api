docker-compose exec mysqldb sh -c 'mysqldump -uroot -p$MYSQL_ROOT_PASSWORD --routines --triggers --no-create-info $MYSQL_DATABASE' > ./npedidos-seeddata-$(date '+%Y-%m-%d').sql
