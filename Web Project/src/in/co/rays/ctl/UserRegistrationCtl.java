package in.co.rays.ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/UserRegistrationCtl")
public class UserRegistrationCtl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("in UserRegistrationCtl doGet");
        resp.sendRedirect("UserRegistrationView.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String login = req.getParameter("loginId");
        String password = req.getParameter("password");
        String date = req.getParameter("dob");
        String address = req.getParameter("adddress");

        UserBean bean = new UserBean();
        try {
            bean.setFirstName(firstName);
            bean.setLastName(lastName);
            bean.setLogin_id(login);
            bean.setPassword(password);
            bean.setDob(sdf.parse(date));
            bean.setAddress(address);
        } catch (Exception e) {
            e.printStackTrace();
        }

        UserModel model = new UserModel();
        try {
             model.add(bean);
             req.setAttribute("success","user added successfully..!!");
        } catch (Exception e) {
            e.printStackTrace();
             req.setAttribute("error","login Id already exist");
        }

        RequestDispatcher rd = req.getRequestDispatcher("UserRegistrationView.jsp");
        rd.forward(req, resp);
    }
}
