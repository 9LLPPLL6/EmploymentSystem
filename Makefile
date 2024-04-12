
SUDO ?=

start:
	$(SUDO) docker-compose up --build
	@echo "backend service start"

restart:
	$(SUDO) docker-compose restart app

app-logs:
	$(SUDO) docker-compose logs -f app

mysql-logs:
	$(SUDO) docker-compose logs -f mysql

redis-logs:
	$(SUDO) docker-compose logs -f redis

#停止容器，但不删除容器
stop:
	$(SUDO) docker-compose stop

#停止所有容器并删除容器
down:
	$(SUDO) docker-compose down