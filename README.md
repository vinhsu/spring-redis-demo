# spring-redis-demo

1. $ redis-server

2. $ mvn spring-boot:run

3. Use Swagger to test
http://localhost:8083/swagger-ui.html#/ or use Postman http://localhost:8083/rest/users

4. Use redis-cli to find real hash key
$ redis-cli
127.0.0.1:6379> KEYS *
1) "\xac\xed\x00\x05t\x00\x04USER"

127.0.0.1:6379> HGETALL "\xac\xed\x00\x05t\x00\x04USER"
2) "\xac\xed\x00\x05sr\x00 com.majiku.redisdemo.models.Userr\xe2\xf0\x10\xab\xbeX\xb0\x02\x00\x03L\x00\x02idt\x00\x12Ljava/lang/String;L\x00\x04nameq\x00~\x00\x01L\x00\x05scoret\x00\x10Ljava/lang/Long;xpt\x00\x011t\x00\x04Kingsr\x00\x0ejava.lang.Long;\x8b\xe4\x90\xcc\x8f#\xdf\x02\x00\x01J\x00\x05valuexr\x00\x10java.lang.Number\x86\xac\x95\x1d\x0b\x94\xe0\x8b\x02\x00\x00xp\x00\x00\x00\x00\x00\x004\x8a