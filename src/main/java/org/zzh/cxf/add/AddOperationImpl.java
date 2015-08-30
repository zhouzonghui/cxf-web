package org.zzh.cxf.add;

import javax.jws.WebService;

@WebService(endpointInterface="org.zzh.cxf.add.AddOperation", serviceName="AddOperation")
public class AddOperationImpl implements AddOperation {

	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}

}
