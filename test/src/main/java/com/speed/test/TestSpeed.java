package com.speed.test;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Iterator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TestSpeed {

	@RequestMapping(value="/testspeed")
	@ResponseBody
	public String method_0(HttpServletRequest request) throws ClassNotFoundException, SQLException{
		
	      String out = "<!DOCTYPE html>\n";
	      out += "<style>\n";
	      out += "table, th, td {\n";
	      out += "    border: 1px solid black;\n";
	      out += "}\n";
	      out += "</style>\n";
	      out += "<html>\n";
	      out += "<head>\n";
	      out += "<title> </title>\n";
	      out += "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n";
		  out += "<meta name=\"description\" content=\"\" />\n";
		  out += "<meta name=\"keywords\" content=\"\" />\n";
		  out += "<!--[if lte IE 8]><script src=\"css/ie/html5shiv.js\"></script><![endif]-->\n";
		  out += "<script src=\"js/jquery.min.js\"></script>\n";
		  out += "<script src=\"js/jquery.dropotron.min.js\"></script>\n";
		  out += "<script src=\"js/jquery.scrollgress.min.js\"></script>\n";
		  out += "<script src=\"js/jquery.scrolly.min.js\"></script>\n";
		  out += "<script src=\"js/jquery.slidertron.min.js\"></script>\n";
		  out += "<script src=\"js/skel.min.js\"></script>\n";
		  out += "<script src=\"js/skel-layers.min.js\"></script>\n";
		  out += "<script src=\"js/init.js\"></script>\n";
		  out += "<noscript>\n";
		  out += "<link rel=\"stylesheet\" href=\"css/skel.css\" />\n";
		  out += "<link rel=\"stylesheet\" href=\"css/style.css\" />\n";
		  out += "<link rel=\"stylesheet\" href=\"css/style-xlarge.css\" />\n";
		  out += "</noscript>\n";
		  out += "<!--[if lte IE 9]><link rel=\"stylesheet\" href=\"css/ie/v9.css\" /><![endif]-->\n";
		  out += "<!--[if lte IE 8]><link rel=\"stylesheet\" href=\"css/ie/v8.css\" /><![endif]-->\n";
		  out += "</head>\n";
		  out += "<body class=\"landing\">\n";
		  out += "<!-- Header -->\n";
		  out += "<header id=\"header\" class=\"alt skel-layers-fixed\">\n";
		  out += "<nav id=\"nav\">\n";
		  out += "<ul>\n";
		  out += "<li><a href=\"#\">Principal</a></li>\n";
		  out += "<li>\n";
		  out += "<a href=\"\" class=\"icon fa-angle-down\">Opções</a>\n";
		  out += "<ul>\n";
		  out += "<li><a href=\"#banner\">SpeedTest timestamp</a></li>\n";
		  out += "<li><a href=\"#banner_serverid\">SpeedTest serverid</a></li>\n";
		  out += "<li><a href=\"#banner_sponsor\">SpeedTest sponsor</a></li>\n";
		  out += "<li><a href=\"#banner_servername\">SpeedTest servername</a></li>\n";
		  out += "</ul>\n";
		  out += "</li>\n";
		  out += "</ul>\n";
		  out += "</nav>\n";
		  out += "</header>\n";
		  
		  //String SSH_CONNECTION = System.getenv("SSH_CONNECTION");
		  //out += "SSH_CONNECTION = " + SSH_CONNECTION + "\n";

		  //Teste SQLITE
			String driver = "org.sqlite.JDBC";
			Class.forName(driver);
			String dbName = "/mnt/amploviewDATA/cp2.db"; 
			String dbUrl = "jdbc:sqlite:" + dbName;
			Connection conn = DriverManager.getConnection(dbUrl);
	        //create table 
	        Statement st = conn.createStatement();
	        st.executeUpdate("CREATE table village (id int, name varchar(20))");
	        //insert row
	        st.executeUpdate("INSERT INTO village VALUES (111, 'Concretepage')");
	        //select
	        String query = "SELECT id, name from village";
	        ResultSet rs = null;
	        rs = st.executeQuery(query);
	        while(rs.next()) {
	           int id = rs.getInt(1);
	           String name = rs.getString(2);
	           System.out.println("id:"+ id+ ", name: "+ name);
	         }
	         //delete
	         st.executeUpdate("DELETE from village");
		     rs.close();
			  //Teste SQLITE
		  
		  
			String ip = request.getHeader("X-Forwarded-For");
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("Proxy-Client-IP");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("WL-Proxy-Client-IP");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("HTTP_CLIENT_IP");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getRemoteAddr();
	        }

          out += "IP = " + ip + "\n";
		  
		  out += "<!-- Banner -->\n";
		  out += "<section id=\"banner\">\n";
		  out += "<div class=\"inner\">\n";
		  out += "<h1>Teste hello world amploview</h1>\n";
		  out += "<h2>Teste hello world amploview</h2>\n";
		  out += "<h3>Teste hello world amploview</h3>\n";
          out += "</div>\n";
          out += "</section>\n";
          out += "</body>\n";
	      out += "</html>\n";
	      
	      System.out.println(out);

	      return out;
	}
	
