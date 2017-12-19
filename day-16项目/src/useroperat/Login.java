package ResLog;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Login {

        static SAXReader reader = new SAXReader();
        static Document document = null;

        public static void  login() throws FileNotFoundException, DocumentException {

            Scanner input = new Scanner(System.in);

            while (true) {
                System.out.println("请输入账号");
                String username = input.nextLine();
                System.out.println("请输入密码");
                String password = input.nextLine();
                if (Person.map.get("username").equals(username) ) {
                    System.out.println("登录成功");
                    break;
                }else{
                    continue;
                }
            }
        }
        public static void put() throws FileNotFoundException, DocumentException {


            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(new File("src/ResgiterMessage.xml"));


            Element root = document.getRootElement(); //获取XML文档的根节点对象


            List<Element> list = root.elements();  //获取根节点下的所有的子节点

            for (Element ele : list) { //遍历根节点下的所有子节点并将其放入MAP对象中


               Person.map.put(ele.getName(), ele.getText());

            }
        }
    }

