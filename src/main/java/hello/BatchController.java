package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("batch")
public class BatchController {

    @Autowired
    BatchService batchService;


    private static final Logger logger = LoggerFactory.getLogger(BatchController.class);

    @PostMapping("/submit")
    Object submitBatch(@RequestBody IOTDataList iotDataList) {

        logger.info("Batch Controller  Thread name: "+Thread.currentThread().getName());
        batchService.processBatch(iotDataList.getIotDataList());

        String response = "success";
        return response;
    }
}
