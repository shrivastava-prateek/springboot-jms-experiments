package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
public class BatchService {

    @Autowired
    JmsTemplate jmsTemplate;

    private static final Logger logger = LoggerFactory.getLogger(BatchService.class);

    public void processBatch(List<IOTData> iotDataList){

        for(IOTData data : iotDataList){
            logger.info("Batch Service-process batch Thread name: "+Thread.currentThread().getName());
            jmsTemplate.convertAndSend("batchProcessQueue", data);
        }



    }
}
