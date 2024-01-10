package cleanCode.errorHandling;


import static cleanCode.errorHandling.DeviceHandle.*;

public class DeviceController {

    public void sendShutDown() {
        try {
            tryToShutDown();
        } catch (DeviceShutDownError e) {
            throw new DeviceShutDownError(e.getMessage());
        }
    }

    private void tryToShutDown() throws DeviceShutDownError{
        DeviceHandle handle = DeviceHandle.getHandle("DEV1");
        DeviceRecord record = retrieveDeviceRecord(handle);
        pauseDevice(handle);
        clearDeviceWorkQueue(handle);
        closeDevice(handle);
    }

    private void closeDevice(DeviceHandle handle) {
    }

    private void clearDeviceWorkQueue(DeviceHandle handle) {
    }

    private void pauseDevice(DeviceHandle handle) {
    }

    private DeviceRecord retrieveDeviceRecord(DeviceHandle handle) {
        return new DeviceRecord();
    }
}