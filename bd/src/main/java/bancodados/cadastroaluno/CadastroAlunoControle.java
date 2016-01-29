package bancodados.cadastroaluno;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/SGAluno")
public class CadastroAlunoControle extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String paramMatricula = req.getParameter("matricula");
		String matricula = paramMatricula == null ? "" : paramMatricula;

		String paramNome = req.getParameter("nome");
		String nome = paramNome == null ? "" : paramNome;

		String paramFone = req.getParameter("fone");
		String fone = paramFone == null ? "" : paramFone;

		String paramCpf = req.getParameter("cpf");
		String cpf = paramCpf == null ? "" : paramCpf;

		String paramOp = req.getParameter("op");
		String op = paramOp == null ? "" : paramOp;

		Aluno aluno = new Aluno();
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		aluno.setFone(fone);
		aluno.setCpf(cpf);

		if (op.equals("Adicionar")) {
			if (!matricula.equals("")) {
				aluno.adicionar();
			}
		} else if (op.equals("Alterar")) {
			if (!matricula.equals("")) {
				aluno.alterar();
			}
		} else if (op.equals("Excluir")) {
			if (!matricula.equals("")) {
				aluno.excluir();
			}
		}

		req.setAttribute("aluno", aluno); // Passando um objeto para o JSP.

		List<Aluno> alunos = aluno.listar();
		req.setAttribute("alunos", alunos);
		
		// Chamar o JSP apenas para mostrar o resultado.
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}
