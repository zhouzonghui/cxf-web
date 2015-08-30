package org.zzh.cxf.hello;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface Hello {
	String sayHello(@WebParam(name="name") String name);
}
