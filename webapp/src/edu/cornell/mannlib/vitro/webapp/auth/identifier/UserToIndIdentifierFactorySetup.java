/* $This file is distributed under the terms of the license in /doc/license.txt$ */

package edu.cornell.mannlib.vitro.webapp.auth.identifier;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.cornell.mannlib.vitro.webapp.servlet.setup.AbortStartup;

/**
 * Setups context so that Identifiers for Individuals associated with Users are
 * added to requests.
 * 
 * This only adds identifiers.  A self-editing policy is also needed.
 * 
 * @author bdc34
 *
 */
public class UserToIndIdentifierFactorySetup implements ServletContextListener{
	private static final Log log = LogFactory.getLog(UserToIndIdentifierFactorySetup.class.getName());
	
	public void contextInitialized(ServletContextEvent sce) {
	    
        if (AbortStartup.isStartupAborted(sce.getServletContext())) {
            return;
        }
	    
		ServletContext sc = sce.getServletContext();
		 ServletIdentifierBundleFactory
	     	.addIdentifierBundleFactory(sc, new UserToIndIdentifierFactory());
		 log.info("Set up Identifier Factory UserToIndIdentifierFactory.");		
	}
	
	public void contextDestroyed(ServletContextEvent arg0) {
	}	
}