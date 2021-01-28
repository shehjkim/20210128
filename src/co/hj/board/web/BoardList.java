package co.hj.board.web;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.hj.board.common.Command;
import co.hj.board.dao.BoardDAO;
import co.hj.board.vo.BoardVO;

public class BoardList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		list = dao.selectList();
		
		request.setAttribute("list", list);
		
		String viewPage = "views/board/boardList.jsp";
		
		return viewPage;
	
		}

	
}
