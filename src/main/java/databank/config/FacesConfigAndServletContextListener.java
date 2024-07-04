
 
package databank.config;

import static javax.faces.application.ProjectStage.PROJECT_STAGE_PARAM_NAME;
import static javax.faces.application.ViewHandler.FACELETS_REFRESH_PERIOD_PARAM_NAME;
import static javax.faces.validator.BeanValidator.ENABLE_VALIDATE_WHOLE_BEAN_PARAM_NAME;

import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;
import javax.faces.application.ProjectStage;
import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.annotation.WebListener;

@FacesConfig(version = Version.JSF_2_3)
@WebListener
public class FacesConfigAndServletContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContextListener.super.contextInitialized(sce);
		ServletContext sc = sce.getServletContext();

		//Registering the JSF Servlet
		Dynamic facesServlet = sc.addServlet("Faces Servlet", FacesServlet.class.getName());
		//Specifying the Servlet Mapping
		facesServlet.addMapping("*.xhtml");
		//Setting Priority, 0 or higher for eager, if negative then it's lazy
		facesServlet.setLoadOnStartup(1);
		//Context parameters
		sc.setInitParameter(FACELETS_REFRESH_PERIOD_PARAM_NAME, "0");
		sc.setInitParameter(PROJECT_STAGE_PARAM_NAME, ProjectStage.Development.name());
		sc.setInitParameter(ENABLE_VALIDATE_WHOLE_BEAN_PARAM_NAME, Boolean.TRUE.toString());
	}
}
