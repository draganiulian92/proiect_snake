package proiect_snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Game
implements KeyListener{
	private Snake player;
	private Food food;
	private Graphics graphics;
	
	private JFrame window;
	public static final int height = 35;
	public static final int width = 35;
	public static final int dimension =20;
	
	public Game() {
		
		window = new JFrame();
		
		
		player = new Snake();
		food = new Food(player);
		graphics = new Graphics(this);
		
		
		window.add(graphics);
		
		
		window.setTitle("Snake-Proiect");
		window.setSize(width *dimension, height*dimension);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	public void start() {
		graphics.state = "RUNNING";
	};
	
	public void update() {
		if (graphics.state == "RUNNING") {
			if(check_food_colission()) {
				player.grw();
				food.randSpawn(player);
			}
			else if(check_wall_colission()||self_collision()) {
				graphics.state = "END";
			}
			else {
				player.move();
			}
		}
	}
	
	private boolean check_wall_colission() {
		if(player.getX()<0 || player.getX()>= width*dimension || player.getY()<0||player.getY()>=height*dimension) {
			return true;
		}
		return false;
	}
	
	private boolean check_food_colission() {
		if(player.getX() == food.getX()*dimension && player.getY() == food.getY()*dimension ) {
			return true;
		}
		return false;
		
	}
	
	private boolean self_collision() {
		for(int i = 1; i<player.getBody().size(); i++) {
			if(player.getX() ==player.getBody().get(i).x && player.getY() == player.getBody().get(i).y) 
			{
				return true;
			}
		}
		return false;
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		int keyCode = arg0.getKeyCode();
		
		
		if(graphics.state == "RUNNING") {
			if (keyCode == KeyEvent.VK_UP){
				player.up();
			}
			else if (keyCode == KeyEvent.VK_DOWN){
				player.down();
			}
			else if (keyCode == KeyEvent.VK_LEFT){
				player.left();
			}
			else if (keyCode == KeyEvent.VK_RIGHT){
				player.right();
			};
		
		}
		else {
			this.start();
		}
	}

	public Snake getPlayer() {
		return player;
	}

	public void setPlayer(Snake player) {
		this.player = player;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public JFrame getWindow() {
		return window;
	}

	public void setWindow(JFrame window) {
		this.window = window;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
