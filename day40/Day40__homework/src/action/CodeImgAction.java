package action;

import com.opensymphony.xwork2.ActionSupport;
import com.zhuang.util.VerifyCode;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;

public class CodeImgAction extends ActionSupport{


    public  String codeImg() throws IOException {



      //  System.out.println(output);
        return SUCCESS;
    }



    @Override
    public String execute() throws Exception {
      //  System.out.println("111");
        String output =  VerifyCode.getInstance().output(ServletActionContext.getResponse().getOutputStream());
        ServletActionContext.getRequest().setAttribute("code",output);
        return super.execute();
    }
}
