/*
 * AssetRegistry.java
 * Keeps track of assets
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.assets;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

import javax.swing.SwingWorker;

public abstract class AssetRegistry<T extends Asset> extends SwingWorker<T[],String> {

	private static Textures textures;
	private static Sounds sounds;
	private static Fonts fonts;
	
	/**
	 * Initializes textures
	 * pre: none 
	 * post: has been initialized
	 */
	public static void init() {
		if(textures == null && sounds == null && fonts == null) {
			textures = new Textures();
			sounds = new Sounds();
			fonts = new Fonts();
			
			textures.execute();
			sounds.execute();
			fonts.execute();
		}
	}
	
	/**
	 * Retrieves textures
	 * pre: none
	 * post: retrieves textures
	 */
	public static Textures getTextures() {
		init();
		return textures;
	}

	/**
	 * Retrieves sounds
	 * pre: none
	 * post: sounds have been retrieved
	 */
	public static Sounds getSounds() {
		init();
		return sounds;
	}

	/**
	 * Retrieves font
	 * pre: none
	 * post: fonts have been sent
	 */
	public static Fonts getFonts() {
		init();
		return fonts;
	}

	private final String asset, extension;
	private final String[] items;
	
	private Map<String, T> assets;
	
	private Set<Runnable> loadingCallbacks;
	private Set<Consumer<String>> processCallbacks;
	
	/**
	 * Constructor
	 * pre: assets
	 * post: registry has been created
	 */
	protected AssetRegistry(String asset, String extension, String[] items) {
		this.asset = asset;
		this.extension = extension;
		this.items = items;
		
		this.loadingCallbacks = new HashSet<>();
		this.processCallbacks = new HashSet<>();
	}
	
	/**
	 * Does stuff in background
	 * pre: none
	 * post: code has been executed
	 */
	@Override
	protected T[] doInBackground() throws Exception {
		T[] t = newArray(items.length);
		
		for(int i = 0; i < t.length; i++) {
			String loc = "/" + asset + "s/" + items[i] + "." + extension;
			
			t[i] = load(items[i], this.getClass().getResourceAsStream(loc));
			publish(loc);
			setProgress((int) (100.0 * (i+1) / t.length + 0.5));
		}
		
		return t;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	protected void process(List<String> chunks) {
		String latest = chunks.get(chunks.size() - 1);
		processCallbacks.forEach(callback -> callback.accept(latest));
	}
	
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	protected void done() {
		HashMap<String, T> assets = new HashMap<>();
		
		try {
			T[] items = get();
			
			for(int i = 0; i < items.length; i++) {
				assets.put(this.items[i], items[i]);
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		this.assets = Collections.unmodifiableMap(assets);
		
		loadingCallbacks.forEach(Runnable::run);
	}
	
	protected abstract T[] newArray(int length);
	protected abstract T load(String name, InputStream in) throws IOException;
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public T get(String name) {
		T result = null;
		
		if(assets != null) {
			result = assets.get(name);
		}
		
		return result;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public void onLoad(Runnable callback) {
		loadingCallbacks.add(callback);
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public void onBatch(Consumer<String> callback) {
		processCallbacks.add(callback);
	}
}
