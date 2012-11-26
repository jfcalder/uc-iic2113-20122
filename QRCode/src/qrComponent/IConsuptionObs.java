package qrComponent;

public interface IConsuptionObs {
	public void consumptionFinished(int resource_id, Object obj);
	public void consumptionFailed(int resource_id, String error);
	public void consumptionInterrupted(int resource_id, String error);
}
