package sar.pkg.games;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sar.pkg.games.ai.OhhmokAI;
import sar.pkg.games.vo.Dots;

@Controller
public class GameController {
	
	
	@RequestMapping(value="/makeItClean", method = RequestMethod.GET)
	public String makeItClean() {
		
		return "/games/makeItClean/makeItClean";
	}
	
	@RequestMapping(value="/ohhmok", method = RequestMethod.GET)
	public String ohhmok() {	
		
		return "/games/ohhmok/ohhmok";
	}
	
	@RequestMapping(value="/p1PointClicked", method=RequestMethod.GET)
	public String p1PointClicked(int j, int i,HttpSession session) {
		ArrayList<Dots> dlist = (ArrayList<Dots>)session.getAttribute("dlist");
		if (session.getAttribute("dlist") == null) {
			dlist = new ArrayList<Dots>();
			session.setAttribute("dlist", dlist);
		}
		
		Dots dots = new Dots(j, i, 1, 0, 0, 0, 0, 0, true);
		
		dlist.add(dots);
		
		OhhmokAI ai = new OhhmokAI();
		dlist.add(ai.react(dlist));
		
		return "/games/ohhmok/ohhmok";
	}
	
	@RequestMapping(value="/p2PointClicked", method=RequestMethod.GET)
	public String p2PointClicked(int j, int i,HttpSession session) {
		ArrayList<Dots> dlist = (ArrayList<Dots>)session.getAttribute("dlist");
		if (session.getAttribute("dlist") == null) {
			dlist = new ArrayList<Dots>();
			session.setAttribute("dlist", dlist);
		}

		if (((String)session.getAttribute("color")) == null) {
			session.setAttribute("color", "black");
			dlist.add(new Dots(j, i, 1, 0, 0, 0, 0, 0, true));
		}else if (((String)session.getAttribute("color")).equals("black")) {
			session.setAttribute("color", "white");
			dlist.add(new Dots(j, i, -1, 0, 0, 0, 0, 0, true));
		}else {
			session.setAttribute("color", "black");
			dlist.add(new Dots(j, i, 1, 0, 0, 0, 0, 0, true));
		}
		
		int check = new OhhmokAI().doesBlackWin(dlist);
		
		System.out.println(check);
		
		if (check == 1) {
			session.setAttribute("win", "Black");
		}else if (check == -1) {
			session.setAttribute("win", "White");
		}
		
		return "/games/ohhmok/ohhmok";
	}
	
	@RequestMapping("/resetOhhmok")
	public String resetOhhmok(HttpSession session) {
		session.removeAttribute("win");
		session.removeAttribute("dlist");
		session.removeAttribute("color");
		return "/games/ohhmok/ohhmok";
	}
}
