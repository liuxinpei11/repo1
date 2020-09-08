package aop;

/**
 * @author 刘锌培
 * @date 2020/7/17 17:56
 */
//public class LogInterceptor  implements InvocationHandler {
////    private Object target;//定义一个被代理的对象，比如说这里就是userDAO
////
////    public Object getTarget() {
////        return target;
////    }
////
////    public void setTarget(Object target) {
////        this.target = target;
////    }   //将userServiceTest的testProxy方法的定义的被代理的对象传过来
////
////    public void beforeMethod(){
////        System.out.println("save start.....");
////    }
//////调任何代理对象的方法的时候都会调用invoke这个方法
////
////    /***
////     *
////     * @param proxy  指代我们所代理的那个真实对象
////     * @param method 指代的是我们所要调用真实对象的某个方法的Method对象
////     * @param args 指代的是调用真实对象某个方法时接受的参数
////     * @return
////     * @throws Throwable
////     */
////    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
////        beforeMethod();
////        method.invoke(target,args);//传入被代理的对象，和参数
////        return null;
////    }
//}
