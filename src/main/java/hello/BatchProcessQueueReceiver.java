package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class BatchProcessQueueReceiver {
    @Autowired
    JmsTemplate jmsTemplate;

    private static final Logger logger = LoggerFactory.getLogger(BatchService.class);

    @JmsListener(destination = "batchProcessQueue", containerFactory = "myFactory")
    public void receiveMessage(IOTData data) {
        logger.info("Received <" + data + ">");

        //logic to save data into DB

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Data saved: "+ data);
    }
}
