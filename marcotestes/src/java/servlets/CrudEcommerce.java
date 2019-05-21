package servlets;

import controle.DAO.UsuarioDao;
import controle.VO.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 80119050
 */
public class CrudEcommerce extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");

        String var1 = request.getParameter("cadastrar");
        String var2 = request.getParameter("excluir");
        //String cpf = request.getParameter("cpfpaciente");

        //System.out.println("O cpf é: " + cpf);

        ArrayList<String> variavel = new ArrayList<String>();
        variavel.add(var1);
        variavel.add(var2);
        System.out.println("O array é: " + variavel);

        Usuario usuario = null;

        for (int i = 0; i < variavel.size(); i++) {
            String var = variavel.get(i);

            if (var != null) {
                switch (var) {
                    case "cadastrar":

                     //   System.out.println("A variável é: " + variavel.get(i));
                        usuario = new Usuario();
                        usuario.setLogin(request.getParameter("login"));
                        usuario.setSenha(request.getParameter("senha"));                        

                        System.out.println(usuario);

                        UsuarioDao usuarioDao= new UsuarioDao();

                        int novoId = usuarioDao.cadastrarUsuario(usuario);

                        if (novoId > 0) {

//                            request.setAttribute("codigousario", novoId);
//                            request.setAttribute("codigoseguranca", );
//                            request.setAttribute("datavalidade", );
//                            request.setAttribute("login", );
//                            request.setAttribute("numerocartao", );
//                            request.setAttribute("senha", );
                            
                           //request.getRequestDispatcher("Paciente/MostrarPacienteCadastrado.jsp").forward(request, response);
                            System.out.println("O identificador do novo usuário é: " +novoId);
                        }
                        break;

//                    case "validar":
//                       
//                        
//                        if (pacienteController.excluirPacientePorCpf(pacienteVO.getCpfPaciente())) {
//
//                            request.setAttribute("cpfpaciente", pacienteVO.getCpfPaciente());
//                            request.getRequestDispatcher("Paciente/MostrarPacienteExcluido.jsp").forward(request, response);
//                        }
//
//                        break;
                    default:
                        request.getRequestDispatcher("crud").forward(request, response);
                        break;

                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
