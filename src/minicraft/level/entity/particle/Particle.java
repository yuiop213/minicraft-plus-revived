package minicraft.level.entity.particle;

import minicraft.level.entity.Entity;
import minicraft.gfx.Screen;
import minicraft.gfx.Sprite;

public class Particle extends Entity {
	private int time; // lifetime elapsed.
	private int lifetime;
	
	protected Sprite sprite;
	
	public Particle(int x, int y, int xr, int lifetime, Sprite sprite) {
		// make a particle at the given coordinates
		super(xr, 1);
		this.x = x;
		this.y = y;
		this.lifetime = lifetime;
		this.sprite = sprite;
		time = 0;
	}
	public Particle(int x, int y, int lifetime, Sprite sprite) {
		this(x, y, 1, lifetime, sprite);
	}

	public void tick() {
		time++;
		if(time > lifetime) {
			remove();
		}
	}

	public void render(Screen screen) { sprite.render(screen, x, y); }
	
	@Override
	public boolean isSolid() { return false; }
}