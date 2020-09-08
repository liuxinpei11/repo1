package userService;

import model.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * ${description}
 *
 * @author 刘锌培
 * @date 2020/7/13 16:54
 */
public class UserServiceTest {

    @Test
    public void add() throws Exception {

        //  UserService userService = new UserService();

        // BeanFactory applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.add(new User());
        ctx.destroy();

    }

//    @Test
//    public void testProxy(){
//    //定义被代理的对象,将这个userDAO交给
//        UserDAO userDAO = new UserDaoImpl();
//        LogInterceptor li = new LogInterceptor();//将被代理对象射入进去
//        //根据被代理对象产生代理，调用Proxy这个类的静态方法
//        //用哪个classloader去产生被代理对象
//        //产生的被代理对象应该实现哪个接口
//        //当我产生代理之后调用代理里面的方法的时候，用哪个handler进行处理
//        //返回值就是产生的代理对象
//        /***
//         * ClassLoader loader:一个ClassLoader对象，定义了由哪个ClassLoader对象来对生成的代理对象进行加载
//         * Class<?>[] interfaces:一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法
//         * InvocationHandler h:一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上
//         */
//        li.setTarget(userDAO);
//        UserDAO userDAOProxy = (UserDAO) Proxy.newProxyInstance(userDAO.getClass().getClassLoader(),userDAO.getClass().getInterfaces(),li);
//        userDAOProxy.save(new User());
//        userDAOProxy.delete();
//    }

}