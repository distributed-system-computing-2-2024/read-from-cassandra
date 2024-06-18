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

### 구글맵 API 설정
/src/main/resources에 api-key.properties 파일이 있어야 합니다.

해당 파일의 내용은 다음과 같습니다.
```
google.maps.api.key={API_KEY}
```
{API_KEY}는 자신의 api 키가 들어가야 합니다.
