package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("inter ");
		resp.sendRedirect("LoginView.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String login_id = req.getParameter("login_id");
		String password = req.getParameter("password");
		String op = req.getParameter("operation");
		System.out.println("inter ");

		if (op.equalsIgnoreCase("signIn")) {
			UserModel model = new UserModel();
			System.out.println("inter ");

			try {
				UserBean bean = model.authenticate(login_id, password);

				if (bean != null) {
					System.out.println("inter 3");
					req.setAttribute("user", bean);
					RequestDispatcher rd = req.getRequestDispatcher("WelcomeView.jsp");
					rd.forward(req, resp);
				} else {
					System.out.println("inter 2");
					req.setAttribute("error", "loginId & password invalid");
					RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
					rd.forward(req, resp);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		} else if (op.equalsIgnoreCase("signUp")) {
			resp.sendRedirect("UserRegistrationCtl");
			return;
		}
	}
}