private String split(String string, char c) {
		// TODO Auto-generated method stub
		return null;
	}

/*	
	@RequestMapping(value="/testspeed")
	@ResponseBody
	public String method_0(){
		
	      // Creating a Mongo client 
	      MongoClient mongo = new MongoClient();

	      // Accessing the database 
	      MongoDatabase database = mongo.getDatabase("test");  
	      
	      // Retrieving a collection 
	      MongoCollection<Document> collection = database.getCollection("speedTest");
	      System.out.println("Collection sampleCollection selected successfully"); 
	      
	      // Getting the iterable object 
	      FindIterable<Document> iterDoc = collection.find().limit(10).sort(new Document("timestamp", -1)); 
	
	      String out = "<!DOCTYPE html>";
	      out += "<html>";
	      out += "<head>";
	      out += "<style>";
	      out += "table, th, td {";
	      out += "    border: 1px solid black;";
	      out += "}";
	      out += "</style>";
	      out += "<table>";
	      out += "<th>";
	      out += "<h4>/testspeed ::</h4>";
	      out += "</th>";
	      out += "</table>";
	      out += "</head>";
	      out += "<body>";
	      
	      out += "<br>";
	      out += "<table>";

	      out += "<tr>";
	      out += "<th>";
    	  out += ("serverid");
	      out += "</th>";
	      out += "<th>";
    	  out += ("sponsor");
	      out += "</th>";
	      out += "<th>";
    	  out += ("servername");
	      out += "</th>";
	      out += "<th>";
    	  out += ("timestamp");
	      out += "</th>";
	      //out += "<th>";
    	  //out += ("distance");
	      //out += "</th>";
	      //out += "<th>";
    	  //out += ("ping");
	      //out += "</th>";
	      out += "<th>";
    	  out += ("download");
	      out += "</th>";
	      out += "<th>";
    	  out += ("upload");
	      out += "</th>";
	      //out += "<th>";
    	  //out += ("share");
	      //out += "</th>";
	      //out += "<th>";
    	  //out += ("ipaddress");
	      //out += "</th>";
	      //out += "<th>";
    	  //out += ("_links/self/href");
	      //out += "</th>";
    	  out += "</tr>";
    	  
          for (Document doc : iterDoc) {
    	      
    	      out += "<tr>";
    	      out += "<td>";
        	  out += (doc.getString("serverid"));
    	      out += "</td>";
    	      out += "<td>";
        	  out += (doc.getString("sponsor"));
    	      out += "</td>";
    	      out += "<td>";
        	  out += (doc.getString("servername"));
    	      out += "</td>";
    	      out += "<td>";
        	  out += (doc.getString("timestamp").substring(0,19));
    	      out += "</td>";
    	      //out += "<td>";
        	  //out += (doc.getString("distance"));
    	      //out += "</td>";
    	      //out += "<td>";
        	  //out += (doc.getString("ping"));
    	      //out += "</td>";
    	      out += "<td>";
        	  out += (doc.getString("download").substring(0,2));
    	      out += "</td>";
    	      out += "<td>";
        	  out += (doc.getString("upload").substring(0,2));
    	      out += "</td>";
    	      //out += "<td>";
        	  //out += (doc.getString("share"));
    	      //out += "</td>";
    	      //out += "<td>";
        	  //out += (doc.getString("ipaddress"));
    	      //out += "</td>";
    	      //out += "<td>";
        	  //out += (doc.getString("_links/self/href"));
    	      //out += "</td>";
        	  out += "</tr>";
	      }

          out += "</table>";
	      out += "</body>";
	      out += "</html>";
	      
	      mongo.close();

	      return out;
	}
*/
	
/*	
	@RequestMapping(value = "/testspeed", method = RequestMethod.GET)
	public String method_5(@RequestParam("serverid") int serverid) {
		return "/testspeed :: "+serverid;
	}
	
	@RequestMapping(value="serverid={serverid}")
	@ResponseBody
	public String method_4(@PathVariable("serverid") int serverid){
		return "serverid={serverid} :: "+serverid;
	}
*/	
}
