import org.scalatra._
import javax.servlet.ServletContext
import com.jarlakxen.tools.bookshelf.web.view.ViewsServlet
import com.jarlakxen.tools.bookshelf.web.rest._
import com.jarlakxen.tools.bookshelf.domain.mongo.MongoStore

class Scalatra extends LifeCycle {
	
	override def init(context: ServletContext) {
		
		// Main Page
		context.mount(new ViewsServlet, "/bookshelf/*")
		
		// REST Services
		context.mount(new ProjectServlet, "/bookshelf/rest/project/*")
		context.mount(new ModuleServlet, "/bookshelf/rest/module/*")
		context.mount(new PropertiesGroupServlet, "/bookshelf/rest/propertiesGroup/*")
		context.mount(new PropertyServlet, "/bookshelf/rest/property/*")
		context.mount(new EnviromentServlet, "/bookshelf/rest/enviroment/*")
		
		context.mount(new QueryServlet, "/bookshelf/query/*")
	}
}
