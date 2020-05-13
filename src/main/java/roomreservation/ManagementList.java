package roomreservation;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ManagementList_table")
public class ManagementList {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String reserveId;


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

}
