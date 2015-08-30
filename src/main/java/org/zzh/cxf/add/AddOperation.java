package org.zzh.cxf.add;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface AddOperation {
	int add(@WebParam(name="a") int a, @WebParam(name="b") int b);
}
