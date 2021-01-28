package co.hj.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.hj.board.common.Command;
import co.hj.board.dao.BoardDAO;
import co.hj.board.vo.BoardVO;

public class BoardDelete implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 글 삭제
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
	
		vo.setbId(Integer.parseInt(request.getParameter("bId")));		
		int n = dao.delete(vo);
		String viewPage = "boardList.do";
		
		if(n == 0) 
				viewPage = "views/board/boardDeleteFail.jsp";
		
		return "boardList.do";
	}

}
