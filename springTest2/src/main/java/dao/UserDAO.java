package dao;

        import model.User;

/**
 * @author 刘锌培
 * @date 2020/7/10 17:38
 */
public interface UserDAO {
    public void save(User user);
    public void delete();
}