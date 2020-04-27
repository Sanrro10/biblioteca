package es.deusto.spq.client.remote;

import java.io.IOException;
import java.rmi.Naming;

import es.deusto.spq.server.remote.IRemoteFacade;
import es.deusto.spq.client.data.GetPropertyValues;

public class ServiceLocator {
	
	private IRemoteFacade service;

	public void setService() {
		GetPropertyValues properties = new GetPropertyValues();
		String url = "";
		
		try {
			url = properties.getURL();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		try {		
			this.service = (IRemoteFacade) Naming.lookup(url);
		} catch (Exception ex) {
			System.err.println("# Error locating remote facade: " + ex);
		}		
	}

	public IRemoteFacade getService() {
		return this.service;
	}
	
}