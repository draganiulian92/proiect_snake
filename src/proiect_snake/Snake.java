package proiect_snake;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Snake {
	private ArrayList<Rectangle> body;
	private int w = Game.width;
	private int h = Game.height;
	private int d = Game.dimension;
	
	private String move;
	
	public Snake() {
		body = new ArrayList<>();
		Rectangle temp = new Rectangle(d,d);
		temp.setLocation(w / 2 * d, h/2*d );
		body.add(temp);
		
		temp = new Rectangle(d,d);
		temp.setLocation((w/2-1)*d, (h/2-1)*d );
		body.add(temp); 
		
		move = "NOTHING";
		
	}
	
	public void move() {
		if(move != "NOTHING") {
			Rectangle first = body.get(0);
			Rectangle temp = new Rectangle(d,d);
			
			if(move == "UP") {
				temp.setLocation(first.x, first.y - d);
			}
			else if(move == "DOWN") {
				temp.setLocation(first.x, first.y + d);
			}
			else if(move == "LEFT") {
				temp.setLocation(first.x -d , first.y);
			}
			else if(move == "RIGHT") {
				temp.setLocation(first.x + d, first.y );
			}
			
			body.add(0, temp);
			body.remove(body.size()-1);
		}	
	}
	
	public void grw() {
			Rectangle first = body.get(0);
			Rectangle temp = new Rectangle(d,d);
			
			if(move == "UP") {
				temp.setLocation(first.x, first.y - d);
			}
			else if(move == "DOWN") {
				temp.setLocation(first.x, first.y + d);
			}
			else if(move == "LEFT") {
				temp.setLocation(first.x -d , first.y);
			}
			else if(move == "RIGHT") {
				temp.setLocation(first.x + d, first.y );
			}
			
			body.add(0, temp);
		}	
	
	

	public ArrayList<Rectangle> getBody() {
		return body;
	}

	public void setBody(ArrayList<Rectangle> body) {
		this.body = body;
	}
	
	public void up() {
		move = "UP";
	};
	public void down() {
		move = "DOWN";
	};
	public void left() {
		move = "LEFT";
	};
	public void right() {
		move = "RIGHT";
	};


	public String getMove() {
		return move;
	}
	
	public int getX() {
		return body.get(0).x;
	};
	public int getY() {
		return body.get(0).y;
	};
}
