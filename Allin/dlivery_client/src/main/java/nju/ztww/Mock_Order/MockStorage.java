package nju.ztww.Mock_Order;

public class MockStorage {
	private String storageName;
	private String storageInfo;

	public MockStorage(String storageName, String storageInfo) {
		this.storageInfo = storageInfo;
		this.storageName = storageName;

	}

	public String getStorageName() {
		return storageName;
	}

	public String getStorageInfo() {
		return storageInfo;
	}

}
