package action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.zhuang.util.VerifyCode;
import org.apache.struts2.ServletActionContext;

public class CodeImgResult implements Result {
    @Override
    public void execute(ActionInvocation actionInvocation) throws Exception {
        VerifyCode.getInstance().output(ServletActionContext.getResponse().getOutputStream());
    }
}
