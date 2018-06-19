package utility;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.testng.TestException;

public class Library{

	public static void screenshort(String shreenshortname) {

		try {
			Robot r = new Robot();

			// Taking screenshots of alert pop-ups and the failed scripts and storing it
			// into the temporary place
			// called BufferedImage (bi)
			BufferedImage bi = r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

			// Moving the screenshots from source to destination of png format
			ImageIO.write(bi, "png", new File(".\\target\\"+shreenshortname+".png"));
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public static  void attachement(String screenshotname)
	{
		screenshort(screenshotname);
		
		EmailAttachment email=new EmailAttachment();
		
		email.setPath(".\\target\\"+screenshotname+".png");
		
		email.setDisposition(EmailAttachment.ATTACHMENT);
		
		email.setDescription("Failed screenshort of branch creation");
		
		email.setName("screenshort");
		
		MultiPartEmail memail=new MultiPartEmail();
		
		
		try {
			memail.setAuthenticator(new DefaultAuthenticator("enr.rajatshandilya@gmail.com", "lakhesar"));
			memail.setHostName("smtp.gmail.com");
			memail.setSmtpPort(587);
			memail.setSSLOnConnect(true);
			memail.setFrom("enr.rajatshandilya@gmail.com");
			
			memail.setSubject("failure report");
			memail.setMsg("this screenshot belongs to ...");
			memail.addTo("luckyshandilya26071989@gmail.com");
			memail.attach(email);
			
			memail.send();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
}
