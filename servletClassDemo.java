package GsonChanged;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class servletClassDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 定义一个ArrayList数据,长度为4
		ArrayList objs = new ArrayList(4);
		// 定义基本的response参数
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");

		// 创建一个Gson对象
		Gson gson = new Gson();
		// 创建一个results对象
		// 将results对象变为json格式
		results lb = new results("1", "李白", "北京", "诗仙");
		results lsm = new results("2", "李世民", "北京", "唐太宗");
		results zyz = new results("3", "朱元璋", "北京", "明太祖");
		results mzx = new results("4", "毛主席", "北京", "毛主席万岁");

		PrintWriter out = null;

		out = response.getWriter();
		if (request.getQueryString() == null) {
			objs.add(lb);
			objs.add(lsm);
			objs.add(zyz);
			objs.add(mzx);
		} else {

			if (request.getParameter("Name").equals("1")) {
				objs.add(lb);

			} else if (request.getParameter("Name").equals("2")) {
				objs.add(lsm);

			} else if (request.getParameter("Name").equals("3")) {
				objs.add(zyz);

			} else if (request.getParameter("Name").equals("4")) {
				objs.add(mzx);

			}
		}

		frame ff = new frame(1, 1, 1, objs);
		String jsonStr = gson.toJson(ff);
		out.write(jsonStr);

	}

}

// 定义一个results对象类
class results {

	results(String Name, String Person, String Place, String Content) {
		this.Title = Name;
		this.Person = Person;
		this.Place = Place;
		this.Content = Content;
	}

	// 定义第二层的json嵌套的字段变量
	private String Title;
	private String Person;
	private String Place;
	private String Content;
}

// 定义一个外层框架对象类
class frame {

	frame(int total, int Qtime, int page, ArrayList results) {
		this.total = total;
		this.Qtime = Qtime;
		this.page = page;
		this.results = results;
	}

	// 定义第一层的json嵌套的字段变量
	private int total;
	private int Qtime;
	private int page;
	private ArrayList results;
}
