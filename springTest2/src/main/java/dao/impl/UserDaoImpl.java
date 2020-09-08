package dao.impl;

        import dao.UserDAO;
import model.User;
import org.springframework.stereotype.Component;

        import javax.annotation.Resource;
        import javax.sql.DataSource;
        import java.sql.Connection;
        import java.sql.SQLException;

/**
 * @author 刘锌培
 * @date 2020/7/10 17:46
 */
@Component("u")   //扫描，发现Component，就存起来，key是UserDaoImpl，值就是这个的对象
public class UserDaoImpl implements UserDAO {
    private String DaoId;
    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }
    @Resource
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save(User user) {
        Connection conn=null;
        try {
            conn = dataSource.getConnection();
            conn.createStatement().executeUpdate("insert into test_user values (null,'zhangsan')");
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("User Saved");//假装这里是连接上数据库存储成功
       // throw  new RuntimeException("exception"){};//在这里抛出个异常

    }

    public void delete() {
        System.out.println("User delete");
    }

}
