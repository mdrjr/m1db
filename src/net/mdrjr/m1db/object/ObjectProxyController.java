package net.mdrjr.m1db.object;

import java.io.Serializable;

public class ObjectProxyController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public Object proxyTo(Object obj) {
		Object ret = null;
			ProxyObject po = new ProxyObject();
			po.setObj(obj);
			ret = po;
		return ret;
	}
	
	public Object proxyBack(ProxyObject po) {
		Object ret = null;
			ret = po.getObj();
		return ret;
	}

	
	
}
