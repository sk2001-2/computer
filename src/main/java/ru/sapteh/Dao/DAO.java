package ru.sapteh.Dao;

import ru.sapteh.Model.Computer;

import java.security.Key;
import java.util.List;

public interface DAO<Entity, Key> {
    void create(Entity entity);
    Entity read(Key key);
    List<Entity> readByAll();
    void update(Entity entity);
    void delete(Entity entity);
}