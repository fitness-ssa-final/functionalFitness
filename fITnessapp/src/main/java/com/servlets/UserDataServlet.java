import java.io.IOException;
    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;

    import com.DAO;
    import com.User;
            //^add the project name

    /**
     * Servlet implementation class addToDB
     */
    @WebServlet("/addToDB")
    public class addToDB extends HttpServlet {
        private static final long serialVersionUID = 1L;
           
        /**
         * @see HttpServlet#HttpServlet()
         */
        public addToDB() {
            super();
            // TODO Auto-generated constructor stub
        }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // TODO Auto-generated method stub
            response.getWriter().append("Served at: ").append(request.getContextPath());
        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
            User addTodb = new User();
            
            addTodb.setLastName(request.getParameter("lastName"));
            addTodb.setFirstName(request.getParameter("firstName"));
            // input rest of fields
            
            System.out.println(addTodb.toString());
            
            DAO.writeToDB(addTodb);
            
            request.getRequestDispatcher(".jsp").forward(request, response);
                                        //^make sure to add the project jsp
        }

    }
