# ReadRoadData
카산드라에서 각 도로의 혼잡도 정보를 가져와서 보여주는 스프링 서버

데이터를 읽어오는 서버이므로 카산드라는 이미 실행 중이고, 데이터도 저장돼있다고 가정

## 이 프로젝트의 설정

카산드라 컨테이너 1개 (cassandra1)

keyspace : dsc2024, replication_factor: 1

table : road (roadname text primary key, congestionlevel text)

```
git clone https://github.com/distributed-system-computing-2-2024/read-from-cassandra.git
cd read-from-cassandra
```

아래 명령어는 Docker 실행 및 로그인 돼있다고 가정

## Windows

```
gradlew build
docker-compose up -d
```

## Mac

```
./gradlew build
sudo docker-compose up -d
```

### 카산드라에 키스페이스 없을 때

cassandra1의 exec에 다음 입력

```
cqlsh

create keyspace dsc2024 with replication = {'class':'SimpleStrategy', 'replication_factor':1};
```

데이터 저장하려면

```
use dsc2024;
insert into road (oadname, congestionlevel) values (~~, ~~);
```
