package hello;

import java.util.List;

public class IOTDataList {

    private List<IOTData> iotDataList;

    public IOTDataList() {
    }

    public IOTDataList(List<IOTData> iotDataList) {
        this.iotDataList = iotDataList;
    }

    public List<IOTData> getIotDataList() {
        return iotDataList;
    }

    public void setIotDataList(List<IOTData> iotDataList) {
        this.iotDataList = iotDataList;
    }
}
