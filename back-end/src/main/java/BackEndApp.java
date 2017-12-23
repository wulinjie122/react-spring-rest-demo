import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;

public class BackEndApp {
  private static final Logger LOGGER = LoggerFactory.getLogger(BackEndApp.class);

  private BackEndApp() {
  }

  public static void main(String[] args) throws ServletException, LifecycleException {
    Tomcat tomcat = new Tomcat();
    tomcat.setPort(8080);
    tomcat.getConnector().setURIEncoding("UTF-8");
    String path = BackEndApp.class.getResource("/").getPath();
    tomcat.addWebapp("", path.substring(0, path.indexOf("target")) + "src/main/webapp");
    tomcat.start();
    LOGGER.info("Tomcat Started Success");
    tomcat.getServer().await();
  }

}
