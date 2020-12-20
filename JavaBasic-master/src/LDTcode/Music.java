package LDTcode;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Music {

	static void PlaySound(File Sound)

	{

		try{

			Clip clip = AudioSystem.getClip();

			clip.open(AudioSystem.getAudioInputStream(Sound));

			clip.start();

			Thread.sleep(clip.getMicrosecondLength()/1000);

		}

		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		{

			

		}

	}



}
