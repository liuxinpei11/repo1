package aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author 刘锌培
 * @date 2020/7/20 14:37
 * Aspect 把这个逻辑（method start）织入到原方法里面去
 * Before得意思是再方法执行之前，先执行自定义得before方法
 * Component 如果不加这个的话扫描，发现Component，就存起来，LogInterceptor1，值就是这个的对象
 * 初始化这个LogInterceptor1类将LogInterceptor1和UserDaoImpl联系起来
 */
//@Aspect
//@Component
public class LogInterceptor1 {
    //每个方法都要写public * dao..*.*(..)非常麻烦
    //public * dao..*.*(..)) dao下面的任意类的任意方法，返回参数也是任意类型
   // @Pointcut("execution(public * userService..*.add(..))")
    public void myMethod(){}//用方法来命名public * dao..*.*(..))

    //@Before("myMethod()")
    public void before(){
        System.out.println("method start");
    }
    //@Around("myMethod()")
    public void aroundMethod(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("method around start");
        pjp.proceed();
        System.out.println("method around end");
    }

}


