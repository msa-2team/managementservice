package roomreservation;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Management_table")
public class Management {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String reserveId;
    private String status;

    @PostPersist
    public void onPostPersist(){

        RoomConfirmed roomConfirmed = new RoomConfirmed();
        BeanUtils.copyProperties(this, roomConfirmed);
        roomConfirmed.publish();


    }

    @PostRemove
    public void onPostRemove(){
        RoomRejected roomRejected = new RoomRejected();
        BeanUtils.copyProperties(this, roomRejected);
        roomRejected.publish();


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getReserveId() {
        return reserveId;
    }

    public void setReserveId(String reserveId) {
        this.reserveId = reserveId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
