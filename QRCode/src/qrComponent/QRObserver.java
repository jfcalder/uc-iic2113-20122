package qrComponent;

public class QRObserver implements IConsuptionObs{

	QRCode code;
	
	public QRCode getQRCode(){
		return code;
	}

	@Override
	public void consumptionFinished(int resource_id, Object obj) {
		// TODO Auto-generated method stub
		if (obj != null)
			code = (QRCode) obj;
	}

	@Override
	public void consumptionFailed(int resource_id, String error) {
		// TODO Auto-generated method stub
		code = null;
		return;
	}

	@Override
	public void consumptionInterrupted(int resource_id, String error) {
		// TODO Auto-generated method stub
		return;
	}

}
