package ResLog;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Resgiter {
    /*
             一，注册
     1，将注册信息放在xml文件中
     2，用户名只能是手机号或邮箱（正则表达式判断），不会写的网上搜
     3，密码要大于6位小于14位，一定要有大小写字母和数字
     4，用户名不能重复

           }
       //读取XMl
       public void XMLread(){
          SAXReader saxReader = new SAXReader();
       }
       //写入XMl
       public void XMlwrite(){

       }
              */


        //正则表达式验证手机号
        public static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|       (13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
        //正则表达式验证邮箱
        public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        // 密码的规范
        public static final  String REGEX_PASSWORD = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
        static SAXReader reader = new SAXReader();
        static Document document = null;

        public static void resgiter() throws Exception {
            Scanner input = new Scanner(System.in);

            Person person = new Person();
            zhuce: while (true) {
                System.out.println("请输入用户名,用户名为手机号或者邮箱");
                String username = input.nextLine();
                if (username.matches(Resgiter.REGEX_MOBILE) || username.matches                          (Resgiter.REGEX_EMAIL)) {
                    person.setUserName(username);
                    break zhuce;
                } else {
                    continue zhuce;
                }
            }
            System.out.println("请输入密码");
            String password = input.nextLine();
            mima: while (true) {
                System.out.println("密码格式不正确,请重新输入密码: 密码格式为包含字母和数字,长度在6-14");
                String password1 = input.nextLine();
                if (password1.matches(REGEX_PASSWORD) && password1.length() > 6 && password1.length() < 14) {
                    System.out.println("账号注册成功");
                    person.setPassWord(password1);
                    break mima;
                } else {
                    continue mima;
                }
            }
            System.out.println("请输入用户名");
            String name = input.nextLine();
            person.setName(name);
            document = reader.read(new File("src/ResgiterMessage.xml"));
            Resgiter.write(person);
        }

        //读取:
        public static void read(Document document) throws DocumentException {
            SAXReader saxReader = new SAXReader( );
            Document document1 = saxReader.read(new File("src/resginterMessage.xml"));
            Element rootElement = document1.getRootElement();
            Element person = rootElement.element("person");

            List<Person> userData= new ArrayList<>();
            Element element = rootElement.element("username");
            element.addAttribute("ueername","");
            Element element1 = rootElement.element("password");
            element1.addAttribute("password","");

        }
        //写入xml文件
        public static void  write(Person person) throws Exception {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(new File("src/ResgiterMessage.xml"));

            //XMl.read(document);

            //创建一个peroson标签
            Element rootElement = document.getRootElement();

            Element username1 = rootElement.addElement("username");

            username1.addAttribute("username", person.getUserName());
            username1.addAttribute("name",person.getName());

            Element password1 = rootElement.addElement("password");

            password1.addAttribute("password", person.getPassWord());

            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("utf-8");

            XMLWriter xmlWriter = new XMLWriter(new FileWriter("src/ResgiterMessage.xml"), format);
            xmlWriter.write(document);
            xmlWriter.close();
        }

    }
