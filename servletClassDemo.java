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
		// ����һ��ArrayList����,����Ϊ4
		ArrayList objs = new ArrayList(4);
		// ���������response����
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");

		// ����һ��Gson����
		Gson gson = new Gson();
		// ����һ��results����
		// ��results�����Ϊjson��ʽ
		results lb = new results("1", "���", "����", "ʫ��");
		results lsm = new results("2", "������", "����", "��̫��");
		results zyz = new results("3", "��Ԫ�", "����", "��̫��");
		results mzx = new results("4", "ë��ϯ", "����", "ë��ϯ����");

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

// ����һ��results������
class results {

	results(String Name, String Person, String Place, String Content) {
		this.Title = Name;
		this.Person = Person;
		this.Place = Place;
		this.Content = Content;
	}

	// ����ڶ����jsonǶ�׵��ֶα���
	private String Title;
	private String Person;
	private String Place;
	private String Content;
}

// ����һ������ܶ�����
class frame {

	frame(int total, int Qtime, int page, ArrayList results) {
		this.total = total;
		this.Qtime = Qtime;
		this.page = page;
		this.results = results;
	}

	// �����һ���jsonǶ�׵��ֶα���
	private int total;
	private int Qtime;
	private int page;
	private ArrayList results;
}
