import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.util.List;

/**刘锌培
 * @date 2020/7/13 15:54
 */
public class Sample1 {
    public static void main(String[] args){

        try {
            SAXBuilder sb = new SAXBuilder();
            Document doc = sb.build(Sample1.class.getClassLoader().getResourceAsStream("test.xml"));//构造文档对象
            Element root =doc.getRootElement();//获取根元素对象  test.xml获取hd标签
            List list =root.getChildren("disk");//获取名称未disk得所有元素
            for(int i=0;i<list.size();i++) {
                Element element = (Element) list.get(i);
                String name = element.getAttributeValue("name");
                String capacity = element.getChildText("capacity");//取disk子元素capacity的内容
                String directories = element.getChildText("directories");
                String files = element.getChildText("files");
                System.out.println("磁盘信息:");
                System.out.println("分区盘符:" + name);
                System.out.println("分区容量:" + capacity);
                System.out.println("目录数" + directories);
                System.out.println("文件数" + files);
                System.out.println("----------------------");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
