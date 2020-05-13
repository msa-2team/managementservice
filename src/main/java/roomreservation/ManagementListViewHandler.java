package roomreservation;

import roomreservation.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ManagementListViewHandler {


    @Autowired
    private ManagementListRepository managementListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReserved_then_CREATE_1 (@Payload Reserved reserved) {
        try {
            if (reserved.isMe()) {
                // view 객체 생성
                ManagementList managementList = new ManagementList();
                // view 객체에 이벤트의 Value 를 set 함
                managementList.setReserveId(reserved.getReserveId());
                // view 레파지 토리에 save
                managementListRepository.save(managementList);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
