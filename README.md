# ReadRoadData
카산드라에서 각 도로의 혼잡도 정보를 가져와서 보여주는 스프링 서버

데이터를 읽어오는 서버이므로 카산드라는 이미 실행 중이고, 데이터도 저장돼있다고 가정

## 이 프로젝트의 설정

카산드라 컨테이너 1개 (cassandra1)

keyspace : dsc2024, replication_factor: 1

table : road (road_id text primary key, road_name text, congestion_level text, std_date text, std_hour text)

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

### 사용법

실행 후 localhost:8082에 접속하면 웹 페이지가 로드됩니다.

검색란에 도로명을 입력하면 해당 문자열을 포함하는 도로들의 정보가 출력됩니다.

검색란에 all을 입력하면 저장된 모든 도로들의 정보가 출력됩니다.


