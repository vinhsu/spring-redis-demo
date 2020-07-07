package com.majiku.redisdemo.repository;

import com.majiku.redisdemo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final RedisTemplate<String, User> redisTemplate;
    private final HashOperations hashOperations;
    private final static String KEY_USER = "USER";

    @Autowired
    public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(User user) {
        hashOperations.put(KEY_USER, user.getId(), user);
    }

    @Override
    public Map<String, User> findAll() {
        return hashOperations.entries(KEY_USER);
    }

    @Override
    public User findById(String id) {
        return (User) hashOperations.get(KEY_USER, id);
    }

    @Override
    public void update(User user) {
        save(user);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete(KEY_USER, id);
    }
}
