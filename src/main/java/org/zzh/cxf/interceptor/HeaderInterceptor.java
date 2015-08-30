package org.zzh.cxf.interceptor;

import java.util.List;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
/**
 * 自定义in拦截器
 * @author Owner
 */
public class HeaderInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

	public HeaderInterceptor() {
		//服务器端in拦截器
		super(Phase.PRE_INVOKE);
	}

	public void handleMessage(SoapMessage msg) throws Fault {
		List<Header> headers = msg.getHeaders();
		
		if (headers == null || headers.size() < 1) {
			throw new Fault(new IllegalArgumentException("没有header参数，禁止调用！"));
		}
		
		Header firstHeader = headers.get(0);
		Element e = (Element) firstHeader.getObject();
		NodeList ids = e.getElementsByTagName("userid");
		NodeList passes = e.getElementsByTagName("pass");
		
		if (ids.getLength() != 1) {
			throw new Fault(new IllegalArgumentException("用户名格式不对！"));
		}
		
		if (ids.getLength() != 1) {
			throw new Fault(new IllegalArgumentException("密码格式不对！"));
		}
		
		String userid = ids.item(0).getTextContent();
		String pass = passes.item(0).getTextContent();
		
		//检测该用户名、密码是否被授权访问该服务
		if (!"zhou".equals(userid) || !"123".equals(pass)) {
			throw new Fault(new IllegalArgumentException("用户名、密码不正确！"));
		}
		
	}

}
