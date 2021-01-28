package co.hj.board.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.hj.board.web.BoardDelete;
import co.hj.board.web.BoardEditForm;
import co.hj.board.web.BoardEditSave;
import co.hj.board.web.BoardInsert;
import co.hj.board.web.BoardInsertForm;
import co.hj.board.web.BoardList;
import co.hj.board.web.BoardView;
import co.hj.board.web.MainCommand;



public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand());
		map.put("/boardList.do", new BoardList());				//게시판 목록
		map.put("/boardInsertForm.do", new BoardInsertForm());	//글 등록폼
		map.put("/boardInsert.do", new BoardInsert());			//글 등록완료
		map.put("/boardView.do", new BoardView());				//선택한 글 상세조회
		map.put("/boardEditForm.do",new BoardEditForm());		//선택한 글 수정폼
		map.put("/boardEditSave.do", new BoardEditSave()); 		//글 수정 완료 
		map.put("/boardDelete.do", new BoardDelete());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length());

		Command command = map.get(path);
		String viewPage = command.execute(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}
}