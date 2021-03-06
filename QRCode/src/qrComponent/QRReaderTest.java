package qrComponent;
import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;

import qrComponent.QRCode;
import qrComponent.QRObserver;
import qrComponent.QRReader;
import qrComponent.IResource;


public class QRReaderTest {

	private IResource qr;
	private QRObserver observer;
	private byte[] data;

	@Before
	public void setUp() throws Exception {
		qr = new QRReader();
		observer = new QRObserver();
		qr.setObserver(observer);
	}
	
	public byte[] convertImageToByte(String path) {
		try
		{
			File file = new File(path);
			BufferedImage image = ImageIO.read(file);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "png", baos);
			byte[] res = baos.toByteArray();
			return res;
		}
		catch (Exception e)
		{
			System.out.println("No se ha podido leer la imagen de prueba");
			e.printStackTrace();
			return null;
		}
	}

	@Test
	public void readTextText() {
		File relative = new File("CodigosQR/TextQR.png");
		String path = relative.getAbsolutePath();
		data = convertImageToByte(path);
		qr.reciveAction(data, 0);
		QRCode code = (QRCode)observer.getQRCode();
		assertEquals("IIC - Diseño Detallado de Software", code.getText());
	}
	
	@Test
	public void readTextType() {
		File relative = new File("CodigosQR/TextQR.png");
		String path = relative.getAbsolutePath();
		data = convertImageToByte(path);
		qr.reciveAction(data, 0);
		QRCode code = (QRCode)observer.getQRCode();
		assertEquals("TEXT", code.getType());
	}
	
	@Test
	public void readSMSText() {
		File relative = new File("CodigosQR/SMSQR.png");
		String path = relative.getAbsolutePath();
		data = convertImageToByte(path);
		qr.reciveAction(data, 0);
		QRCode code = (QRCode)observer.getQRCode();
		assertEquals("SMSTO:+56988338752:A José Francisco le gusta programar.", code.getText());
	}
	
	@Test
	public void readSMSType() {
		File relative = new File("CodigosQR/SMSQR.png");
		String path = relative.getAbsolutePath();
		data = convertImageToByte(path);
		qr.reciveAction(data, 0);
		QRCode code = (QRCode)observer.getQRCode();
		assertEquals("SMS", code.getType());
	}

	@Test
	public void readPhoneNumberText() {
		File relative = new File("CodigosQR/PhoneNumberQR.png");
		String path = relative.getAbsolutePath();
		data = convertImageToByte(path);
		qr.reciveAction(data, 0);
		QRCode code = (QRCode)observer.getQRCode();
		assertEquals("TEL:", code.getText());
	}
	
	@Test
	public void readPhoneNumberType() {
		File relative = new File("CodigosQR/PhoneNumberQR.png");
		String path = relative.getAbsolutePath();
		data = convertImageToByte(path);
		qr.reciveAction(data, 0);
		QRCode code = (QRCode)observer.getQRCode();
		assertEquals("TEL", code.getType());
	}
	
	@Test
	public void readWebText() {
		File relative = new File("CodigosQR/WebQR.png");
		String path = relative.getAbsolutePath();
		data = convertImageToByte(path);
		qr.reciveAction(data, 0);
		QRCode code = (QRCode)observer.getQRCode();
		assertEquals("http://www.uc.cl", code.getText());
	}
	
	@Test
	public void readWebType() {
		File relative = new File("CodigosQR/WebQR.png");
		String path = relative.getAbsolutePath();
		data = convertImageToByte(path);
		qr.reciveAction(data, 0);
		QRCode code = (QRCode)observer.getQRCode();
		assertEquals("URI", code.getType());
	}
	
	@Test (expected = NullPointerException.class)
	public void readNonQRCode() {
		File relative = new File("CodigosQR/PUCIcon.png");
		String path = relative.getAbsolutePath();
		data = convertImageToByte(path);
		qr.reciveAction(data, 0);
		QRCode code = (QRCode)observer.getQRCode();
		code.getText();
		code.getType();
	}
	
}
