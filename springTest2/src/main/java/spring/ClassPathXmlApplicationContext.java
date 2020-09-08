    package spring;

    import org.jdom2.Document;
    import org.jdom2.Element;
    import org.jdom2.input.SAXBuilder;

    import java.lang.reflect.Method;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    /**
     * @author 刘锌培
     * @date 2020/7/13 17:55
     */
    public class ClassPathXmlApplicationContext implements BeanFactory{
        private Map<String,Object> beans = new HashMap<String, Object>();

        public ClassPathXmlApplicationContext() throws Exception{
            SAXBuilder sb =  new SAXBuilder();
            Document doc = sb.build(this.getClass().getClassLoader().getResourceAsStream("beans.xml"));
            Element root = doc.getRootElement();//获取根元素
            List list = root.getChildren("bean");
            for(int i=0;i<list.size();i++){
                Element element = (Element) list.get(i);
                String id = element.getAttributeValue("id");
                String clazz = element.getAttributeValue("class");
                System.out.println(id+":"+clazz);
                Object o = Class.forName(clazz).newInstance();  //获取类得实例 UserService
                beans.put(id,o);
                for (Element propertyElement: (List<Element>) element.getChildren("property")){
                        String name = propertyElement.getAttributeValue("name");//userDAO
                        String bean = propertyElement.getAttributeValue("bean"); //u
                        Object beanObject = beans.get(bean); //UserDAOImp1 instance
                        String methodName = "set"+name.substring(0,1).toUpperCase()+name.substring(1);
                        System.out.println(methodName+"methodNameddddddddd");
                    /***
                     * Method method = ownerClass.getMethod(methodName, argsClass)：通过methodName和参数的
                     * argsClass（方法中的参数类型集合）数组得到要执行的Method
                     * beanObject.getClass().getInterfaces()[1] 就是UserDAOImp1.class只实现了一个接口UserDAO
                     *  private UserDAO userDAO = new UserDaoImpl() 要拿到userDAO的class就beanObject.getClass().getInterfaces()[1]
                     */

                        Method method = o.getClass().getMethod(methodName,beanObject.getClass().getInterfaces()[0]);
                        /***
                         * method.invoke(owner, args)：执行该Method.invoke方法的参数是执行这个方法的对象owner，和参数数组
                         * args，可以这么理解：owner对象中带有参数args的method方法。返回值是Object，也既是该方法的返回值
                         */

                        method.invoke(o,beanObject);
                }

            }


        }

        public Object getBean(String name) {
            return beans.get(name);
        }
    }
