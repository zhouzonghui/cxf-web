package org.zzh.cxf.hello;

import javax.jws.WebService;

@WebService(endpointInterface="org.zzh.cxf.hello.Hello", serviceName="Hello")
public class HelloImpl implements Hello {
	
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		if ("".equals(name.trim())) {
			return "调用错误，姓名不能为空！";
		}
		return "你好，" + name + "。";
	}

}
