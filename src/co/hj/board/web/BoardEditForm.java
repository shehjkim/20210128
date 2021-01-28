package co.hj.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.hj.board.common.Command;
import co.hj.board.dao.BoardDAO;
import co.hj.board.vo.BoardVO;

public class BoardEditForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setbId(Integer.parseInt(request.getParameter("bId")));
		
		vo = dao.select(vo);
		request.setAttribute("vo", vo);
		String viewPage="views/board/boardEditForm.jsp";
		
		return viewPage;
	}

}
