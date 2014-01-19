package wad.elokuva.database;

public interface DAO<T> {
    public void create(T instance);
    public T read(int id);
    public T update(T instance);
    public void delete(T instance);
}
