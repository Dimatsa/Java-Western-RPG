package rst.assets;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.SwingWorker;

public class Sound extends Asset {
	
	private final byte[] data;
	private final AudioFormat audioFormat;
	
	private SwingWorker<Clip, Void> asyncClip;
	
	Sound(String name, InputStream in) {
		super(name);
		
        AudioInputStream ais;
        
        byte[] data = null;
        AudioFormat audioFormat = null;
		try {
			ais = AudioSystem.getAudioInputStream(in);

	        data = new byte[ais.available()];
	        ais.read(data);
	        audioFormat = ais.getFormat();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
		
		this.data = data;
		this.audioFormat = audioFormat;
		
		asyncLoad();
		
		try {
			asyncClip.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	public byte[] getData() {
		return data;
	}

	public AudioFormat getAudioFormat() {
		return audioFormat;
	}
	
	public Clip startSound(double volume, int loops) {
		Clip clip = null;
		try {
			clip = asyncClip.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		asyncLoad();
		
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);        
		gainControl.setValue(20f * (float) Math.log10(volume));
		
		clip.setMicrosecondPosition(0);
		
		if(loops == 0) {
			clip.start();
		}
		else {
			clip.loop(loops);
		}
		
		return clip;
	}
	
	private Clip createClip() throws LineUnavailableException {
		Clip clip = AudioSystem.getClip();
		clip.open(getAudioFormat(), getData(), 0, getData().length);
		
		return clip;
	}
	
	private void asyncLoad() {
		asyncClip = new SwingWorker<Clip, Void>() {
			@Override
			protected Clip doInBackground() throws Exception {
				return createClip();
			}
		};
        
		asyncClip.execute();
	}
}
