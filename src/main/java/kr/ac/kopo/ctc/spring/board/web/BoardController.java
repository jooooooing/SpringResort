package kr.ac.kopo.ctc.spring.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.ctc.spring.board.domain.Board;
import kr.ac.kopo.ctc.spring.board.service.BoardService;
import kr.ac.kopo.ctc.spring.board.service.BoardServiceImpl;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
//	@RequestMapping("/testBoardList")
//	public String testBoardList(Model model) {
//		List<Board> boardList = new ArrayList<Board>();
//		
//		for (int i = 0; i <9; i++) {
//			Board board = new Board();
//			board.setSeq(new Long(i));
//			board.setTitle("제목 " + i);
//			board.setWriter("작성자 " + i);
//			board.setContent("글내용 " + i);
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			boardList.add(board);
//		}
//		model.addAttribute("boardList", boardList);
//		return "testBoardList";
//	}
	
	//게시글 전체조회
	@RequestMapping("/getBoardList")
	public String getBoardList(Model model, Board board) {
		List<Board> boardList = boardService.getBoardList(board);
		model.addAttribute("boardlist", boardList);
		return "getBoardList";
	}
	
//	글쓰기 화면 
//	@return
	
	@RequestMapping("/insertBoardView")
	public String insertBoardView() {
		return "insertBoardView";
	}
	
//	글쓰기 처리
//	@param board
//	@return
	
	@RequestMapping("/insertBoard")
	public String insertBoard(Board board) {
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}

}
