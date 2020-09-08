package userService;

        import dao.UserDAO;
        import dao.impl.UserDaoImpl;
        import model.User;
        import org.springframework.stereotype.Component;

        import javax.annotation.PostConstruct;
        import javax.annotation.PreDestroy;
        import javax.annotation.Resource;

/**
 * @author 刘锌培
 * @date 2020/7/10 17:33
 */
@Component("userService")
public class UserService{

    private UserDAO userDAO = new UserDaoImpl();

    @PostConstruct  //构造完成之后
    public void init(){
        System.out.println("init");
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
    @Resource(name = "u")
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    public void add(User u){
        this.userDAO.save(u);
    }
    @PreDestroy  //容器销毁之前
    public void destory(){
        System.out.println("destory");
    }

}
