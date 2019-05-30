package rst.assets;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public abstract class AssetRegistry<T extends Asset> extends SwingWorker<T[],String> {

	private final String asset, extension;
	private final String[] items;
	private final JProgressBar progress;
	
	private Map<String, T> assets;
	
	protected AssetRegistry(JProgressBar progress, String asset, String extension, String[] items) {
		this.progress = progress;
		this.asset = asset;
		this.extension = extension;
		this.items = items;
		
		progress.setMinimum(0);
		progress.setMaximum(100);
		progress.setValue(0);
		addPropertyChangeListener((property) -> {
			if(property.getPropertyName().equals("progress")) {
				progress.setValue((Integer)property.getNewValue());
			}
		});
	}
	
	@Override
	protected T[] doInBackground() throws Exception {
		T[] t = newArray(items.length);
		
		for(int i = 0; i < t.length; i++) {
			String loc = "/resources/" + asset + "s/" + items[i] + "." + extension;
			
			t[i] = load(items[i], this.getClass().getResourceAsStream(loc));
			publish(loc);
			setProgress((int) (100.0 * (i+1) / t.length + 0.5));
		}
		
		return t;
	}
	
	@Override
	protected void process(List<String> chunks) {
		progress.setString((chunks.get(chunks.size() - 1)));
	}
	
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
		progress.setVisible(false);
	}
	
	protected abstract T[] newArray(int length);
	protected abstract T load(String name, InputStream in) throws IOException;

	public T get(String name) {
		T result = null;
		
		if(assets != null) {
			result = assets.get(name);
		}
		
		return result;
	}
}
