package co.hj.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.hj.board.common.Command;
import co.hj.board.dao.BoardDAO;
import co.hj.board.vo.BoardVO;

public class BoardEditSave implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 글 수정
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setbId(Integer.parseInt(request.getParameter("bId")));
		vo.setbContent(request.getParameter("bContent"));
		
		int n = dao.update(vo);
		String viewPage = null;
		
//		if(n != 0) {	
//			String message="입력한 내용이 정상 수정되었습니다. ";
//			request.setAttribute("mag", message);
//			viewPage = "boardList.do";
//		}
		
		return viewPage;
	}

}
